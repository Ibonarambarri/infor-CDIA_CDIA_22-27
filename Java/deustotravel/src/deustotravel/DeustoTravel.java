package deustotravel;

import java.util.ArrayList;

public class DeustoTravel {

	public static void main(String[] args) {
		ArrayList<Guia> guias = new ArrayList<Guia>(); 
		ArrayList<Excursion> excursiones = new ArrayList<Excursion>();
		ArrayList<Trayecto> trayectos1 = new ArrayList<Trayecto>();
		ArrayList<Trayecto> trayectos2 = new ArrayList<Trayecto>();
		ArrayList<Trayecto> trayectos3 = new ArrayList<Trayecto>();
		
		guias.add(new Guia("Pablo", 12.5, 10, false));
		guias.add(new Guia("Ane", 16.5, 15, false));
		guias.add(new Guia("María", 17.5, 20, true));
		
		trayectos1.add(new Trayecto(-34, -12, 27, 45, 300, new Barco(5, 3.2, true)));
		trayectos1.add(new Trayecto(27, 45, 33, 75, 400, new Barco(10, 6.2, true)));
		trayectos1.add(new Trayecto(33, 75, 0, 65, 300, new Avioneta(8, 1200, 12.3)));
		trayectos1.add(new Trayecto(0, 65, -34, -12, 700, new Barco(15, 12.2, true)));
		
		trayectos2.add(new Trayecto(-14, -6, -20, -100, 300, new Barco(5, 3.2, true)));
		trayectos2.add(new Trayecto(-20, -100, 12, 66, 800, new Barco(10, 6.2, true)));
		trayectos2.add(new Trayecto(12, 66, 10, 165, 300, new Avioneta(8, 1200, 12.3)));
		trayectos2.add(new Trayecto(10, 165, -14, -6, 700, new Barco(15, 12.2, true)));
		
		trayectos3.add(new Trayecto(-14, -6, -20, -100, 300, new Barco(5, 3.2, true)));
		trayectos3.add(new Trayecto(-20, -100, 12, 66, 400, new Barco(10, 6.2, true)));
		trayectos3.add(new Trayecto(12, 66, 10, 165, 300, new Avioneta(8, 1200, 12.3)));
		trayectos3.add(new Trayecto(10, 165, -14, -6, 700, new Barco(15, 12.2, true)));
		
		excursiones.add(new Excursion("Urdaibai", trayectos1, false));
		excursiones.add(new Excursion("Viaje en globo", trayectos2, false));
		excursiones.add(new Excursion("Delfines", trayectos3, false));
		
		System.out.println(Excursion.getExcursionMasCara(excursiones));
	}

}
