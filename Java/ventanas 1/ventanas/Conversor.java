package ventanas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Conversor extends JFrame{
	private JPanel pnlEntrada;
	private JPanel pnlBoton;
	private JPanel pnlSalida;
	private JLabel lblEuros;
	private JLabel lblDolar;
	private JLabel lblResult;
	private JTextField tfEuros;
	private JTextField tfDolares;
	private JTextField tfResult;
	private JButton btnConvertir;
	
	public Conversor() {
		this.setTitle("Conversor");
		this.setSize(300, 170);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		pnlEntrada = new JPanel();
		pnlEntrada.setLayout(new GridLayout(2,2));
		
		lblEuros = new JLabel("Euros:");
		pnlEntrada.add(lblEuros);
		
		lblDolar = new JLabel("Dolar:");
		pnlEntrada.add(lblDolar);
		
		tfEuros = new JTextField("0");
		pnlEntrada.add(tfEuros);
		
		tfDolares = new JTextField("0");
		pnlEntrada.add(tfDolares);
		
		this.add(pnlEntrada, BorderLayout.NORTH);
		
		pnlBoton = new JPanel();
		pnlBoton.setLayout(new FlowLayout());
		
		btnConvertir = new JButton("Convertir");
		pnlBoton.add(btnConvertir);
		btnConvertir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double euros = Double.parseDouble(tfEuros.getText());
				double dolares = Double.parseDouble(tfDolares.getText());
				double resultado = euros*dolares;
				tfResult.setText(resultado+"");
			}
			
		});
		
		this.add(pnlBoton, BorderLayout.CENTER);
		
		pnlSalida = new JPanel();
		pnlSalida.setLayout(new GridLayout(2,1));
		
		lblResult = new JLabel("Resultado:");
		pnlSalida.add(lblResult);
		
		tfResult = new JTextField("0");
		pnlSalida.add(tfResult);
		
		this.add(pnlSalida, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Conversor();
	}
}
