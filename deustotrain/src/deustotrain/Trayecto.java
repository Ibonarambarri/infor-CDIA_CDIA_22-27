package deustotrain;

public class Trayecto {
	protected Estacion origen;
	protected Estacion destino;
	protected double km;
	
	public Trayecto(Estacion origen, Estacion destino, double km) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.km = km;
	}
	
	public Trayecto() {
		super();
	}

	public Estacion getOrigen() {
		return origen;
	}

	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}

	public Estacion getDestino() {
		return destino;
	}

	public void setDestino(Estacion destino) {
		this.destino = destino;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Trayecto [origen=" + origen + ", destino=" + destino + ", km=" + km + "]";
	}
	
}
