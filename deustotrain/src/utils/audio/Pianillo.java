package utils.audio;

import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.sound.sampled.*;

/**
 *  Clase con capacidad básica para reproducir audio basado en frecuencia,
 *  con posibilidad de reproducir varios tonos de forma paralela ("canales").<br>
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class Pianillo {

    /**
     * Prueba de clase - toca escala y los acordes básicos del Canon de Pachelbel
     * @param args No utilizado
     */
    public static void main(String[] args) {
        int[] escala = { 0, 2, 4, 5, 7, 9, 11, 12 };  // Salto de semitonos de una escala

        double notaDO = frecuenciaNota( "DO", 4 );

        // Prueba 1. Reproducir canción cargada de fichero (wav o au)
        String fichero = Pianillo.class.getResource( "efecto.wav" ).getFile();
        double[] audioDesdeFich = Pianillo.read( fichero );
        Pianillo.mandaSonido( 0, audioDesdeFich );
        
        // Prueba 2. Escala normal (1 canal)
        for (int i = 0; i < escala.length; i++) {
        	double nota = anyadeSemitonos( notaDO, escala[i] );
            Pianillo.mandaSonido( 0, samplesDeNota(nota, 0.5, 0.5) );
        }
        while (Pianillo.haySamplesSonando()) { Pianillo.esperaMilis( 1000 ); }
        Pianillo.esperaSegs( 1.0 );
        
        // Prueba 3. Canción de acordes (3 canales - 3 notas por acorde) 
        // Base de canon de Pachelbel
        int[] acordeMayor = { 0, 4, 7 };  // Semitonos de salto de las tres notas de un acorde mayor
        int[] acordeMenor = { 0, 3, 7 };  // Semitonos de salto de las tres notas de un acorde menor
        String[] acordes =          {  "DO" , "SOL", "LA" , "MI" , "FA" , "DO" , "FA" , "SOL" };
        int[] numOctava =           {   4   ,   4  ,  4   ,  4   ,  4   ,  4   ,  4   ,   4   };
        boolean[] mayoresOMenores = {   true,  true, false, false,  true,  true,  true,  true };
        double[] duraciones =       {  1.0  ,  1.0 ,  1.0 ,  1.0 ,  1.0 ,  1.0 ,  1.0 ,  1.0  };
        for (int i = 0; i < acordes.length; i++) {
        	double nota = frecuenciaNota( acordes[i], numOctava[i] );
        	// Quitar los silencios si se quiere arpegiar
        	// Pianillo.mandaSilencio( 1, 0.2 );
        	// Pianillo.mandaSilencio( 2, 0.4 );
        	for (int j = 0; j<3; j++) {
        		boolean tipoAcorde = mayoresOMenores[j];
        		int salto = tipoAcorde ? acordeMayor[j] : acordeMenor[j];
                Pianillo.mandaSonido( j, 
                		samplesDeNota( anyadeSemitonos( nota, salto ), duraciones[i], 0.5 ) );
                Pianillo.mandaSilencio( j, 0.1 );
        	}
            // Pianillo.mandaSilencio( 0, 0.4 );
        	// Pianillo.mandaSilencio( 1, 0.2 );
        }
        while (Pianillo.haySamplesSonando()) { Pianillo.esperaSegs( 1.0 ); }
        Pianillo.esperaSegs( 1.0 );
        
        // Hay que llamar a esta rutina para cerrar todo el sistema de sonido, si no
        // el programa seguirá funcionando
        Pianillo.closeCuandoSeAcabe();
        
        // También se podría hacer
        // while (Pianillo.haySamplesSonando()) { Pianillo.esperaMilis( 1000 ); }
        // Pianillo.close(); 
    }
    
    // Atributos
    
	public static final int NUMERO_DE_CANALES = 16;               // Número de canales paralelos (0 - n-1) 
    public static final int SAMPLES_POR_SEG = 44100;              // Sample rate - muestras por segundo (44.100 Hz - calidad CD)
    public static final int FADE_IN_OUT = 2000;                   // Número de samples que se aplican de fade in y de fade out
    public static final int MINIMO_PARA_FADE = 8000;              // Número de samples mínimos con los que se aplica un fade
    private static final int BYTES_POR_SAMPLE = 2;                // Audio 16 bits (= 2 bytes)
    private static final int BITS_POR_SAMPLE = 16;                // Bits por muestra (calidad CD)
    private static final double MAX_16_BITS = Short.MAX_VALUE;    // 32767
    private static final int SAMPLE_BUFFER_SIZE = 4096;           // Buffer utilizado
    
	// Atributos para el cálculo de notas musicales
	public static String[] NOTAS_MUSICALES = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
	private static ArrayList<String> notas = new ArrayList<>( Arrays.asList( NOTAS_MUSICALES ) );    // Notas con refencia en LA
	private static ArrayList<String> notasAlt = new ArrayList<>( Arrays.asList( new String[] { "DO", "REb", "RE", "MIb", "MI", "FA", "SOLb", "SOL", "LAb", "LA", "SIb", "SI" } ) ); // Notas alternativas (bemol)
	private static double frecBase = 220.0 * Math.pow( 2, 3 / 12.0 );  // Frecuencia de DO octava 4 (LA3 + 3 semitonos)
    
    private static SourceDataLine[] line;           // Líneas de datos donde mandar los sonidos (una por canal)
    private static byte[][] buffer;                 // Buffers internos
    private static int bufferSize[];                // Número de samples actualmente en los buffers internos
    private static Vector<SamplesPendientes>[] vsp; // Vectores de samples pendientes de reproducir por cada canal
    private static boolean seguirHilos;             // Variable booleana de final de hilos

    private Pianillo() {}  // Clase static no instanciable

    // Inicializador estático (inicializa líneas de sonido)
    static {
        init();
    }

    // open up an audio stream
    @SuppressWarnings("unchecked")
	private static void init() {
        try {
            bufferSize = new int[NUMERO_DE_CANALES];
            line = new SourceDataLine[NUMERO_DE_CANALES];
            buffer = new byte[NUMERO_DE_CANALES][SAMPLE_BUFFER_SIZE * BYTES_POR_SAMPLE/3];
            vsp = new Vector[NUMERO_DE_CANALES];
            // 44,100 samples por segundo, audio 16bits, mono, PCM con signo, little Endian
            AudioFormat format = new AudioFormat((float) SAMPLES_POR_SEG, BITS_POR_SAMPLE, 1, true, false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            seguirHilos = true;
            for (int canal=0; canal<NUMERO_DE_CANALES; canal++) {
                bufferSize[canal] = 0;    // Número de samples actualmente en los buffers internos
                line[canal] = (SourceDataLine) AudioSystem.getLine(info);
                line[canal].open(format, SAMPLE_BUFFER_SIZE * BYTES_POR_SAMPLE);
	            line[canal].start(); // Inicio de sonido 
	            vsp[canal] = new Vector<SamplesPendientes>(); // Inicio de vector de samples pendientes
	            HiloCanal hilo = new HiloCanal(canal);
	            hilo.start(); // Inicio de hilo que reproduce el sonido del canal correspondiente
            }
        }
        catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Cierra el audio (llamar siempre a este método para acabar el programa)
     */
    public static void close() {
    	seguirHilos = false;
    }
    
    /**
     * Cierra el audio (llamar siempre a este método para acabar el programa)
     */
    public static void closeCuandoSeAcabe() {
        while (Pianillo.haySamplesSonando()) { Pianillo.esperaMilis( 1000 ); }
        close();
    }
    
    /**
     * Manda un sample a la salida de sonido.
     * @param canal	Número de canal a reproducir
     * @param  sample Sample a enviar
     * @throws IllegalArgumentException si el sample es {@code Double.NaN}
     */
    public static void mandaSample(int canal, double sample) {
    	// El play real lo hace el hilo. Este play solo alimenta a la estructura de datos
    	vsp[canal].add( new SamplesPendientes( new double[] { sample } ) );
    }

    /**
     * Envía sonido (array de samples) a la salida de audio.
     * El sonido se almacena para ser reproducido hasta que acabe la reproducción pendiente.
     * @param canal	Número de canal en el que almacenar el sonido
     * @param samples	Array de samples a enviar (cada uno de ellos entre -1.0 y +1.0)
     * @throws IllegalArgumentException si cualquier sample es {@code Double.NaN}
     * @throws IllegalArgumentException si {@code samples} es {@code null}
     */
    public static void mandaSonido(int canal, double[] samples) {
        if (samples == null) throw new IllegalArgumentException("argument to play() is null");
    	// El play real lo hace el hilo. Este play solo alimenta a la estructura de datos
    	vsp[canal].add( new SamplesPendientes( samples ) );
    }

    /**
     * Envía silencio al canal de sonido indicado
     * @param canal	Número de canal a reproducir
     * @param segundos tiempo de sonido a enviar (en segundos)
     * @throws IllegalArgumentException si el canal es un número inválido
     * @throws IllegalArgumentException si el tiempo es negativo
     */
    public static void mandaSilencio( int canal, double segundos ) {
    	if (segundos<0) throw new IllegalArgumentException("silencio() con tiempo negativo");
        if (canal<0 || canal>=NUMERO_DE_CANALES) throw new IllegalArgumentException("silencio() con canal inválida");
    	// El play real lo hace el hilo. Este play solo alimenta a la estructura de datos
    	vsp[canal].add( new SamplesPendientes( new double[ (int) (SAMPLES_POR_SEG * segundos) ] ) );
    }

    /**
     * Lee samples de audio de un fichero (formato .wav o .au)
     * y los devuelve como un array de samples dobles (entre -1.0 y +1.0)
     * Atención: el fichero debe estar en formato mono, 16bits, 44100Hz, PCM
     * @param  nombreFic Nombre del fichero (con ruta si corresponde)
     * @return Array de muestras
     */
    public static double[] read(String nombreFic) {
        byte[] datos = readByte(nombreFic);
        double[] ret = new double[datos.length/2];
        for (int i = 0; i < datos.length/2; i++) {
            ret[i] = ((short) (((datos[2*i+1] & 0xFF) << 8) + (datos[2*i] & 0xFF))) / ((double) MAX_16_BITS);
        }
        return ret;
    }

	    // Lee un fichero como un array de bytes
	    private static byte[] readByte(String nombreFic) {
	        byte[] datos = null;
	        AudioInputStream ais = null;
	        try {
	        	// Se intenta fichero
	            File file = new File(nombreFic);
	            if (file.exists()) {
	                ais = AudioSystem.getAudioInputStream(file);
	                int bytesALeer = ais.available();
	                datos = new byte[bytesALeer];
	                int bytesLeidos = ais.read(datos);
	                if (bytesALeer != bytesLeidos)
	                    throw new IllegalStateException("truncada lectura en byte " + bytesLeidos + " de " + bytesALeer + " bytes"); 
	            }
	            // y si no URL
	            else {
	                URL url = Pianillo.class.getResource(nombreFic);
	                ais = AudioSystem.getAudioInputStream(url);
	                int bytesALeer = ais.available();
	                datos = new byte[bytesALeer];
	                int bytesLeidos = ais.read(datos);
	                if (bytesALeer != bytesLeidos)
	                    throw new IllegalStateException("truncada lectura en byte " + bytesLeidos + " de " + bytesALeer + " bytes"); 
	            }
	        } catch (IOException e) {
	            throw new IllegalArgumentException("No ha podido abrirse '" + nombreFic + "'", e);
	        } catch (UnsupportedAudioFileException e) {
	            throw new IllegalArgumentException("Formato de audio no soportado: '" + nombreFic + "'", e);
	        }
	        return datos;
	    }

    /** Guarda un array de doubles como un fichero de audio (formato .wav o .au)
     * @param  nombreFic the name of the audio file
     * @param  samples the array of samples
     * @throws IllegalArgumentException if unable to save {@code filename}
     * @throws IllegalArgumentException if {@code samples} is {@code null}
     */
    public static void save(String nombreFic, double[] samples) {
        if (samples == null) throw new IllegalArgumentException("intentado guardar array de dobles nulo");
        // 44,100 samples por segundo, 16 bits, mono, PCM con signo, little Endian
        AudioFormat format = new AudioFormat(SAMPLES_POR_SEG, 16, 1, true, false);
        // Convierte a array de bytes
        byte[] datos = new byte[2 * samples.length];
        for (int i = 0; i < samples.length; i++) {
            int temp = (short) (samples[i] * MAX_16_BITS);
            datos[2*i + 0] = (byte) temp;
            datos[2*i + 1] = (byte) (temp >> 8);
        }
        // Guarda el fichero
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(datos);
            AudioInputStream ais = new AudioInputStream(bais, format, samples.length);
            if (nombreFic.endsWith(".wav") || nombreFic.endsWith(".WAV")) {
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(nombreFic));
            } else if (nombreFic.endsWith(".au") || nombreFic.endsWith(".AU")) {
                AudioSystem.write(ais, AudioFileFormat.Type.AU, new File(nombreFic));
            } else {
                throw new IllegalArgumentException("Formato de audio no soportado (solo wav o au): '" + nombreFic + "'");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("No se ha podido guardar fichero '" + nombreFic + "'", ioe);
        }
    }

    /** Crea una nota musical partiendo de su frecuencia, en forma de samples de audio
     * @param hz	Frecuencia en Hz (por ejemplo 440 Hz = LA central -octava 4-)
     * @param duration	Duración en segundos
     * @param amplitud	Volumen (0 - 1.0)
     * @return	Samples de audio correspondientes a esa nota
     */
    public static double[] samplesDeNota(double hz, double duration, double amplitud) {
    	// Cálculo de corrección de volumen (el oído humano no percibe de forma regular el volumen por frecuencias)
    	// (implementado de forma manual - a la espera de mejora)
    	double corrVolumen = 1.0;
    	if (hz < 277.182631) 
        	corrVolumen = Math.pow( Math.abs( hz - 262.0)*0.004, 12.0) * 52.0 + 6.0;
    	else if (hz <= 739.9888454) 
        	corrVolumen = Math.pow( Math.abs( hz - 275.0), 2.0 ) / 75000.0 + 5.9;
    	else if (hz < 1975.533205)
        	corrVolumen = Math.pow( Math.abs( hz - 1870.0) * 0.0014, 2.0 ) + 0.5;
    	else 
    		corrVolumen = Math.pow( Math.abs( hz - 3135.0) * 0.0011, 1.2 ) * 0.125 + 0.25;
    	// Cálculo de una senoidal pura de valores double con la frecuencia de la nota
        int n = (int) (SAMPLES_POR_SEG * duration);
        double[] ret = new double[n+1];
        for (int i = 0; i <= n; i++) {
        	double vol = amplitud;
        	if (n > FADE_IN_OUT*4 && i < FADE_IN_OUT) vol = amplitud * i / 2000; // Fadein de entrada de audio
        	else if (n > FADE_IN_OUT*4 && i >= n-FADE_IN_OUT) vol = amplitud * (n-1-i) / 2000; // Fadeout de salida de audio
            ret[i] = vol * Math.sin(2 * Math.PI * i * hz / SAMPLES_POR_SEG) * corrVolumen;
        }
        return ret;
    }

    /** Devuelve la frecuencia de una nota referida a una octava de piano estándar
     * https://es.wikipedia.org/wiki/Frecuencias_de_afinaci%C3%B3n_del_piano
     * @param nombreNota	Nombre de la nota: "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"  (también bemoles: "REb", "MIb", etc.)
     * @param numOctava	Número de octava, de 0 a 8 (notación anglosajona: 440 Hz = LA octava 4)
     * @return	Frecuencia de la nota indicada, 0 si la nota es errónea
     */
    public static double frecuenciaNota( String nombreNota, int numOctava ) {
    	nombreNota = nombreNota.toUpperCase();
    	int posiSemitono = notas.indexOf( nombreNota );
    	if (posiSemitono==-1) posiSemitono = notasAlt.indexOf( nombreNota );
    	posiSemitono += (numOctava-4) * 12; // Mueve octavas
    	return frecBase * Math.pow( 2, posiSemitono / 12.0 );
    }
    
    public static double anyadeSemitonos( double notaRef, int numSemitonos ) {
    	return notaRef * Math.pow( 2, numSemitonos / 12.0 );
    }
    

    /** Informa si hay música sonando en cualquiera de los canales.
     * @return	true si hay música sonando en cualquier canal, false si todas están sin trabajo
     */
    public static boolean haySamplesSonando() {
    	for (Vector<SamplesPendientes> v : vsp) {
    		if (!v.isEmpty()) return true;
    	}
    	return false;
    }
    
    /** Espera los milisegundos indicados
     * @param ms	Número de milisegundos a esperar
     */
    public static void esperaMilis( long ms ) {
    	try { Thread.sleep( ms ); } catch (InterruptedException e) {}
    }

    /** Espera los segundos indicados
     * @param segs	Número de segundos a esperar
     */
    public static void esperaSegs( double segs ) {
    	try { Thread.sleep( (int) (segs * 1000) ); } catch (InterruptedException e) {}
    }


    // Clases internas para gestionar los hilos que reproducen la música de forma paralela (uno por canal)
    private static class SamplesPendientes {
    	double[] samples;
    	SamplesPendientes( double[] samples ) { this.samples = samples; }
    }
    private static class HiloCanal extends Thread {
    	private int canal;
    	HiloCanal( int canal ) {
    		this.canal = canal;
    	}
    	@Override
    	public void run() {
    		while (seguirHilos) {
    			if (vsp[canal].isEmpty()) {
    				// Si el canal se para, mandar los samples pendientes hasta vaciar el buffer antes de espera
    	            if (bufferSize[canal] >= 0) {
    	                line[canal].write(buffer[canal], 0, bufferSize[canal]);
    	                bufferSize[canal] = 0;
    	            }
    				try { Thread.sleep(1); } catch (InterruptedException e) {}
    			} else {
    				double[] samples = vsp[canal].remove(0).samples;
	    	        for (int i = 0; i < samples.length; i++) {
	    	        	double sample = samples[i];
	    	            // clip if outside [-1, +1]
	    	            if (Double.isNaN(sample)) throw new IllegalArgumentException("sample is NaN");
	    	            if (sample < -1.0) sample = -1.0;
	    	            if (sample > +1.0) sample = +1.0;
	    	            // convert to bytes
	    	            short s = (short) (MAX_16_BITS * sample);
	    	            buffer[canal][bufferSize[canal]++] = (byte) s;
	    	            buffer[canal][bufferSize[canal]++] = (byte) (s >> 8);   // little Endian
	    	            // mandar a tarjeta cuando se llena el buffer        
	    	            if (bufferSize[canal] >= buffer[canal].length) {
	    	                line[canal].write(buffer[canal], 0, buffer[canal].length);
	    	                bufferSize[canal] = 0;
	    	            }
	    	        }
    			}
    		}
    	}
    }

}
