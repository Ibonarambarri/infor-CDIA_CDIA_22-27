package interfaces;

public abstract class Forma implements Dibujable{
	protected String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Forma() {
		super();
		this.color = "Rojo";
	}
	public Forma(String color) {
		super();
		this.color = color;
	}
	public Forma(Forma f) {
		super();
		this.color = f.color;
	}

	@Override
	public String toString() {
		return "Forma [color=" + color + "]";
	}

	@Override
	abstract public void dibujar();
	
	
}
