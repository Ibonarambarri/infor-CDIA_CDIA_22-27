package deustotravel;

abstract public class Transporte {
	public static int contador = 1;
	
	protected int codigo;
	protected int npersonas;
	
	public Transporte(int npersonas) {
		super();
		this.codigo = Transporte.contador;
		Transporte.contador++;
		this.npersonas = npersonas;
	}
	
	public Transporte() {
		super();
		this.codigo = Transporte.contador;
		Transporte.contador++;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getNpersonas() {
		return npersonas;
	}

	public void setNpersonas(int npersonas) {
		this.npersonas = npersonas;
	}

	@Override
	public String toString() {
		return "Transporte [codigo=" + codigo + ", npersonas=" + npersonas + "]";
	}
	
	abstract double getPrecioPorKm();
}
