package ventanas;


import java.awt.*;
import javax.swing.*;


public class examen extends JFrame {
	private JPanel principal;
	private JPanel secundario;
	private JLabel socios;
	private JLabel salidas;
	private JComboBox<String>OPSocios;
	private JComboBox<String>OPSalidas;
	private JPanel bgroup1;
	private JPanel bgroup2;
	private Button añadir1;
	private Button añadir2;
	private Button borra1;
	private Button borrar2;
	private Button modificar1;
	private Button modificar2;
	

	
	this.setLayout(new GridLayout(1,2));
	this.add(principal);
	this.add(secundario);
	this.setvisible(true);
	this.setsize(400,300);
	
	public static void main(String[] args) {
		new examen();
	}
}
