package deustotrain;

public interface Reservable {
	boolean reservar(Pasajero p);
	boolean anular(Pasajero p);
}
