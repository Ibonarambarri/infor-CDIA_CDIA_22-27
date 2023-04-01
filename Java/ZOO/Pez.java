package ZOO;

public class Pez extends Animal{
	protected double velocidad;
	protected boolean aguaDulce;
	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isAguaDulce() {
		return aguaDulce;
	}

	public void setAguaDulce(boolean aguaDulce) {
		this.aguaDulce = aguaDulce;
	}
	public Pez() {
		super();
		velocidad = 0;
		aguaDulce = false;
	}
	public Pez(double velocidad, boolean aguaDulce) {
		super();
		this.velocidad = velocidad;
		this.aguaDulce = aguaDulce;
	}
	public Pez(Pez p) {
		super(p);
		velocidad = p.velocidad;
		aguaDulce = p.aguaDulce;
	}
	@Override
	public void hablar() {
		System.out.println("Glu glu");
	}

	@Override
	public String toString() {
		return "Pez [velocidad=" + velocidad + ", aguaDulce=" + aguaDulce + ", nombre=" + nombre + ", especie="
				+ especie + ", edad=" + edad + ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	
	
}
