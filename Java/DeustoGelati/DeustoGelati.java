package POO;

public class DeustoGelati {

	public static void main(String[] args) {
		
		//Sabor
		Sabor sabor1;
		sabor1 = new Sabor();
		System.out.println(sabor1);
		
		Sabor sabor2 = new Sabor("Vainilla", (float)5.6,(float) 4.8, (float) 7.9);
		System.out.println(sabor2);
		
		Sabor sabor3 = new Sabor(sabor2);
		System.out.println(sabor3);
		
		System.out.println(sabor1.getNombre());
		
		sabor3.setNombre("Nata");
		System.out.println(sabor3);
		System.out.println(sabor2);
		
		String str = sabor1.toString();
		System.out.println(str);
		
		//Helado
		Helado helado1 = new Helado();
		System.out.println(helado1);
		
		Sabor[] sabores = new Sabor[3];
		sabores[0] = new Sabor(sabor1);
		sabores[1] = new Sabor(sabor2);
		sabores[2] = new Sabor(sabor3);
		
		Helado helado2 = new Helado(1, 2, "sin cobertura", true, sabores);
		System.out.println(helado2);
		
		Helado helado3 = new Helado(helado2);
		System.out.println(helado3);
		
		helado3.setTipo(3);
		helado3.setCobertura("Chocolate");
		helado3.setAdornos(true);
		System.out.println(helado3);
		
		double precio1 = helado1.getPrecio();
		double precio2 = helado2.getPrecio();
		double precio3 = helado3.getPrecio();
		
		System.out.println("Helado 1: " + precio1);
		System.out.println("Helado 2: " + precio2);
		System.out.println("Helado 3: " + precio3);
	}

}
