package ariketasObjetos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList <Caja> cajas = new ArrayList <Caja>();
		Caja c1 = new Caja();
		Caja c3 = new Caja("Kutxa", "Berdea", 5.0, 4.0, true);
		cajas.add(c1);
		cajas.add(c3);
		CajaRegalo c2 = new CajaRegalo("Kutxa", "Berdea", 5.0, 4.0, true, true);
//		System.out.println(c2);
//		System.out.println(c1);
		Almacen almacen1 = new Almacen("EHU", cajas);
//		System.out.println(almacen1);
		
		
		HashMap<String, Integer> valoresAlmacen = new HashMap<>();
		
		for (Caja kutxa : cajas) {
			String nombre = kutxa.getModelo();
			int numero = kutxa.getNserie();
			valoresAlmacen.put(nombre, numero);
		}
		
		System.out.println(valoresAlmacen);
		
		Repartidor habibi = new Repartidor("Habibi", c3);
		System.out.println(habibi);
		
		
		
		
		/*
		while(true) {
			System.out.println("CONTRUCTOR DE CAJAS");
			System.out.println("Modelo: ");
			String m = entrada.nextLine();
			System.out.println("Color: ");
			String c = entrada.nextLine();
			System.out.println("Altura: (Entre 5 y 15)");
			double altura = entrada.nextDouble();
			System.out.println("Anchura: (Entre 0 y 5)");
			double anchura = entrada.nextDouble();
			System.out.println("¿Esta llena la caja? (s/n)");
			String p = entrada.nextLine();
			String pregunta = entrada.nextLine();
			pregunta.toLowerCase();
			boolean llena = false; 
			if(pregunta.equals("s")) {
				llena = true;
			}else if (pregunta.equals("n")) {
				llena = false;
			}else {
				System.out.println("Mete bien los datos cabron que es 's' o 'n'.");
			}
			
			try {
				Caja c2 = new Caja(m, c, altura, anchura, llena);
				break; 
			}catch(IllegalArgumentException e){
				System.out.println("Los datos no estan bien, intentalo de nuevo, pareces gipuzkoano. ");
			}
			*/
			
			
			
		}
		
		
	} 
