package primerosPasosClase;

public class Menor {

	public static void main(String[] args) {
		//array 100 posiciones
		int[] array = new int[100];
		//numeros aleatorios 1 - 1000
		for(int i = 0; i<array.length; i++) {
			array[i] = (int)(Math.random()*1000+1);
		}
		
		int menor = 1001;
		int mayor = 0;
		int posicion = -1;
		
		// recorremos array
		for(int i = 0; i<array.length;i++) {
		// comparar con el menor
			if(array[i] < menor) {
				// si es menor -> actualizamos (guardar posicion)
				menor = array[i];
				posicion = i;
			}
			if(array[i] > mayor) {
				mayor = array[i];
			}
		}
		
		System.out.println("El menor número es " + menor + " y "
				+ " está en la posición " + posicion);
		System.out.println("Rango: " + (mayor-menor) + " (" + mayor + "-" + menor + ")");
	}

}
