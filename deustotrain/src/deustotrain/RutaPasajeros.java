package deustotrain;

import java.util.ArrayList;

public class RutaPasajeros extends Ruta implements Reservable {
	protected int primera;
	protected int segunda;
	protected int cochecama;
	protected ArrayList<Pasajero> pasajeros;
	
	public RutaPasajeros(Tren tren, ArrayList<Trayecto> trayectos, int primera, int segunda, int cochecama,
			ArrayList<Pasajero> pasajeros) {
		super(tren, trayectos);
		this.primera = primera;
		this.segunda = segunda;
		this.cochecama = cochecama;
		this.pasajeros = new ArrayList<Pasajero>(pasajeros);
	}
	
	public RutaPasajeros() {
		super();
		this.pasajeros = new ArrayList<Pasajero>();
	}

	public int getPrimera() {
		return primera;
	}

	public void setPrimera(int primera) {
		this.primera = primera;
	}

	public int getSegunda() {
		return segunda;
	}

	public void setSegunda(int segunda) {
		this.segunda = segunda;
	}

	public int getCochecama() {
		return cochecama;
	}

	public void setCochecama(int cochecama) {
		this.cochecama = cochecama;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "RutaPasajeros [primera=" + primera + ", segunda=" + segunda + ", cochecama=" + cochecama
				+ ", pasajeros=" + pasajeros + ", tren=" + tren + ", trayectos=" + trayectos + "]";
	}

	@Override
	double getBeneficioPorKm() {
		return 50 * (this.primera + this.segunda + this.cochecama);
	}

	@Override
	public boolean reservar(Pasajero p) {
		if (pasajeros.contains(p)) {
			return false;
		} else {
			pasajeros.add(p);
			return true;
		}
	}

	@Override
	public boolean anular(Pasajero p) {
		if (pasajeros.contains(p)) {
			pasajeros.remove(p);
			return true;
		} else {
			return false;
		}
	}
	
	
}
