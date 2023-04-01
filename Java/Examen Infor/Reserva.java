package examenInfor;

enum VALORACION {MAL, REGULAR, BIEN};

public class Reserva implements Confirmable{
	protected Huesped huesped;
	protected Alojamiento al;
	protected int nDias;
	protected boolean confirmada;
	protected VALORACION val;
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public Alojamiento getAl() {
		return al;
	}
	public void setAl(Alojamiento al) {
		this.al = al;
	}
	public int getnDias() {
		return nDias;
	}
	public void setnDias(int nDias) {
		this.nDias = nDias;
	}
	public boolean isConfirmada() {
		return confirmada;
	}
	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}
	public VALORACION getVal() {
		return val;
	}
	public void setVal(VALORACION val) {
		this.val = val;
	}
	public Reserva() {
		super();
		this.huesped = new Huesped();
		this.al = new Alojamiento();
		this.nDias = 0;
		this.confirmada = false;
		this.val = VALORACION.REGULAR;
	}
	public Reserva(Huesped huesped, Alojamiento al, int nDias, boolean confirmada, VALORACION val) {
		super();
		this.huesped = huesped;
		this.al = al;
		this.nDias = nDias;
		this.confirmada = confirmada;
		this.val = val;
	}
	@Override
	public String toString() {
		return "Reserva [huesped=" + huesped + ", al=" + al + ", nDias=" + nDias + ", confirmada=" + confirmada
				+ ", val=" + val + "]";
	}
	
	public void confirmar() {
		if(huesped.getSaldo() > nDias*al.getPrecio()) {
			confirmada = true;
			huesped.setSaldo(huesped.getSaldo() - nDias*al.getPrecio());
			al.a.saldo += nDias*al.getPrecio();
		}
	}
}
