package clubMontana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;

import ventanas.Persona;

public class VentanaPrincipal extends JFrame{	
	private JPanel gestionSocios;
	private JComboBox<Socio> cbSocios;
	private JPanel pnlBotSo;
	private JButton btnAnadirSo;
	private JButton btnBorrarSo;
	private JButton btnModSo;
	private JPanel gestionSalidas;
	private JComboBox<Salida> cbSalidas;
	private JPanel pnlBotSa;
	private JButton btnAnadirSa;
	private JButton btnBorrarSa;
	private JButton btnModSa;
	private JPanel datos;
	private JButton btnCargar;
	private JButton btnGuardar;

	public VentanaPrincipal() {		
		this.setTitle("Club de montaña");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,300);
		
		//Panel socios
		gestionSocios = new JPanel();
		gestionSocios.setLayout(new BorderLayout());
		Border bordeSocios = BorderFactory.createTitledBorder("Gestión de socios...");
		gestionSocios.setBorder(bordeSocios);
		
		cbSocios = new JComboBox<>();
		gestionSocios.add(cbSocios, BorderLayout.NORTH);
		
		pnlBotSo = new JPanel();
		
		btnAnadirSo = new JButton("Añadir");
		pnlBotSo.add(btnAnadirSo);
		btnAnadirSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Socio s = new Socio();
				cbSocios.addItem(s);
				VentanaSocio vs = new VentanaSocio(s);
			}
		});
		
		btnBorrarSo = new JButton("Borrar");
		pnlBotSo.add(btnBorrarSo);
		btnBorrarSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cbSocios.removeItem(cbSocios.getSelectedItem());
			}
		});
		
		btnModSo = new JButton("Modificar");
		pnlBotSo.add(btnModSo);
		btnModSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Socio s = (Socio) cbSocios.getSelectedItem();
				if(s != null) {
					VentanaSocio vs = new VentanaSocio(s);
				}
			}
		});
		
		gestionSocios.add(pnlBotSo, BorderLayout.SOUTH);
		this.add(gestionSocios, BorderLayout.WEST);
		
		//Panel salidas
		gestionSalidas = new JPanel();
		gestionSalidas.setLayout(new BorderLayout());
		Border bordeSalidas = BorderFactory.createTitledBorder("Gestión de salidas...");
		gestionSalidas.setBorder(bordeSalidas);
		
		cbSalidas = new JComboBox<>();
		gestionSalidas.add(cbSalidas, BorderLayout.NORTH);
		
		pnlBotSa = new JPanel();
		
		btnAnadirSa = new JButton("Añadir");
		pnlBotSa.add(btnAnadirSa);
		btnAnadirSa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Salida s = new Salida();
				cbSalidas.addItem(s);
				VentanaSalida vs = new VentanaSalida(s);
			}
		});
		
		btnBorrarSa = new JButton("Borrar");
		pnlBotSa.add(btnBorrarSa);
		btnBorrarSa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cbSalidas.removeItem(cbSalidas.getSelectedItem());
			}
		});
		
		btnModSa = new JButton("Modificar");
		pnlBotSa.add(btnModSa);
		btnModSa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Salida s = (Salida) cbSalidas.getSelectedItem();
				VentanaSalida vs = new VentanaSalida(s);
			}
		});
		
		gestionSalidas.add(pnlBotSa, BorderLayout.SOUTH);
		this.add(gestionSalidas, BorderLayout.EAST);
		
		//Zona sur
		datos = new JPanel();
		
		btnCargar = new JButton("Cargar datos");
		datos.add(btnCargar);
		btnCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("socios.dat");
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					
					Object o = ois.readObject();
					while(o != null) {
						Socio s = (Socio) o;
						cbSocios.addItem(s);
						o = ois.readObject();
					}
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
				f = new File("salidas.dat");
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					
					Object o = ois.readObject();
					while(o != null) {
						Salida s = (Salida) o;
						cbSalidas.addItem(s);
						o = ois.readObject();
					}
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
			}
		});
		
		btnGuardar = new JButton("Guardar datos");
		datos.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("socios.dat");
				FileOutputStream fos = null; 
				ObjectOutputStream oos = null; 
				
				try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);
					
					for (int i = 0; i<cbSocios.getItemCount(); i++) {
						oos.writeObject(cbSocios.getItemAt(i));
					}
					
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
				try {
					oos.close();
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
				f = new File("salidas.dat");
				try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);
					
					for (int i = 0; i<cbSalidas.getItemCount(); i++) {
						oos.writeObject(cbSalidas.getItemAt(i));
					}
					
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
				try {
					oos.close();
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
			}
		});
		
		this.add(datos, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaPrincipal();
	}

}
