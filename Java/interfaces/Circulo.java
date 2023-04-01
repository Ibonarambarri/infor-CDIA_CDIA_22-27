package interfaces;

public class Circulo extends Forma{
	protected double radio;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Circulo() {
		super();
		this.radio = 0;
	}

	public Circulo(Circulo f) {
		super(f);
		this.radio = f.radio;
	}

	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", color=" + color + "]";
	}

	@Override
	public void dibujar() {
		System.out.println("Dibujando circulo...");
		
	}
	
	
}
