package deustotrain;

import java.util.ArrayList;

public class RutaMercancias extends Ruta {
	protected double carga;

	public RutaMercancias(Tren tren, ArrayList<Trayecto> trayectos, double carga) {
		super(tren, trayectos);
		this.carga = carga;
	}
	
	public RutaMercancias() {
		super();
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	@Override
	public String toString() {
		return "RutaMercancias [carga=" + carga + ", tren=" + tren + ", trayectos=" + trayectos + "]";
	}

	@Override
	double getBeneficioPorKm() {
		return this.carga / this.tren.getCv();
	}
	
	
}
