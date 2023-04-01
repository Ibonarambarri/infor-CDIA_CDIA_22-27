package examenInfor;

public abstract class Usuario {
	protected static int cont = 0;
	protected int codigo;
	protected String nombre;
	protected String apellidos;
	protected double saldo;
	
	public static int getCont() {
		return cont;
	}
	public int getCodigo() {
		return codigo;
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
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Usuario() {
		super();
		this.codigo = cont;
		cont++;
		this.nombre = "";
		this.apellidos = "";
		this.saldo = 0;
	}
	public Usuario(String nombre, String apellidos, double saldo) {
		super();
		this.codigo = cont;
		cont++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ "]";
	}	
}
