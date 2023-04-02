package ariketasObjetos;

public class Caja {
	private static int count = 0;
	protected String modelo; 
	protected String color; 
	protected double altura; //valor entre 5 y 15
	protected double anchura; //valor 0 y 5
	protected boolean llena; 
	protected int nserie;
	
	
	public Caja() {
		this.nserie = count;
		count++;
	}

	public Caja(String modelo, String color, double altura, double anchura, boolean llena) {
		this.modelo = modelo;
		this.color = color;
		if(altura >= 5 && altura <= 15) {
			this.altura = altura;
		}else {
			throw new IllegalArgumentException("El valor de la caja tiene que estar en el rango permitido");
		}
		if(anchura>= 0 && anchura <= 5) {
			this.anchura = anchura;
		}else {
			throw new IllegalArgumentException("El valor de la caja tiene que estar en el rango permitido");
		}
		this.llena = llena;
		this.nserie = count;
		count++; 
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAnchura() {
		return anchura;
	}

	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}

	public boolean isLlena() {
		return llena;
	}

	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public int getNserie() {
		return nserie;
	}

	public void setNserie(int nserie) {
		this.nserie = nserie;
	}

	@Override
	public String toString() {
		return "Caja [modelo=" + modelo +"-"+ nserie + ", color=" + color + ", altura=" + altura + ", anchura=" + anchura
				+ ", llena=" + llena + ", nserie=" + nserie + "]";
	} 
}
