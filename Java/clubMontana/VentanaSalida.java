package clubMontana;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaSalida extends JFrame{
	private JLabel lblDia;
	private JTextField tfDia;
	private JLabel lblMes;
	private JTextField tfMes;
	private JLabel lblHora;
	private JTextField tfHora;
	private JLabel lblLugar;
	private JTextField tfLugar;
	private JButton btnGuardar;
	
	public VentanaSalida(Salida s) {
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("Salida");
		
		lblDia = new JLabel("Día:");
		this.add(lblDia);
		
		tfDia = new JTextField(s.getDia()+"", 20);
		this.add(tfDia);
		
		lblMes = new JLabel("Mes:");
		this.add(lblMes);
		
		tfMes = new JTextField(s.getMes()+"", 20);
		this.add(tfMes);
		
		lblHora = new JLabel("Hora:");
		this.add(lblHora);
		
		tfHora = new JTextField(s.getHora()+"", 20);
		this.add(tfHora);
		
		lblLugar = new JLabel("Lugar:");
		this.add(lblLugar);
		
		tfLugar = new JTextField(s.getLugar(), 20);
		this.add(tfLugar);
		
		btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s.setDia(Integer.parseInt(tfDia.getText()));
				s.setMes(Integer.parseInt(tfMes.getText()));
				s.setHora(Integer.parseInt(tfHora.getText()));
				s.setLugar(tfLugar.getText());
			}
		});
		
		this.setVisible(true);
		
	}
}
