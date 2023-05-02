package MisCojones33;

import java.awt.*;
import javax.swing.*;


public class VentanaSalida extends JFrame {

    private static final long serialVersionUID = 1L;

    //Atributos Ventana
    private JLabel lblDia, lblMes, lblHora, lblLugar;
    private JTextField txtDia, txtMes, txtHora, txtLugar;
    private JButton btnAgregar;

    public VentanaSalida(Decathlon ventana) {
        this.setTitle("Club de montaña");
        this.setVisible(true);
        this.setSize(500, 600);
        this.setLocationRelativeTo(ventana);
        Font fuente = new Font("Cambria", Font.BOLD, 30);
        Font fuente2 = new Font("Cambria", Font.BOLD, 20);
        Font fuente3 = new Font("Cambria", Font.ITALIC, 15);

        // Creación de los componentes de la ventana
        lblDia = new JLabel("Día: ");
        lblDia.setFont(fuente);
        txtDia = new JTextField();
        txtDia.setFont(fuente3);

        lblMes = new JLabel("Mes: ");
        lblMes.setFont(fuente);
        txtMes = new JTextField();
        txtMes.setFont(fuente3);

        lblHora = new JLabel("Hora: ");
        lblHora.setFont(fuente);
        txtHora = new JTextField();
        txtHora.setFont(fuente3);

        lblLugar = new JLabel("Lugar: ");
        lblLugar.setFont(fuente);
        txtLugar = new JTextField();
        txtLugar.setFont(fuente3);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(fuente2);

        // Configuración del diseño de la ventana
        setLayout(new GridLayout(5, 2, 10, 10));

        // Añadir los componentes a la ventana
        add(lblDia);
        add(txtDia);

        add(lblMes);
        add(txtMes);

        add(lblHora);
        add(txtHora);

        add(lblLugar);
        add(txtLugar);

        add(new JLabel(""));
        add(btnAgregar);

        // Configurar acciones de los botones
        btnAgregar.addActionListener(e -> {
            int dia = Integer.parseInt(txtDia.getText());
            int mes = Integer.parseInt(txtMes.getText());
            int hora = Integer.parseInt(txtHora.getText());
            String lugar = txtLugar.getText();
            Salida nueva = new Salida(dia, mes, hora, lugar);
            ventana.agregarSalida(nueva);
        });

        //Ocultar la otra ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ventana.setVisible(true); // Mostrar ventana principal al cerrar ventana V
            }
        });
    }
}
