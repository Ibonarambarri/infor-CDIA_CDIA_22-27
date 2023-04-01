package primerosPasosClase;

import java.util.Scanner;

public class Museo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Edad: ");
		int edad = entrada.nextInt();
		
		if(edad < 5) {
			System.out.println("Entra gratis");
		}else if( edad < 18) {
			System.out.println("5€");
		}else if( edad > 65) {
			System.out.println("7€");
		}else {
			System.out.println("10€");
		}

	}

}
