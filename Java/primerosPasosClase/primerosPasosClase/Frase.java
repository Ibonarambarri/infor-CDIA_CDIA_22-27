package primerosPasosClase;

import java.util.Scanner;

public class Frase {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase = entrada.nextLine();
		
		int espacios = 0;
		for(int i = 0; i < frase.length(); i++) {
			if(frase.charAt(i) == ' ') {
				espacios++;
			}
		}
		System.out.println(espacios + " espacios");
		
		for (int i = frase.length()-1; i >=0; i--) {
			System.out.print(frase.charAt(i));
		}
	}

}
