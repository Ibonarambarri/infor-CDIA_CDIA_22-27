package ventanas;

import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame{
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setVisible(true);
		f.setSize(300,200);
		f.setLayout(new BorderLayout());
		
		Panel pnlTitulo = new Panel();
		Label lblTitulo = new Label("Rellena el formulario");
		lblTitulo.setEnabled(true);
		pnlTitulo.add(lblTitulo);
		f.add(pnlTitulo, BorderLayout.NORTH);
		
		Panel pnlForm = new Panel();
		pnlForm.setLayout(new GridLayout(2,2));
		
		Label lblNombre = new Label("Nombre:");
		pnlForm.add(lblNombre);
		
		TextField txtNombre = new TextField("Amaia", 20);
		pnlForm.add(txtNombre);
		
		Label lblApellidos = new Label("Apellidos:");
		pnlForm.add(lblApellidos);
		
		TextField txtApellidos = new TextField("Pikatza Huerga", 20);
		pnlForm.add(txtApellidos);
		
		f.add(pnlForm, BorderLayout.CENTER);
		
		Panel pnlBotones = new Panel();
		
		Button btnGuardar = new Button("Guardar");
		pnlBotones.add(btnGuardar);
		
		Button btnSalir = new Button("Salir");
		pnlBotones.add(btnSalir);
		
		f.add(pnlBotones, BorderLayout.SOUTH);
	}
}
