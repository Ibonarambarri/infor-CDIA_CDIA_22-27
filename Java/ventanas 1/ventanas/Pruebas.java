package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class Pruebas extends JFrame  {
	ArrayList<Personas> personas;
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton b1; 
	private JButton b2;
	private JButton b3;
	
	
	
	
	
	public Pruebas() {
		personas = new ArrayList<>(); 
		panel1=new JPanel();
		this.add(panel1);
		panel2=new JPanel();
		this.add(panel2);
		b3=new JButton("calculadora");
		panel2.add(b3);
		this.setLayout(new GridLayout(1,2));
		tf1=new JTextField("nombre");
		panel1.add(tf1);
		tf2=new JTextField("apellido");
		panel1.add(tf2);
		tf3=new JTextField("edad");
		panel1.add(tf3);
		panel1.setLayout(new GridLayout(3,1));
		b1=new JButton("guardar en fichero");
		panel2.add(b1);
		b2=new JButton("devolver");
		panel2.add(b2);
		panel2.setLayout(new GridLayout(3,1));
		
		
		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        File f = new File("texto.txt");
		        FileOutputStream fos = null;
		        ObjectOutputStream oos = null;
		        String nombre=tf1.getText();
		    	String apellido=tf2.getText();
		    	String edad=tf3.getText();
		    	
		    	
		    	Personas p= new Personas(nombre,apellido,edad);
		    	personas.add(p);
		        try {
		            fos = new FileOutputStream(f);
		            oos = new ObjectOutputStream(fos);

		            for(int i = 0; i< personas.size(); i++) {
						if(personas.get(i)!=null) {
							oos.writeObject(personas.get(i));
							System.out.println(personas.get(i));
						}
					}

		        } catch (Exception exc) {
		            exc.printStackTrace();
		        } finally {
		            try {
		                if (oos != null) {
		                    oos.close();
		                }
		                if (fos != null) {
		                    fos.close();
		                }
		            } catch (IOException exc) {
		                exc.printStackTrace();
		            }
		        }
		    }
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new	Calculo();
				Calculo calculo = new Calculo();
				calculo.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		
		b2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	
		    	
				File f = new File("texto.txt");
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					
					Object o = ois.readObject();
					while(o != null) {
					 	Personas j = (Personas) o;
						System.out.println(j);
						
						
					}
				}catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
				
			}
		});
	
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
	}
	

	public static void main(String[] args) { 
		new Pruebas();
	}

}








































































































