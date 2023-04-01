package interfaces;

public class Principal {

	public static void main(String[] args) {
		Forma f = new Triangulo();
		Forma f2 = new Circulo();
		f.dibujar();
		f2.dibujar();
		
		Texto t = new Texto();
		t.dibujar();
		t.imprimir();
	}

}
