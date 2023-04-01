package redSocial;

import java.util.ArrayList;

public class RedSocial {

	public static void main(String[] args) {
		Usuario a = new Usuario("pepe", "pepe1234");
		Usuario b = new Usuario("juan", "juan4321");
		ArrayList<Usuario> arr = new ArrayList<Usuario>();
		arr.add(a);
		arr.add(null);
		Texto t = new Texto(a, "16/03/2023", arr, "Hola mundo!");
		t.setFavs(null);
		System.out.println(t);
		for(int i = 0; i < arr.size(); i++) {
			System.out.println("hola");
		}
		
	}

}
