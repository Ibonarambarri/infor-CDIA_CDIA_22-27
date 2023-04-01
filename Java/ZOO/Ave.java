package ZOO;

public class Ave extends Animal{
	//Atributos
	protected double tamanyo;
	protected String color;
	public double getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(double tamanyo) {
		this.tamanyo = tamanyo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Ave() {
		super();
		tamanyo = 0;
		color = "";
	}
	public Ave(Ave a) {
		super(a);
		this.tamanyo = a.tamanyo;
		this.color = a.color;
	}
	public Ave(String nombre, String especie, int edad, double peso, double longitud, double tamanyo, String color) {
		super(nombre, especie, edad, peso, longitud);
		this.tamanyo = tamanyo;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Ave [tamanyo=" + tamanyo + ", color=" + color + ", nombre=" + nombre + ", especie=" + especie
				+ ", edad=" + edad + ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	@Override
	public void hablar() {
		System.out.println("pio pio");
	}
	
}
