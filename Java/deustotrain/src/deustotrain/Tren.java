package deustotrain;

public class Tren {
	public static int contador = 1;
	
	protected int codigo;
	protected double cv;
	protected String modelo;
	
	public Tren(double cv, String modelo) {
		super();
		this.codigo = Tren.contador;
		Tren.contador++;
		this.cv = cv;
		this.modelo = modelo;
	}
	
	public Tren() {
		super();
		this.codigo = Tren.contador;
		Tren.contador++;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getCv() {
		return cv;
	}

	public void setCv(double cv) {
		this.cv = cv;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Tren [codigo=" + codigo + ", cv=" + cv + ", modelo=" + modelo + "]";
	}
	
	
}
