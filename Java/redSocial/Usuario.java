package redSocial;

public class Usuario {
	protected String nombre;
	protected String pass;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Usuario() {
		super();
		this.nombre = "";
		this.pass = "";
	}
	public Usuario(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}
	public Usuario(Usuario u) {
		super();
		this.nombre = u.nombre;
		this.pass = u.pass;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + "]";
	}
}
