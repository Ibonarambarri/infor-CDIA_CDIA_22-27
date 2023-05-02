package ventanas;

import java.awt.*;
import java.awt.event.*;

public class Contador extends Frame{
	private TextField tfNumero;
	private Button btnMas;
	
	public Contador() {
		this.setTitle("Contador");
		this.setVisible(true);
		this.setSize(300, 100);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}

		});
		
		tfNumero = new TextField("0");
		this.add(tfNumero);
		
		btnMas = new Button("+");
		btnMas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(tfNumero.getText());
				n++;
				tfNumero.setText(n+"");
			}	
			
		});
		this.add(btnMas);
	}
	
	public static void main(String[] args) {
		new Contador();
	}
}
