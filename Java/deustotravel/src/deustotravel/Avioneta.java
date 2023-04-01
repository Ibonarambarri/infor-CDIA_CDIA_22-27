package deustotravel;

public class Avioneta extends Transporte {
	protected double peso;
	protected double planeo;
	
	public Avioneta(int npersonas, double peso, double planeo) {
		super(npersonas);
		this.peso = peso;
		this.planeo = planeo;
	}
	
	public Avioneta() {
		super();
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPlaneo() {
		return planeo;
	}

	public void setPlaneo(double planeo) {
		this.planeo = planeo;
	}

	@Override
	public String toString() {
		return "Avioneta [peso=" + peso + ", planeo=" + planeo + ", codigo=" + codigo + ", npersonas=" + npersonas
				+ "]";
	}

	@Override
	double getPrecioPorKm() {
		return this.peso / this.planeo;
	}
	
	
}
