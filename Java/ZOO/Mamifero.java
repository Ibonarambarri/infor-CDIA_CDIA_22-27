package ZOO;

public class Mamifero extends Animal{
	protected int nCrias;

	public int getnCrias() {
		return nCrias;
	}

	public void setnCrias(int nCrias) {
		this.nCrias = nCrias;
	}
	
	public Mamifero() {
		super();
		nCrias = 0;
	}
	public Mamifero(String nombre, String especie, int edad, double peso, double longitud, int nCrias) {
		super(nombre, especie, edad, peso, longitud);
		this.nCrias = nCrias;
	}
	public Mamifero(Mamifero m) {
		super(m);
		nCrias = m.nCrias;
	}

	@Override
	public void hablar() {
		System.out.println("Hablo en idioma mamifero.");
	}

	@Override
	public String toString() {
		return "Mamifero [nCrias=" + nCrias + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad
				+ ", peso=" + peso + ", longitud=" + longitud + "]";
	}
	
	
	
}
