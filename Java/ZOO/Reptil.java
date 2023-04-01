package ZOO;

public class Reptil extends Animal{
	//Atributos
	protected boolean venenoso;

	public boolean isVenenoso() {
		return venenoso;
	}

	public void setVenenoso(boolean venenoso) {
		this.venenoso = venenoso;
	}

	public Reptil() {
		super();
		venenoso = false;
	}

	public Reptil(Reptil r) {
		super(r);
		this.venenoso = r.venenoso;
	}

	public Reptil(String nombre, String especie, int edad, double peso, double longitud, boolean venenoso) {
		super(nombre, especie, edad, peso, longitud);
		this.venenoso = venenoso;
	}

	@Override
	public String toString() {
		return "Reptil [venenoso=" + venenoso + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad
				+ ", peso=" + peso + ", longitud=" + longitud + "]";
	}

	@Override
	public void hablar() {
		System.out.println("Reptil hablando...");
		
	}
	
}
