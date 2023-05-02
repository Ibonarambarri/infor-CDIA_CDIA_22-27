package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class Formulario extends JFrame{
	//Atributos
	ArrayList<Persona> personas;
	
	//Componentes de la ventana
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblSexo;
	private JLabel lblDNI;
	private JTextField tfNombre;
	
	private JTextField tfApellidos;
	private JTextField tfDNI;
	private ButtonGroup bg;
	private JRadioButton rbM;
	private JRadioButton rbH;
	private JRadioButton rbO;
	private JComboBox<String> cb;
	private JPanel pnlButtons;
	private JButton btnGuardar;
	private JButton btnSalvar;
	private JButton btnRecuperar;
	
	public Formulario() {
		personas = new ArrayList<>();		
		
		this.setLayout(new GridLayout(12,1));
		
		
		lblNombre = new JLabel("Nombre:");
		this.add(lblNombre);
		
		
		tfNombre = new JTextField("Amaia");
		this.add(tfNombre);
		
		lblApellidos = new JLabel("Apellidos: ");
		this.add(lblApellidos);
		
		tfApellidos = new JTextField("Pikatza Huerga");
		this.add(tfApellidos);
		
		lblSexo = new JLabel("Sexo: ");
		this.add(lblSexo);
		
		bg = new ButtonGroup();
		pnlButtons = new JPanel();
		
		
		rbH = new JRadioButton("el bueno");
		bg.add(rbH);
		pnlButtons.add(rbH);
		
		rbM = new JRadioButton("Mujer");
		bg.add(rbM);
		pnlButtons.add(rbM);
		
		
		
	
		rbO = new JRadioButton("sin derechos");
		bg.add(rbO);
		pnlButtons.add(rbO);
		
		this.add(pnlButtons);
		
		lblDNI = new JLabel("DNI/PASAPORTE");
		this.add(lblDNI);
		
		cb = new JComboBox<String>();
		cb.addItem("DNI");
		cb.addItem("Pasaporte");
		cb.setSelectedIndex(0);
		this.add(cb);
		
		tfDNI = new JTextField("",20);
		this.add(tfDNI);
	
		
		btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		btnGuardar.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = tfNombre.getText();
				String apellidos = tfApellidos.getText();
				String sexo = "";
				if(rbM.isSelected()) {
					sexo = rbM.getText();
				}else if(rbH.isSelected()) {
					sexo = rbH.getText();
				}else if(rbO.isSelected()){
					sexo = rbO.getText();
				}
				boolean isDni = cb.getSelectedItem().equals("DNI");
				String dni = tfDNI.getText();
				
				Persona p = new Persona(nombre, apellidos, sexo, isDni, dni);
				personas.add(p);
			}
			
		});
		
		btnSalvar = new JButton("Guardar en fichero");
		this.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("personas.txt");
				FileOutputStream fos = null; 
				ObjectOutputStream oos = null; 
				
			
				
				try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);
					
					for(int i = 0; i< personas.size(); i++) {
						if(personas.get(i)!=null) {
							oos.writeObject(personas.get(i));
						}
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
		
		btnRecuperar = new JButton("Recuperar");
		this.add(btnRecuperar);
		
		btnRecuperar.addActionListener(e -> {
			
		});
		btnRecuperar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("personas.txt");
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					
					Object o = ois.readObject();
					while(o != null) {
					 	Persona p = (Persona) o;
						System.out.println(p);
						personas.add(p);
						o = ois.readObject();
					}
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
			}
		});
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Formulario();
	}
	
}
