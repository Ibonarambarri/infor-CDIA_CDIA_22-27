package MisCojones33;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.HashMap;

public class Decathlon extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Socio> listaSocios = new ArrayList<>();
	
	public void agregarSocio(Socio socio) {
        listaSocios.add(socio);
    }
	
	public void borrarSocio(Socio socio) {
		listaSocios.remove(socio);
	}
	
	private ArrayList<Salida> listaSalidas = new ArrayList<>();
	
	public void agregarSalida(Salida salida) {
        listaSalidas.add(salida);
    }
	
	public void borrarSalida(Salida salida) {
		listaSalidas.remove(salida);
	}
	
	
	//Atributos Ventana
	private JPanel  panelGrande, panelSocios, panelBotonesSocios;
	private JButton añadirSocio, borrarSocio, modificarSocio;
	private JComboBox<String> socios;
	
	private JPanel panelSalidas, panelBotonesSalidas; 
	private JButton borrarSalida, añadirSalida, modificarSalida;
	private JComboBox<String> salidas;
	
	private JPanel panelGuardar;
	private JButton guardarDatos, cargarDatos, actualizar;
	
	public Decathlon() {
		
		//Bases
		super("Club de montaña");
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		Font fuente = new Font("Cambria", Font.BOLD, 15);
		panelGrande = new JPanel(new GridLayout(1,2));
		
		
		//Mitad izquierda de la pantalla, gestion de socios.
		panelSocios = new JPanel(new BorderLayout());
		TitledBorder bordeSocios = BorderFactory.createTitledBorder("Gestión de socios...");
		bordeSocios.setTitleFont(fuente);
		panelSocios.setBorder(bordeSocios);
		
		//SOCIOS
		socios = new JComboBox<String>();
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
		
		borrarSocio.addActionListener(e -> {
			int index = socios.getSelectedIndex();
			if (index >= 0) {
		        listaSocios.remove(index);
		        socios.removeItemAt(index);
		    }
		});
		
		
		modificarSocio.addActionListener(e -> {
		    Socio socioSeleccionado = listaSocios.get(socios.getSelectedIndex());
		    VentanaSocio v = new VentanaSocio(this, socioSeleccionado);
		});
		
		//Mitad derecha de la pantalla, gestion de salidas.
		panelSalidas = new JPanel(new BorderLayout());
		TitledBorder bordeSalidas = BorderFactory.createTitledBorder("Gestión de salidas...");
		bordeSalidas.setTitleFont(fuente);
		panelSalidas.setBorder(bordeSalidas);
		
		//SALIDAS
		salidas = new JComboBox<String>();
		
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
		borrarSalida.addActionListener(e ->{
			int index = salidas.getSelectedIndex();
			if (index >= 0) {
		        listaSalidas.remove(index);
		        salidas.removeItemAt(index);
		    }
		});
		
		modificarSalida.addActionListener(e -> {
			this.setVisible(false);
			VentanaSalida v = new VentanaSalida(this);
		});
		
		//Parte sur de la ventana
		panelGuardar = new JPanel();
		panelGuardar.setPreferredSize(new Dimension(1000, 50));
			
		cargarDatos = new JButton("Cargar datos");
		guardarDatos = new JButton("Guardar datos");
		actualizar = new JButton("Actualizar datos");
		
		actualizar.addActionListener(e ->{
			for (Socio socio: listaSocios) {
				socios.addItem(socio.getNombre());
			}
			for (Salida salida: listaSalidas) {
				salidas.addItem(salida.getLugar());
			}
		});
						
		panelGuardar.add(cargarDatos);
		panelGuardar.add(guardarDatos);
		panelGuardar.add(actualizar);
		
		guardarDatos.addActionListener(e -> {
		    try {
		        File archivo = new File("/Users/erikeguskiza/Desktop", "datos.txt");
		        FileWriter writer = new FileWriter(archivo);

		        // guardar los datos de los socios
		        for (Socio socio : listaSocios) {
		            writer.write(socio.toString() + "\n");
		        }

		        // guardar los datos de las salidas
		        for (Salida salida : listaSalidas) {
		            writer.write(salida.toString() + "\n");
		        }

		        writer.close();
		        System.out.println("Datos guardados en el archivo " + archivo.getAbsolutePath());
		    } catch (IOException ex) {
		        System.out.println("Error al guardar los datos en el archivo");
		        ex.printStackTrace();
		    }
		});

		
		cargarDatos.addActionListener(e -> {
			try {
				File archivo = new File("/Users/erikeguskiza/Desktop", "datos.txt");
				FileReader reader = new FileReader(archivo);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String linea;
				while ((linea = bufferedReader.readLine()) != null) {
					String[] datos = linea.split(",");
					String nombre = datos[0];
					String dni = datos[1];
					String email = datos[2];
					String telefono = datos[3];
					Socio socio = new Socio(nombre, dni, email, telefono);
					listaSocios.add(socio);
					}
			reader.close();
			System.out.println("Datos cargados desde el archivo " + archivo.getAbsolutePath());
			} catch (IOException ex) {
			System.out.println("Error al cargar los datos desde el archivo");
			ex.printStackTrace();
			}
			});

		

		
				
		this.add(panelGrande);			
		this.add(panelGuardar, BorderLayout.SOUTH);
				
		//Fin de la ejecucion de codigo al cerrar ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
