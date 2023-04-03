package examen1ErikEguskiza;

//Es una clase abstracta por que tiene un metodo que funciona de manera distinta entre sus hijas.
public abstract class Contenido {
	protected String titulo; 
	protected String descripcion; 
	protected String fecha; 
	protected int nLikes; 
	 
	public Contenido() {
		this.titulo = "vacio";
		this.descripcion = "vacio";
		this.fecha = "vacio";
		this.nLikes = 0;
	}

	public Contenido(String titulo, String descripcion, String fecha, int nLikes) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.nLikes = nLikes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getnLikes() {
		return nLikes;
	}

	public void setnLikes(int nLikes) {
		this.nLikes = nLikes;
	}
	
	protected abstract int monetizar();
 
	@Override
	public String toString() {
		return "Contenido [titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha + ", nLikes="
				+ nLikes + "]"; 
	}
}
