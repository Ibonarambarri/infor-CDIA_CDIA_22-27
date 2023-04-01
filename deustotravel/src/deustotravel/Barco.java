package deustotravel;

public class Barco extends Transporte {
	protected double calado;
	protected boolean diesel;
	
	public Barco(int npersonas, double calado, boolean diesel) {
		super(npersonas);
		this.calado = calado;
		this.diesel = diesel;
	}
	
	public Barco() {
		super();
	}

	public double getCalado() {
		return calado;
	}

	public void setCalado(double calado) {
		this.calado = calado;
	}

	public boolean isDiesel() {
		return diesel;
	}

	public void setDiesel(boolean diesel) {
		this.diesel = diesel;
	}

	@Override
	public String toString() {
		return "Barco [calado=" + calado + ", diesel=" + diesel + ", codigo=" + codigo + ", npersonas=" + npersonas
				+ "]";
	}

	@Override
	double getPrecioPorKm() {
		if (this.diesel) {
			return this.calado * 0.8;
		} else {
			return this.calado * 1.5;
		}
	}
	
	
}
