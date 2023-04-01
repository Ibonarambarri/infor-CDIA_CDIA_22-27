package interfaces;

public class Triangulo extends Forma{
	protected double h;
	protected double b;
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public Triangulo() {
		super();
		this.b = 0;
		this.h = 0;
	}
	public Triangulo(Triangulo f) {
		super(f);
		this.b = f.b;
		this.h = f.h;
	}
	public Triangulo(String color, double h, double b) {
		super(color);
		this.h = h;
		this.b = b;
	}
	@Override
	public String toString() {
		return "Triangulo [h=" + h + ", b=" + b + ", color=" + color + "]";
	}
	@Override
	public void dibujar() {
		System.out.println("Dibujando triangulo..");		
	}
	
	
	
}
