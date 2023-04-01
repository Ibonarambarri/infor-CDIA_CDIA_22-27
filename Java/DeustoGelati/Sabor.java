package POO;

public class Sabor {
	
	//Atributos
	private String nombre;
	private float hidratos;
	private float proteinas;
	private float grasas;
	
	//Getters y setters
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getHidratos() {
		return this.hidratos;
	}
	public void setHidratos(float hidratos) {
		this.hidratos = hidratos;
	}
	public float getProteinas() {
		return this.proteinas;
	}
	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}
	public float getGrasas() {
		return this.grasas;
	}
	public void setGrasas(float grasas) {
		this.grasas = grasas;
	}
	
	//Constructores
	public Sabor() {
		this.nombre = "Chocolate";
		this.hidratos = 0;
		this.proteinas = 0;
		this.grasas = 0;
	}
	public Sabor(String nombre, float hidratos, float proteinas, float grasas) {
		this.nombre = nombre;
		this.hidratos = hidratos;
		this.proteinas = proteinas;
		this.grasas = grasas;
	}
	public Sabor(Sabor sabor) {
		this.nombre = sabor.nombre;
		this.hidratos = sabor.hidratos;
		this.proteinas = sabor.proteinas;
		this.grasas = sabor.grasas;
	}
	
	//toString()
	public String toString() {
		return this.nombre + " (hidratos: " + this.hidratos +
			", proteinas: " + this.proteinas + ", grasas: " + this.grasas + ")";
	}

}
