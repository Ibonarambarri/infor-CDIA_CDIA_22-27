package MisCojones33;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;

public class Decathlon extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Socio> listaSocios = new ArrayList<>();
	
	public void agregarSocio(Socio socio) {
        listaSocios.add(socio);
    }
	
	private ArrayList<Salida> listaSalidas = new ArrayList<>();
	
	public void agregarSalida(Salida salida) {
        listaSalidas.add(salida);
    }
	
	//Atributos Ventana
	private JPanel  panelGrande, panelSocios, panelBotonesSocios;
	private JButton añadirSocio, borrarSocio, modificarSocio;
	private JComboBox<String> socios;
	
	private JPanel panelSalidas; 
	private JPanel panelBotonesSalidas;
	private JButton borrarSalida;
	private JButton añadirSalida;
	private JButton modificarSalida;
	private JComboBox<String> salidas;
	
	private JPanel panelGuardar;
	private JButton guardarDatos;
	private JButton cargarDatos;
	
	public Decathlon() {
		
		//Bases
		super("Club de montaña");
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(2,1));
		Font fuente = new Font("Cambria", Font.BOLD, 15);
		panelGrande = new JPanel(new GridLayout(1,2));
		
		
		//Mitad izquierda de la pantalla, gestion de socios.
		panelSocios = new JPanel(new BorderLayout());
		TitledBorder bordeSocios = BorderFactory.createTitledBorder("Gestión de socios...");
		bordeSocios.setTitleFont(fuente);
		panelSocios.setBorder(bordeSocios);
		
		//SOCIOS
		socios = new JComboBox<String>();
		socios.addItem("<Vacio>");
		panelSocios.add(socios, BorderLayout.NORTH);
		
		//Botones
		panelBotonesSocios = new JPanel();
		
		añadirSocio = new JButton("Añadir socio");
		panelBotonesSocios.add(añadirSocio);
		
		borrarSocio = new JButton("Borrar socio");
		panelBotonesSocios.add(borrarSocio);
		
		modificarSocio = new JButton("Modificar socio");
		panelBotonesSocios.add(modificarSocio);
		
		panelSocios.add(panelBotonesSocios, BorderLayout.SOUTH);
		panelGrande.add(panelSocios);
		
		//Funcionalidades Botones
		
		añadirSocio.addActionListener(e -> {
			this.setVisible(false);
			VentanaSocio v = new VentanaSocio(this);
		});
		
		//Mitad derecha de la pantalla, gestion de salidas.
		panelSalidas = new JPanel(new BorderLayout());
		TitledBorder bordeSalidas = BorderFactory.createTitledBorder("Gestión de salidas...");
		bordeSalidas.setTitleFont(fuente);
		panelSalidas.setBorder(bordeSalidas);
		
		//SALIDAS
		salidas = new JComboBox<String>();
		salidas.addItem("<Vacio>");
		
		panelSalidas.add(salidas, BorderLayout.NORTH);
		
		//Botones 
		panelBotonesSalidas = new JPanel();
		
		añadirSalida = new JButton("Añadir salida");
		panelBotonesSalidas.add(añadirSalida);
		
		borrarSalida = new JButton("Borrar salida");
		panelBotonesSalidas.add(borrarSalida);
		
		modificarSalida = new JButton("Modificar salida");
		panelBotonesSalidas.add(modificarSalida);
		
		panelSalidas.add(panelBotonesSalidas, BorderLayout.SOUTH);
		panelGrande.add(panelSalidas);
		
		///Funcionalidades Botones
		
		añadirSalida.addActionListener(e -> {
			this.setVisible(false);
			VentanaSalida v = new VentanaSalida(this);
		});
		
		//Parte sur de la ventana
		panelGuardar = new JPanel();
		panelGuardar.setPreferredSize(new Dimension(1000, 50));
			
		cargarDatos = new JButton("Cargar datos");
		guardarDatos = new JButton("Guardar datos");
						
		panelGuardar.add(cargarDatos);
		panelGuardar.add(guardarDatos);
				
		this.add(panelGrande);			
		this.add(panelGuardar);
				
		//Fin de la ejecucion de codigo al cerrar ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
