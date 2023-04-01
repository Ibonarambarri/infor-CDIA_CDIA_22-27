package interfaces;

import java.util.ArrayList;

public class Dataset implements BD, LocalXML{
	protected String nombre;
	protected String propietario;
	protected ArrayList<Number> datos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public ArrayList<Number> getDatos() {
		return datos;
	}
	//Cambiarlo a copia profunda
	public void setDatos(ArrayList<Number> datos) {
		if(this.datos == null) {
			this.datos = new ArrayList<Number>();
		}
		if(datos != null) {
			for(int i = 0; i < datos.size(); i++) {
				if(datos.get(i) != null) {
					this.datos.add(datos.get(i));
				}
			}
		}
	}
	public Dataset() {
		nombre = "";
		propietario = "";
		datos = new ArrayList<Number>();
	}
	public Dataset(String nombre, String propietario, ArrayList<Number> datos) {
		super();
		this.nombre = nombre;
		this.propietario = propietario;
		this.datos = new ArrayList<Number>();
		
		if(datos != null) {
			for(int i = 0; i < datos.size(); i++) {
				if(datos.get(i) != null) {
					this.datos.add(datos.get(i));
				}
			}
		}
	}
	public Dataset(Dataset d) {
		this.nombre = d.nombre;
		this.propietario = d.propietario;
		this.datos = new ArrayList<Number>();
		
		if(d.datos != null) {
			for(int i = 0; i < d.datos.size(); i++) {
				if(d.datos.get(i) != null) {
					this.datos.add(d.datos.get(i));
				}
			}
		}
	}
	@Override
	public String toString() {
		return "Dataset [nombre=" + nombre + ", propietario=" + propietario + ", datos=" + datos + "]";
	}

	@Override
	public void guardarBD(String bd) {
		System.out.println("Guardando de BD: " + bd);
		
	}
	@Override
	public void leerBD(String bd) {
		System.out.println("Leyendo de BD: " + bd);
		
	}
	@Override
	public void guardarFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leerFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leerFicheroXML() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void guardarFicheroXML() {
		// TODO Auto-generated method stub
		
	}
	
}
