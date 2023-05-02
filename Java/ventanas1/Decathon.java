package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Decathon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel principal;
	private JPanel secundario;
	private JLabel socios;
	private JLabel salidas;
	private JComboBox<String> OPSocios;
	private JComboBox<String> OPSalidas;
	private JPanel bgroup1;
	private JPanel bgroup2;
	private JButton añadir1;
	private JButton añadir2;
	private JButton borra1;
	private JButton borrar2;
	private JButton modificar1;
	private JButton modificar2;
	private JButton cargar;
	private JButton guardar;
	private JPanel ultimos;
	private JPanel adic;
	private JPanel nuevo;
	

	public Decathon() {
		adic=new JPanel();
		principal = new JPanel();
		secundario = new JPanel();
		ultimos=new JPanel();
		adic.setLayout(new GridLayout(1, 3));
		adic.add(principal);
		nuevo=new JPanel();
		adic.add( nuevo);
		adic.add(secundario);
		this.add(adic);
		this.add(ultimos);
		nuevo=new JPanel();
		
		this.setLayout(new GridLayout(3,1));;
		
		principal.setLayout(new GridLayout(3,1));
		secundario.setLayout(new GridLayout(3,1));

		socios = new JLabel("Gestion de Socios...");
		principal.add(socios);

		salidas = new JLabel("Gestion de Salidas...");
		secundario.add(salidas);

		OPSocios = new JComboBox<String>();
		OPSocios.addItem("bujarra");
		principal.add(OPSocios);
		OPSocios.setSize(50,50);

		OPSalidas = new JComboBox<String>();
		secundario.add(OPSalidas);

		añadir1 = new JButton("Añadir");
		bgroup1 = new JPanel();
		bgroup1.add(añadir1);
		borra1 = new JButton("Borrar");
		bgroup1.add(borra1);
		modificar1 = new JButton("Modificar");
		bgroup1.add(modificar1);
		principal.add(bgroup1,BorderLayout.SOUTH);
		

		añadir2 = new JButton("Añadir");
		bgroup2 = new JPanel();
		bgroup2.add(añadir2);
		borrar2 = new JButton("Borrar");
		bgroup2.add(borrar2);
		modificar2 = new JButton("Modificar");
		bgroup2.add(modificar2);
		secundario.add(bgroup2,BorderLayout.SOUTH);
		guardar=new JButton("guardar");
		ultimos.add(guardar);
		cargar=new JButton("cargar");
		ultimos.add(cargar);
		this.add(ultimos,BorderLayout.SOUTH);
		cargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		this.setVisible(true);
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Decathon();
	}
}
