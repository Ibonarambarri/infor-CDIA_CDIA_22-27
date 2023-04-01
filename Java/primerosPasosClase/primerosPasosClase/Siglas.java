package primerosPasosClase;

import java.util.Scanner;

public class Siglas {

	public static void main(String[] args) {
		// Solicitar un frase
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase = entrada.nextLine();
		
		String siglas = "";
		siglas += frase.charAt(0);
		
		// Recorrer la frase
		for(int i = 0; i<frase.length(); i++) {
			// Encontrar el espacio
			if(frase.charAt(i) == ' ') {
				// Seleccionar la siguiente letra
				siglas += frase.charAt(i+1);
			}
		}
		siglas = siglas.toUpperCase();
		System.out.println(siglas);
		
		// (int)(Math.random()*1000+1);
	}

}
