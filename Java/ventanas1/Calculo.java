package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField p;
	private JPanel Frame;
	private JPanel J;
	private JButton cero;
	private JButton uno;
	private JButton dos;
	private JButton tres;
	private JButton cuatro;
	private JButton cinco;
	private JButton seis;
	private JButton siete;
	private JButton ocho;
	private JButton nueve;
	private JButton suma;
	private JButton resta;
	private JButton division;
	private JButton multi;
	private JButton quitar;
	private JButton resultado;
	
	
	String primero="";
	String operacion="";
	public Calculo() {
		
		
		this.setSize(400,400);
		J=new JPanel();
		
		J.setLayout(new GridLayout(4,4));
		p= new JTextField(" ");
		p.setHorizontalAlignment(JTextField.RIGHT);
		Frame = new JPanel();
		this.add(Frame);
		Frame.setLayout( new BorderLayout(4 ,4));
		Frame.add(p,BorderLayout.NORTH);
		Frame.add(J, BorderLayout.CENTER);
		
		siete = new JButton("7");
		J.add(siete);
		ocho = new JButton("8");
		J.add(ocho);
		nueve = new JButton("9");
		J.add(nueve);
		multi = new JButton("x");
		J.add(multi);
		cuatro = new JButton("4");
		J.add(cuatro);
		cinco = new JButton("5");
		J.add(cinco);
		seis = new JButton("6");
		J.add(seis);
		resta = new JButton("-");
		J.add(resta);
		uno = new JButton("1");
		J.add(uno);
		dos = new JButton("2");
		J.add(dos);
		tres = new JButton("3");
		J.add(tres);
		
		suma = new JButton("+");
		J.add(suma);
		quitar = new JButton("CE");
		J.add(quitar);
		cero = new JButton("0");
		J.add(cero);
		division = new JButton("/");
		J.add(division);
		resultado = new JButton("=");
		J.add(resultado);
		
		cero.addActionListener((ActionListener)new ActionListener() {
		
				

			
			public void actionPerformed(ActionEvent e) {
				String numero = p.getText();
				numero=numero+0;
				p.setText(numero+"");
			
				
			}
			
		});
		uno.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+1;
				p.setText(numero+"");
			}
			
		});
		dos.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+2;
				p.setText(numero+"");
			}
			
		});
		tres.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+3;
				p.setText(numero+"");
			}
			
		});
		cuatro.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+4;
				p.setText(numero+"");
			}
			
		});
		cinco.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+5;
				p.setText(numero+"");
			}
		});
		seis.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+6;
				p.setText(numero+"");
			}
			
		});
		siete.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+7;
				p.setText(numero+"");
			}
			
		});
		ocho.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+8;
				p.setText(numero+"");
			}
			
		});
		nueve.addActionListener((ActionListener)new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero =p.getText();
				numero=numero+9;
				p.setText(numero+"");
			}
			
		});
		
		
		multi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operacion = "x";
		        primero = p.getText();
		        p.setText("");
		    }
		});

		resta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operacion = "-";
		        primero = p.getText();
		        p.setText("");
		    }
		});

		suma.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operacion = "+";
		        primero = p.getText();
		        p.setText("");
		    }
		});

		division.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operacion = "/";
		        primero = p.getText();
		        p.setText("");
		    }
		});
		quitar.addActionListener((ActionListener)new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operacion="CE";
				p.setText("");
			}
				
				
			
			
		});

		resultado.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String label2 = p.getText();
		        int num1 = Integer.parseInt(primero);
		        int num2 = Integer.parseInt(label2);
		        double resultado = 0;

		        if (operacion.equals("x")) {
		            resultado = num1 * num2;
		        } else if (operacion.equals("-")) {
		            resultado = num1 - num2;
		        } else if (operacion.equals("+")) {
		            resultado = num1 + num2;
		        } else if (operacion.equals("/")) {
		            resultado = num1 / num2;
		        }else if(operacion.equals("CE")) {
		        	resultado=0;
		        }

		        p.setText(resultado + "");
		    }
		});
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Calculo();
	}
}

