package deustotravel;

import java.util.ArrayList;

public class Excursion implements Cobrable {
	protected String nombre;
	protected ArrayList<Trayecto> trayectos;
	protected boolean pagada;
	
	public Excursion(String nombre, ArrayList<Trayecto> trayectos, boolean pagada) {
		super();
		this.nombre = nombre;
		this.trayectos = new ArrayList<Trayecto>(trayectos);
		this.pagada = pagada;
	}
	
	public Excursion() {
		super();
		this.nombre = "";
		this.trayectos = new ArrayList<Trayecto>();
		this.pagada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	@Override
	public String toString() {
		return "Excursion [nombre=" + nombre + ", trayectos=" + trayectos + ", pagada=" + pagada + "]";
	}

	@Override
	public double calcularCoste() {
		double resultado = 0;
		
		for (Trayecto trayecto : trayectos) {
			resultado += trayecto.getDistancia() * trayecto.getTransporte().getPrecioPorKm();
		}
		
		return resultado;
	}

	@Override
	public boolean cobrar() {
		if (this.pagada) {
			return false;
		} else {
			this.pagada = true;
			return true;
		}
	}
	
	public static Excursion getExcursionMasCara(ArrayList<Excursion> excursiones) {
		Excursion mayor = excursiones.get(0);
		
		for (Excursion excursion : excursiones) {
			if (excursion.calcularCoste() > mayor.calcularCoste()) {
				mayor = excursion;
			}
		}
		
		return mayor;
	}
	
}
