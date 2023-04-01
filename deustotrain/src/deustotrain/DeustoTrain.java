package deustotrain;

import java.awt.Color;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class DeustoTrain {

	public static void main(String[] args) {
		ArrayList<Ruta> rutas = new ArrayList<Ruta>();
		
		ArrayList<Trayecto> trayectos1 = new ArrayList<Trayecto>(); 
		ArrayList<Trayecto> trayectos2 = new ArrayList<Trayecto>(); 
		
		Estacion bilbao = new Estacion("Bilbao", 0, 12, true, new ArrayList<Pasajero>());
		Estacion miranda = new Estacion("Miranda", 13, 50, false, new ArrayList<Pasajero>());
		Estacion zaragoza = new Estacion("Zaragoza", 70, 77, true, new ArrayList<Pasajero>());
		
		trayectos1.add(new Trayecto(bilbao, miranda, 100));
		trayectos1.add(new Trayecto(miranda, zaragoza, 300));
		trayectos1.add(new Trayecto(zaragoza, bilbao, 400));
		
		trayectos2.add(new Trayecto(bilbao, miranda, 100));
		trayectos2.add(new Trayecto(miranda, zaragoza, 300));
		trayectos2.add(new Trayecto(zaragoza, bilbao, 400));

		ArrayList<Pasajero> pasajeros2 = new ArrayList<Pasajero>();
		
		pasajeros2.add(new Pasajero("Pablo", "12345678Z", "555123321"));
		pasajeros2.add(new Pasajero("Pedro", "12345378X", "555523321"));
		pasajeros2.add(new Pasajero("Laura", "12345178Y", "555323321"));
		
		rutas.add(new RutaMercancias(new Tren(5000, "Swingline"), trayectos1, 56734));
		rutas.add(new RutaMercancias(new Tren(8000, "Swingline 2"), trayectos1, 56734));
		
		rutas.add(new RutaPasajeros(new Tren(8000, "Swingline 2"), trayectos2, 1, 3, 1, pasajeros2));
		rutas.add(new RutaPasajeros(new Tren(8000, "Swingline 2"), trayectos2, 2, 5, 2, new ArrayList<Pasajero>()));
		
		System.out.println(Ruta.getRutaMasBeneficiosa(rutas));
		
		VentanaGrafica v = new VentanaGrafica(800, 600, "DeustoTrain");
		
		for (Ruta ruta : rutas) {
			Color color;
			if (ruta instanceof RutaMercancias) {
				color = Color.red;
			} else {
				color = Color.green;
			}
			for (Trayecto trayecto : ruta.getTrayectos()) {
				v.dibujaFlecha(600*(trayecto.getOrigen().getLatitud()+90)/180, 800*(trayecto.getOrigen().getLongitud()+180)/360, 600*(trayecto.getDestino().getLatitud()+90)/180, 800*(trayecto.getDestino().getLongitud()+180)/360, 2, color);
				v.dibujaCirculo(600*(trayecto.getOrigen().getLatitud()+90)/180, 800*(trayecto.getOrigen().getLongitud()+180)/360, 10, 3, Color.orange, Color.orange);
			}
		}

	}

}
