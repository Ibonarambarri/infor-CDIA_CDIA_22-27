package examenInfor;

import java.util.ArrayList;

public class Anfitrion extends Usuario{
	ArrayList<Alojamiento> als;

	public ArrayList<Alojamiento> getAls() {
		return als;
	}
	public void setAls(ArrayList<Alojamiento> als) {
		if(this.als == null) {
			this.als = new ArrayList<Alojamiento>();
		}
		if(als != null) {
			for(int i = 0; i < als.size(); i++) {
				if(als.get(i) != null) {
					this.als.add(als.get(i));
				}
			}
		}
	}
	public Anfitrion() {
		super();
		this.als = new ArrayList<Alojamiento>();
	}
	public Anfitrion(String nombre, String apellidos, double saldo, ArrayList<Alojamiento> als) {
		super(nombre, apellidos, saldo);
		this.als = new ArrayList<Alojamiento>();
		
		if(als != null) {
			for(int i = 0; i < als.size(); i++) {
				if(als.get(i) != null) {
					this.als.add(als.get(i));
				}
			}
		}
	}
	@Override
	public String toString() {
		return "Anfitrion [ codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", saldo=" + saldo + "]";
	}
	
	
	
}
