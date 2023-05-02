package ventanas;

import java.awt.*;
import java.awt.event.*;

public class Sumador extends Frame{
	private TextField tfNumero;
	private TextField tfResultado;
	private Button btnSumar;
	
	public Sumador() {
		this.setTitle("Sumador");
		this.setVisible(true);
		this.setSize(200, 200);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		tfNumero = new TextField("0");
		this.add(tfNumero);
		
		tfResultado = new TextField("0");
		tfResultado.setEditable(false);
		this.add(tfResultado);
		
		btnSumar = new Button("+");
		btnSumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(tfNumero.getText());
				int n2 = Integer.parseInt(tfResultado.getText());
				int resultado = n1+n2;
				tfResultado.setText(resultado+"");
			}
			
		});
		this.add(btnSumar);
	}
	
	public static void main(String[] args) {
		new Sumador();
	}
}
