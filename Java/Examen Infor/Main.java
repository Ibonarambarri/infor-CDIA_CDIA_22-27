package examenInfor;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		ArrayList<Huesped> huespedes = new ArrayList<Huesped>();
		ArrayList<Anfitrion> anfitriones = new ArrayList<Anfitrion>();
		ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
		
		for(int i = 0; i < 50; i++) {
			Anfitrion a = new Anfitrion("anfitrion-"+i,"", Math.random() * 500,null);
			Alojamiento al = new Alojamiento(a, "alojamiento-"+i, "", Math.random() * 100 + 50);
			ArrayList<Alojamiento> als = new ArrayList<Alojamiento>();
			als.add(al);
			a.setAls(als);
			alojamientos.add(al);
			anfitriones.add(a);
		}
		
		for(int i = 0; i <100; i++) {
			//Creamos el huesped con reservas vacio
			Huesped h = new Huesped("huesped-"+i, "", Math.random() * 5000, null);
			//Creamos el arraylist de reservas (3)
			ArrayList<Reserva> reservas = new ArrayList<Reserva>();
			//Creamos 3 reservas
			Reserva r1 = new Reserva(h, alojamientos.get((int)(Math.random() * alojamientos.size()-1)), 3, false, VALORACION.BIEN);
			Reserva r2 = new Reserva(h, alojamientos.get((int)(Math.random() * alojamientos.size()-1)), 3, false, VALORACION.BIEN);
			Reserva r3 = new Reserva(h, alojamientos.get((int)(Math.random() * alojamientos.size()-1)), 3, false, VALORACION.BIEN);
			//Añadimos las reservas al arraylist
			reservas.add(r1);
			reservas.add(r2);
			reservas.add(r3);
			//Metemos el arraylist en el huesped
			h.setRes(reservas);
			//Metemos el huesped en el arraylist de huespedes
			huespedes.add(h);
		}
		
		//creamos el mapa
		HashMap<Alojamiento, Integer> map = new HashMap<Alojamiento, Integer>();
		//recorremos los huespedes
		for(int i = 0; i< huespedes.size(); i++) {
			//creamos la lista con las reservas del huesped
			ArrayList<Reserva> reservas = huespedes.get(i).getRes();
			//recorremos la lista
			for(int j = 0; j < reservas.size(); j++) {
				//confirmamos la reserva
				reservas.get(j).confirmar();
				//comprobamos si el alojamiento se habia reservado antes
				if(map.containsKey(reservas.get(j).getAl())) {
					//sumamos 1 la cantidad de veces reservado
					int n = map.get(reservas.get(j).getAl()) + 1;
					//actualizamos el valor
					map.replace(reservas.get(j).getAl(), n);
				}else {
					//añadimos al mapa el alojamiento y ponemos a 1 el valor
					map.put(reservas.get(j).getAl(), 1);
				}
			}
		}
	}

}
