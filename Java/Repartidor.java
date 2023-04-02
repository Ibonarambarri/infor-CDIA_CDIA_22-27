package ariketasObjetos;

public class Repartidor {
	private String nombre; 
	private Caja caja;
	
	
	public Repartidor(String nombre, Caja caja) {
		super();
		this.nombre = nombre;
		this.caja = caja;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Caja getCaja() {
		return caja;
	}


	public void setCaja(Caja caja) {
		this.caja = caja;
	}


	@Override
	public String toString() {
		return "Repartidor [nombre=" + nombre + ", caja=" + caja + "]";
	} 
	
	

}
