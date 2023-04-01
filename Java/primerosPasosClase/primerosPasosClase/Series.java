package primerosPasosClase;

public class Series {

	public static void main(String[] args) {
		/*
		 * Estructura de los for (donde empiezo; mientras que; que hago con el iterador)
		 */
		System.out.println("Del 1 al 10:");
		for(int i = 1;i <=10;i++) {
			System.out.print(i + " ");
		}
		
		//cada \n inserta un cambio de linea
		// es lo mismo que poner 2 veces System.out.println(); antes 
		System.out.println("\n\nDel 1 al 1000:"); 
		for(int i = 1;i <=1000;i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n\nDel 20 al 500 de 10 en 10:");
		for(int i = 20;i <=500;i+=10) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n\nDel 10 al:");
		for(int i = 10;i >=0;i--) {
			System.out.print(i + " ");
		}

	}

}
