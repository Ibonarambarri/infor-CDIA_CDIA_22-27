package interfaces;

public class Texto implements Dibujable, Imprimible{
	protected String texto;
	protected String color;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public Texto() {
		super();
		this.texto = "Hola mundo!";
		this.color = "azul";
	}
	public Texto(String texto, String color) {
		super();
		this.texto = texto;
		this.color = color;
	}
	public Texto(Texto t) {
		super();
		this.texto = t.texto;
		this.color = t.color;
	}
	

	@Override
	public String toString() {
		return "Texto [texto=" + texto + ", color=" + color + "]";
	}
	public void dibujar() {
		System.out.println("Dibujando texto: " + texto);
	}
	@Override
	public void imprimir() {
		System.out.println(texto);
		
	}
}
