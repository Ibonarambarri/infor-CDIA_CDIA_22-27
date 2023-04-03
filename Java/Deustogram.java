package examen1ErikEguskiza;
import java.util.ArrayList;
import java.util.HashMap;
enum clase{CELEBRITY, NORMAL}

public class Deustogram {

	public static void main(String[] args) {
		// LISTA USUARIOS
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		
		//AÑADE 50 USUARIOS
		for (int i = 0; i < 50 ; i++) {
			ArrayList <Contenido> contenido = new ArrayList <Contenido>();
			for (int j = 0 ; j < 2; j++) {
				String[] coments = new String[(int)(Math.random()*2500+500)];
				Publicacion p = new Publicacion("", "", "", (int) (Math.random()*100000+1000), coments);
				Historia h = new Historia("", "", "", (int) (Math.random()*100000+1000), (int) (Math.random()*1000000+100));
				contenido.add(p);
				contenido.add(h);
			}
			Usuario nuevo = new Usuario("usuario-" + i, "", "", "", contenido);
			usuarios.add(nuevo);
		}
		
		System.out.println(usuarios); //--> Con este metodo en el apartado de comentarios se mostrara la direccion de la memoria para evitar imprimir uno a uno y ocupar toda la pantalla.
		//El la clase Publicacion he dejado creado otro metodo toString que si haces uso de el imprime la lista de comentario entera. 
		
		//HASMAP USUARIOS --> Tododos los usuarios van a ser celebrity ya que con los parametros introducidos al minimo saldo sera 4150
		HashMap <clase, ArrayList <Usuario> > users = new HashMap <clase, ArrayList <Usuario>>();
		ArrayList <Usuario> celebrity = new ArrayList <Usuario>();
		ArrayList <Usuario> normal = new ArrayList <Usuario>();
		
		for (Usuario erabiltzaile : usuarios) {
			ArrayList <Contenido> contents = new ArrayList <Contenido>();
			contents.addAll(erabiltzaile.getContenido());
			int saldo = 0; 
			for (Contenido gauzak : contents) {
				saldo += gauzak.monetizar();
			}
			 if (saldo > 1000) {
				 celebrity.add(erabiltzaile);
			 }else {
				 normal.add(erabiltzaile);
		}
		
	}
		users.put(clase.CELEBRITY, celebrity);
		users.put(clase.NORMAL, normal);
		System.out.println(users);
		
	}
}


