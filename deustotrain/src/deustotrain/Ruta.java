package deustotrain;

import java.util.ArrayList;

abstract public class Ruta {
	protected Tren tren;
	protected ArrayList<Trayecto> trayectos;
	
	public Ruta(Tren tren, ArrayList<Trayecto> trayectos) {
		super();
		this.tren = tren;
		this.trayectos = new ArrayList<Trayecto>(trayectos);
	}
	
	public Ruta() {
		super();
		this.trayectos = new ArrayList<Trayecto>();
	}

	public Tren getTren() {
		return tren;
	}

	public void setTren(Tren tren) {
		this.tren = tren;
	}

	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}

	@Override
	public String toString() {
		return "Ruta [tren=" + tren + ", trayectos=" + trayectos + "]";
	}
	
	abstract double getBeneficioPorKm();
	
	public static Ruta getRutaMasBeneficiosa(ArrayList<Ruta> rutas) {
		Ruta mayor = rutas.get(0);
		
		for (Ruta ruta : rutas) {
			if (ruta.getBeneficioPorKm() > mayor.getBeneficioPorKm()) {
				mayor = ruta;
			}
		}
		
		return mayor;
	}
	
}
