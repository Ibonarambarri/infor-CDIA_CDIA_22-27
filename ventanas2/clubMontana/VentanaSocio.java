package clubMontana;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaSocio extends JFrame{
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JLabel lblDNI;
	private JTextField tfDNI;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblTlfn;
	private JTextField tfTlfn;
	private JButton btnGuardar;
	
	public VentanaSocio(Socio s) {
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("Socio");
		
		lblNombre = new JLabel("Nombre:");
		this.add(lblNombre);
		
		tfNombre = new JTextField(s.getNombre(), 20);
		this.add(tfNombre);
		
		lblDNI = new JLabel("DNI:");
		this.add(lblDNI);
		
		tfDNI = new JTextField(s.getDNI(), 20);
		this.add(tfDNI);
		
		lblEmail = new JLabel("Email: ");
		this.add(lblEmail);
		
		tfEmail = new JTextField(s.getEmail(), 20);
		this.add(tfEmail);
		
		lblTlfn = new JLabel("Teléfono: ");
		this.add(lblTlfn);
		
		tfTlfn = new JTextField(s.getTlfn(), 20);
		this.add(tfTlfn);
		
		btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s.setNombre(tfNombre.getText());
				s.setDNI(tfDNI.getText());
				s.setEmail(tfEmail.getText());
				s.setTlfn(tfTlfn.getText());
			}
		});
		
		this.setVisible(true);
	}
}
