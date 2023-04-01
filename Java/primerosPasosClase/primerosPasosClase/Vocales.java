package primerosPasosClase;

import java.util.Scanner;

public class Vocales {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase = entrada.nextLine();
		
		String newFrase = "";
		for(int i = 0; i < frase.length();i++) {
			switch(frase.charAt(i)){
				case 'a':case 'e': case 'i': case 'o': case 'u':
					newFrase += '*';
					break;
				default:
					newFrase += frase.charAt(i);
			}
		}
		System.out.println(newFrase);

	}

}
