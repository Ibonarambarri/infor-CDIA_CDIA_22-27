package primerosPasosClase;

import java.util.Scanner;

public class Clave {

	public static void main(String[] args) {
		//Solicitar un número
		Scanner entrada = new Scanner(System.in);
		int num = entrada.nextInt();
		
		//Generar clave de esa longitud
		int[] clave = new int[num];
		
		for(int i = 0; i <clave.length; i++) {
			clave[i] = (int) (Math.random()*9+0);
		}
		for (int i = 0; i<clave.length;i++) {
			System.out.print(clave[i]);
		}
		
	}

}
