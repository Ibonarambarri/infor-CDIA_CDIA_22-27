package deustotravel;

public class Guia implements Cobrable {
	protected String nombre;
	protected double precio;
	protected int npersonas;
	protected boolean pagada;
	
	public Guia(String nombre, double precio, int npersonas, boolean pagada) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.npersonas = npersonas;
		this.pagada = pagada;
	}
	
	public Guia() {
		super();
		this.nombre = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNpersonas() {
		return npersonas;
	}

	public void setNpersonas(int npersonas) {
		this.npersonas = npersonas;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	@Override
	public String toString() {
		return "Guia [nombre=" + nombre + ", precio=" + precio + ", npersonas=" + npersonas + ", pagada=" + pagada
				+ "]";
	}

	@Override
	public double calcularCoste() {
		return this.precio * this.npersonas;
	}

	@Override
	public boolean cobrar() {
		if (this.pagada) {
			return false;
		} else {
			this.pagada = true;
			return true;
		}
	}
	
}
