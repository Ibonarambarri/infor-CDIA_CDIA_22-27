package ZOO;

public abstract class Animal {
	//Atributos
	protected String nombre;
	protected String especie;
	protected int edad;
	protected double peso;
	protected double longitud;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public Animal () {
		nombre = "";
		especie = "";
		edad = 0;
		peso = 0;
		longitud = 0;
	}
	public Animal(String nombre, String especie, int edad, double peso, double longitud) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.peso = peso;
		this.longitud = longitud;
	}
	public Animal(Animal a) {
		this.nombre = a.nombre;
		this.especie = a.especie;
		this.edad = a.edad;
		this.peso = a.peso;
		this.longitud = a.longitud;
	}
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + ", longitud="
				+ longitud + "]";
	}
	
	abstract public void hablar();
}
