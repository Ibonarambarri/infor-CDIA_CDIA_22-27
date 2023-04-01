package ZOO;

public class Zoo {
	
	public static void main(String[] args) {
		Animal a1 = new Mamifero();
		Animal a2 = new Pez();
		
		a1.hablar();
		a2.hablar();
	}
}
