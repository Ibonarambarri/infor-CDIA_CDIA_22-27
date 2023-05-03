package MisCojones33;

import java.awt.*;
import javax.swing.*;


public class VentanaSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Atributos Ventana
	 private JLabel lblNombre, lblDni, lblEmail, lblTelefono;
	 private JTextField txtNombre, txtDni, txtEmail, txtTelefono;
	 private JButton btnAgregar;
	 
	//Getters y Setters
	 public JTextField getTxtNombre() {
			return txtNombre;
		}

		public void setTxtNombre(JTextField txtNombre) {
			this.txtNombre = txtNombre;
		}

		public JTextField getTxtDni() {
			return txtDni;
		}

		public void setTxtDni(JTextField txtDni) {
			this.txtDni = txtDni;
		}

		public JTextField getTxtEmail() {
			return txtEmail;
		}

		public void setTxtEmail(JTextField txtEmail) {
			this.txtEmail = txtEmail;
		}

		public JTextField getTxtTelefono() {
			return txtTelefono;
		}

		public void setTxtTelefono(JTextField txtTelefono) {
			this.txtTelefono = txtTelefono;
		}
	 
	 

	public VentanaSocio(Decathlon ventana) {
		this.setTitle("Club de montaña");
		this.setVisible(true);
		this.setSize(500, 600);
		this.setLocationRelativeTo(ventana);
		Font fuente = new Font("Cambria", Font.BOLD, 30);
		Font fuente2 = new Font("Cambria", Font.BOLD, 20);
		Font fuente3 = new Font("Cambria", Font.ITALIC, 15);
		
		// Creación de los componentes de la ventana
        lblNombre = new JLabel("Nombre: ");
        lblNombre .setFont(fuente);
        txtNombre = new JTextField();
        txtNombre.setFont(fuente3);

        lblDni = new JLabel("DNI: ");
        lblDni .setFont(fuente);
        txtDni = new JTextField();
        txtDni.setFont(fuente3);

        lblEmail = new JLabel("Email: ");
        lblEmail .setFont(fuente);
        txtEmail = new JTextField();
        txtEmail.setFont(fuente3);

        lblTelefono = new JLabel("Teléfono: ");
        lblTelefono .setFont(fuente);
        txtTelefono = new JTextField();
        txtTelefono.setFont(fuente3);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(fuente2);

        // Configuración del diseño de la ventana
        setLayout(new GridLayout(5, 2, 10, 10));

        // Añadir los componentes a la ventana
        add(lblNombre);
        add(txtNombre);

        add(lblDni);
        add(txtDni);

        add(lblEmail);
        add(txtEmail);

        add(lblTelefono);
        add(txtTelefono);

        add(new JLabel(""));
        add(btnAgregar);

        // Configurar acciones de los botones
        btnAgregar.addActionListener(e -> {
        	String nombre = txtNombre.getText();
        	String dni = txtDni.getText();
        	String telefono = txtEmail.getText();
        	String email = txtTelefono.getText();
        	Socio nuevo = new Socio(nombre, dni, telefono, email);
        	ventana.agregarSocio(nuevo);
        	ventana.setVisible(true);
        	dispose();
        	
        });
        
        
  
		//Ocultar la otra ventana
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ventana.setVisible(true); // Mostrar ventana principal al cerrar ventana V
            }
        });

	}
	
	public VentanaSocio(Decathlon padre, Socio socio) {
		 this.setTitle("Club de montaña");
			this.setVisible(true);
			this.setSize(500, 600);
			this.setLocationRelativeTo(padre);
			Font fuente = new Font("Cambria", Font.BOLD, 30);
			Font fuente2 = new Font("Cambria", Font.BOLD, 20);
			Font fuente3 = new Font("Cambria", Font.ITALIC, 15);
			
			// Creación de los componentes de la ventana
	        lblNombre = new JLabel("Nombre: ");
	        lblNombre .setFont(fuente);
	        txtNombre = new JTextField();
	        txtNombre.setFont(fuente3);

	        lblDni = new JLabel("DNI: ");
	        lblDni .setFont(fuente);
	        txtDni = new JTextField();
	        txtDni.setFont(fuente3);

	        lblEmail = new JLabel("Email: ");
	        lblEmail .setFont(fuente);
	        txtEmail = new JTextField();
	        txtEmail.setFont(fuente3);

	        lblTelefono = new JLabel("Teléfono: ");
	        lblTelefono .setFont(fuente);
	        txtTelefono = new JTextField();
	        txtTelefono.setFont(fuente3);

	        btnAgregar = new JButton("Agregar");
	        btnAgregar.setFont(fuente2);

	        // Configuración del diseño de la ventana
	        setLayout(new GridLayout(5, 2, 10, 10));

	        // Añadir los componentes a la ventana
	        add(lblNombre);
	        add(txtNombre);

	        add(lblDni);
	        add(txtDni);

	        add(lblEmail);
	        add(txtEmail);

	        add(lblTelefono);
	        add(txtTelefono);

	        add(new JLabel(""));
	        add(btnAgregar);

	        // Configurar acciones de los botones
	        btnAgregar.addActionListener(e -> {
	        	padre.borrarSocio(socio);
	        	String nombre = txtNombre.getText();
	        	String dni = txtDni.getText();
	        	String telefono = txtEmail.getText();
	        	String email = txtTelefono.getText();
	        	Socio nuevo = new Socio(nombre, dni, telefono, email);
	        	padre.agregarSocio(nuevo);
	        	padre.setVisible(true);
	        	dispose();
	        });
	        
	        txtNombre.setText(socio.getNombre());
	        txtDni.setText(socio.getDni());
	        txtEmail.setText(socio.getEmail());
	        txtTelefono.setText(socio.getTelefono());
	    
			//Ocultar la otra ventana
			addWindowListener(new java.awt.event.WindowAdapter() {
	            @Override
	            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	                padre.setVisible(true); // Mostrar ventana principal al cerrar ventana V
	            }
	        });
	        
	    }

	

}
