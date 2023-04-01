package examenInfor;

public class Alojamiento {
	protected Anfitrion a;
	protected String nombre;
	protected String descripcion;
	protected double precio;
	
	public Anfitrion getA() {
		return a;
	}
	public void setA(Anfitrion a) {
		this.a = a;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Alojamiento() {
		super();
		this.a = new Anfitrion();
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0;
	}
	public Alojamiento(Anfitrion a, String nombre, String descripcion, double precio) {
		super();
		this.a = a;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Alojamiento [a=" + a + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
}
