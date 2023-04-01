package examenInfor;

import java.util.ArrayList;

public class Huesped extends Usuario{
	protected ArrayList<Reserva> res;

	public ArrayList<Reserva> getRes() {
		return res;
	}

	public void setRes(ArrayList<Reserva> res) {
		if(this.res == null) {
			this.res = new ArrayList<Reserva>();
		}
		if(res != null) {
			for(int i = 0; i < res.size(); i++) {
				if(res.get(i) != null) {
					this.res.add(res.get(i));
				}
			}
		}
	}

	public Huesped() {
		super();
		res = new ArrayList<Reserva>();
	}

	public Huesped(String nombre, String apellidos, double saldo, ArrayList<Reserva> res) {
		super(nombre, apellidos, saldo);
		this.res = new ArrayList<Reserva>();
		
		if(res != null) {
			for(int i = 0; i<res.size(); i++) {
				if(res.get(i) != null) {
					this.res.add(res.get(i));
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Huesped [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ "]";
	}
	
	
}
