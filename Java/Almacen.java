package ariketasObjetos;
import java.util.ArrayList;

public class Almacen {
	String nombre; 
	ArrayList <Caja> cajas;
	
	
	public Almacen() {
	}

	public Almacen(String nombre, ArrayList<Caja> cajas) {
		super();
		this.nombre = nombre;
		this.cajas = cajas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(ArrayList<Caja> cajas) {
		this.cajas = cajas;
	}

	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", cajas=" + cajas + "]";
	}
	
	
	
	
	
	
 
}
