package interfaces;

public class Number {
	protected double dato;

	public double getDato() {
		return dato;
	}
	public void setDato(double dato) {
		this.dato = dato;
	}
	
	public Number() {
		super();
		this.dato = 0;
	}
	public Number(double dato) {
		super();
		this.dato = dato;
	}
	public Number(Number n) {
		super();
		this.dato = n.dato;
	}
	
	@Override
	public String toString() {
		return "Number [dato=" + dato + "]";
	}	
	
}
