package utils.ventanas.ventanaConsola;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/** Clase de utilidad para poder realizar entrada de texto de teclado
 * y salida de texto a pantalla, utilizando una ventana en lugar de
 * hacerlo sobre consola.
 * Permite utilizar texto coloreado en la consola con los métodos 
 * específicos de color
 * Haciendo Ctrl+F se busca el texto que esté en la línea de entrada
 * Permite además configurar botones de entrada específicos en lugar de entrada por teclado
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class VentanaConsolaConBotones {
	
	/** Método de prueba de la clase.
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		VentanaConsolaConBotones v = new VentanaConsolaConBotones( "Prueba de ventana de consola" );
		v.init();
		v.println( "Hola. Dame un número entero:" );  // Sin color (negro)
		int dato = v.leeInt();
		if (dato == Integer.MAX_VALUE)
			v.println( "Tu número introducido es INCORRECTO.", Color.red );
		else 
			v.println( "Tu número introducido es " + dato, Color.green );
		v.println( "Dame un número real:", Color.blue );
		double datoDouble = v.leeDouble();
		if (datoDouble == Double.MAX_VALUE)
			v.println( "Tu número introducido es INCORRECTO.", Color.red );
		else 
			v.println( "Tu número introducido es " + datoDouble, Color.green );
		v.println( "Dame un string:", Color.blue );
		String linea = v.leeString();
		v.clear();  // Borra la pantalla
		v.println( "Tu string introducido es \"" + linea + "\"", Color.blue );
		v.println( "Saco otra ventana" );
		VentanaConsolaConBotones v2 = new VentanaConsolaConBotones( "Otra" );
		v2.getJFrame().setLocation( 0, 0 );
		v2.println( "Soy otra ventana" );
		v.println( "Estoy ejecutándome 5 segundos más... y me paro", Color.blue );
		v.espera( 5000 );
		v.cerrar();
		v2.println( "Yo sigo aquí. Tendrás que cerrarme a mano" );
		v2.println( "¿Qué te parece si ahora me contestas con el botón?" );
		String resp = v2.sacaBotonesYEsperaRespuesta( "Opción 1", "Opción 2", "No hay opción", "Opta tú" );
		v2.println( "Botón pulsado: " + resp );
	}

	
	// Atributos internos de cada ventana
	
	private JFrame miVentana = null;
	private JTextField tfLineaEntrada = new JTextField();
	private JTextPane tpSalida = new JTextPane();
	private JScrollPane spSalida = null;
	private StyledDocument doc = tpSalida.getStyledDocument();
	private JPanel pSuperior = null;
	private boolean lineaLeida = false;
	
	/** Construye una nueva ventana de consola
	 * @param titulo	Título de la ventana (si es null figurará "Ventana de consola")
	 */
	public VentanaConsolaConBotones(String titulo) {
		miVentana = new JFrame();
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		miVentana.setSize( 800, 600 );
		miVentana.setLocationRelativeTo( null );
		miVentana.setTitle( titulo==null ? "Ventana de consola" : titulo );
		tpSalida.setEditable( true );
			JPanel noWrapPanel = new JPanel( new BorderLayout() ); // Truco para hacer el textpane sin wrap de línea
			noWrapPanel.add( tpSalida );
		spSalida = new JScrollPane( noWrapPanel );
		miVentana.getContentPane().add( spSalida, BorderLayout.CENTER );
		miVentana.getContentPane().add( tfLineaEntrada, BorderLayout.SOUTH );
		pSuperior = new JPanel();
		miVentana.getContentPane().add( pSuperior, BorderLayout.NORTH );
		// Formato
		tpSalida.setFont( new Font( "Arial", Font.PLAIN, 16 ));
		tfLineaEntrada.setFont( new Font( "Arial", Font.PLAIN, 16 ));
		tfLineaEntrada.setEnabled( false );
		// Política de visualización de caret -cursor en textpane-
		DefaultCaret caret = (DefaultCaret) tpSalida.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);       
		// Escuchadores
		tfLineaEntrada.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lineaLeida = true;
			}
		});
		tfLineaEntrada.addKeyListener( new KeyAdapter() {
			boolean ctrlPulsado = false;
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_CONTROL) ctrlPulsado = false;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_CONTROL) ctrlPulsado = true;
				else if (e.getKeyCode()==KeyEvent.VK_F && ctrlPulsado) {  // Ctrl+F
					buscarString( tfLineaEntrada.getText() );
					tpSalida.requestFocus();
				}
			}
		});
		tpSalida.addKeyListener( new KeyListener() {
			boolean ctrlPulsado = false;
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_CONTROL) ctrlPulsado = false;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_CONTROL) ctrlPulsado = true;
				else if (e.getKeyCode()==KeyEvent.VK_F && ctrlPulsado) {  // Ctrl+F
					buscarString( tfLineaEntrada.getText() );
				}
			}
		});
		miVentana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				miVentana = null;
				estilosUsados.clear();
			}
		});
	}

	/** Saca una botonera en la parte superior de la ventana
	 * @param botones	Textos de los botones que quieren sacarse
	 * @return	Texto del botón pulsado, null si se sale de la ventana sin pulsar o si no hay botones
	 */
	public String sacaBotonesYEsperaRespuesta( ArrayList<String> botones ) {
		return sacaBotonesYEsperaRespuesta( botones.toArray( new String[botones.size()] ) );
	}
	
		private String resp = null;
	/** Saca una botonera en la parte superior de la ventana
	 * @param botones	Textos de los botones que quieren sacarse
	 * @return	Texto del botón pulsado, null si se sale de la ventana sin pulsar o si no hay botones
	 */
	public String sacaBotonesYEsperaRespuesta( String... botones ) {
		resp = null;
		if (botones.length == 0) return null;
		for (String boton : botones) {
			JButton b = new JButton( boton );
			pSuperior.add( b );
			b.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resp = boton;
				}
			});
		}
		miVentana.getContentPane().revalidate();
		while (resp==null && miVentana!=null) {
			espera(20);
		}
		pSuperior.removeAll();
		miVentana.getContentPane().revalidate();
		return resp;
	}
	
	/** Devuelve el objeto JFrame que implementa la ventana
	 * @return	JFrame correspondiente a esta ventana
	 */
	public JFrame getJFrame() {
		return miVentana;
	}
	
	/** Busca un string en el área de texto. Si lo encuentra, lo selecciona
	 * @param aBuscar	String a buscar
	 */
	public void buscarString( String aBuscar ) {
		if (aBuscar==null || aBuscar.isEmpty() || miVentana==null) return;
		if (tpSalida.getSelectionEnd() >= doc.getLength()) {
			tpSalida.setSelectionStart(0);
			tpSalida.setSelectionEnd(0);
		}
		int posActual = tpSalida.getSelectionEnd();
		int busqueda = tpSalida.getText().indexOf( aBuscar, posActual );
		if (busqueda>=0) {
			// Diferente para TextArea - más complicado con JTextPane
			Element el = doc.getDefaultRootElement();
			buscarStringRec( aBuscar, el );
		}
	}
		private boolean buscarStringRec( String aBuscar, Element el ) {
			if (el instanceof AbstractDocument.LeafElement) {  // Nodo final de texto
				try {
					String text = el.getDocument().getText( el.getStartOffset(), el.getEndOffset()-el.getStartOffset() );
					int busqueda = text.indexOf( aBuscar );
					if (busqueda>=0) {
						tpSalida.setSelectionStart( el.getStartOffset()+busqueda );
						tpSalida.setSelectionEnd( el.getStartOffset()+busqueda + aBuscar.length() );
						return true;
					}
				} catch (BadLocationException e) {}
				return false;
			} else {
				// System.out.println( "#" + el + " - " + el.getClass().getName() );
				for (int i=0; i<el.getElementCount(); i++) {
					if (el.getElement(i).getStartOffset() > tpSalida.getSelectionEnd()) {
						boolean esta = buscarStringRec( aBuscar, el.getElement(i) );
						if (esta) return true;
					}
				}
				return false;
			}
		}

	/** Hace visible la ventana de consola y pone el foco de teclado en la línea de entrada
	 */
	public void init() {
		if (!miVentana.isVisible()) miVentana.setVisible( true );
		tfLineaEntrada.requestFocus();
	}
	
	/** Cierra la ventana de consola. Llamar siempre a este método al final. 
	 * Ocurre también si el usuario cierra interactivamente la ventana. 
	 * ATENCION: Si no se llama a este método Java sigue activo aunque el main que lo ejecuta se acabe
	 * (Si sabes de hilos... este hilo cierra la ventana para que Swing pueda acabar)
	 */
	public void cerrar() {
		if (miVentana!=null) miVentana.dispose();
		miVentana = null;
		estilosUsados.clear();
	}
	
	/** Informa si la ventana se ha cerrado
	 * @return	true si ya se ha cerrado, false en caso contrario
	 */
	public boolean estaCerrada() {
		return (miVentana==null);
	}
	
	/** Lee una línea desde la línea de entrada de la ventana
	 * @return	Línea leída como un string
	 */
	public String leeString() {
		init();
		tfLineaEntrada.setEnabled( true );
		tfLineaEntrada.requestFocus();
		while (!lineaLeida) {
			// Espera hasta que se lea algo
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
		lineaLeida = false;
		String ret  = tfLineaEntrada.getText();
		tfLineaEntrada.setText( "" );
		tfLineaEntrada.setEnabled( false );
		return ret;
	}
	
	/** Lee una línea desde la línea de entrada de la ventana y la interpreta como un entero
	 * @return	entero leído. Si es erróneo devuelve Integer.MAX_VALUE
	 */
	public int leeInt() {
		init();
		tfLineaEntrada.setEnabled( true );
		tfLineaEntrada.requestFocus();
		while (!lineaLeida) {
			// Espera hasta que se lea algo
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
		lineaLeida = false;
		String ret  = tfLineaEntrada.getText();
		tfLineaEntrada.setText( "" );
		tfLineaEntrada.setEnabled( false );
		try {
			int i = Integer.parseInt( ret );
			return i;
		} catch (NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}
	
	/** Lee una línea desde la línea de entrada de la ventana y la interpreta como un double
	 * @return	double leído. Si es erróneo devuelve Double.MAX_VALUE
	 */
	public double leeDouble() {
		init();
		tfLineaEntrada.setEnabled( true );
		tfLineaEntrada.requestFocus();
		while (!lineaLeida) {
			// Espera hasta que se lea algo
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
		lineaLeida = false;
		String ret  = tfLineaEntrada.getText();
		tfLineaEntrada.setText( "" );
		tfLineaEntrada.setEnabled( false );
		try {
			double d = Double.parseDouble( ret );
			return d;
		} catch (NumberFormatException e) {
			return Double.MAX_VALUE;
		}
	}
	
	/** Borra todo el texto de la ventana
	 */
	public void clear() {
		init();
		tpSalida.setText( "" );
	}
	
	/** Escribe en la ventana una línea
	 * @param s	String a visualizar en la ventana
	 */
	public void println( String s ) {
		print( s + "\n" );
	}
	
	/** Escribe en la ventana una línea con color
	 * @param s	String a visualizar en la ventana
	 * @param color	Color con el que visualizarlo
	 */
	public void println( String s, Color color ) {
		print( s + "\n", color );
	}
	
	/** Escribe en la ventana un string (no salta línea)
	 * @param s	String a visualizar en la ventana
	 */
	public void print( String s ) {
		init();
        try { doc.insertString( doc.getLength(), s, null ); }
        catch (BadLocationException e) {}
	}
	
		// Mapa interno de estilos de color, para reutilizarlos según se crean
		private static volatile HashMap<Integer,Style> estilosUsados = new HashMap<>();
	/** Escribe en la ventana un string (no salta línea) con color
	 * @param s	String a visualizar en la ventana
	 * @param color	Color con el que visualizarlo
	 */
	public void print( String s, Color color ) {
		init();
		Style style = estilosUsados.get( color.getRGB() );
		if (style==null) {
	        style = tpSalida.addStyle( ""+color.getRGB(), null );
	        StyleConstants.setForeground( style, color );
	        estilosUsados.put( color.getRGB(), style );
		}
        try { doc.insertString( doc.getLength(), s, style ); }
        catch (BadLocationException e) {}
	}

	/** Espera sin hacer nada durante el tiempo indicado en milisegundos
	 * @param msg	Tiempo a esperar
	 */
	public void espera( int msg ) {
		try {
			Thread.sleep( msg );
		} catch (InterruptedException e) {
		}
	}
	
}
