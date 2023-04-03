package examen1ErikEguskiza;
import java.util.ArrayList;

public class Usuario {
	private static int count = 0; 
	private String nombre;
	private String apellidos; 
	private String correo; 
	private String contraseña; 
	private ArrayList <Contenido> contenido; 
	private int nserie; 

	public Usuario() {
		this.nombre = "vacio";
		this.apellidos = "vacio";
		this.correo = "vacio";
		this.contraseña = "vacio"; 
		this.contenido = null;
		this.nserie = count;
		count++; 
	}

	public Usuario(String nombre, String apellidos, String correo, String contraseña, ArrayList<Contenido> contenido) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contraseña = contraseña;
		this.contenido = contenido;
		this.nserie = count;
		count++; 
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public ArrayList<Contenido> getContenido() {
		return contenido;
	}

	public void setContenido(ArrayList<Contenido> contenido) {
		this.contenido = contenido;
	}

	public int getNserie() {
		return nserie;
	}

	public void setNserie(int nserie) {
		this.nserie = nserie;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", contraseña="
				+ contraseña + ", contenido=" + contenido + ", nserie=" + nserie + "]";
	}
}
