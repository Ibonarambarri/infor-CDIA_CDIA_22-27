package deustotrain;

import java.util.ArrayList;

public class Estacion implements Reservable {
	protected String nombre;
	protected double latitud;
	protected double longitud;
	protected boolean cafeteria;
	protected ArrayList<Pasajero> pasajeros;
	
	public Estacion(String nombre, double latitud, double longitud, boolean cafeteria, ArrayList<Pasajero> pasajeros) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.cafeteria = cafeteria;
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public Estacion() {
		super();
		this.nombre = "";
		this.pasajeros = new ArrayList<Pasajero>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public boolean isCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(boolean cafeteria) {
		this.cafeteria = cafeteria;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + ", cafeteria="
				+ cafeteria + ", pasajeros=" + pasajeros + "]";
	}

	@Override
	public boolean reservar(Pasajero p) {
		if (cafeteria) {
			if (pasajeros.contains(p)) {
				return false;
			} else {
				pasajeros.add(p);
				return true;
			}
		} else {
			return false;
		}
	}
		

	@Override
	public boolean anular(Pasajero p) {
		if (cafeteria) {
			if (pasajeros.contains(p)) {
				pasajeros.remove(p);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	
}
