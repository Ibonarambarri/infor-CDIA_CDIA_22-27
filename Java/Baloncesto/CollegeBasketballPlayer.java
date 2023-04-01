package Baloncesto;

public class CollegeBasketballPlayer extends BasketballPlayer{
	protected int elegibilidad;
	protected String rol;
	public int getElegibilidad() {
		return elegibilidad;
	}
	public void setElegibilidad(int elegibilidad) {
		this.elegibilidad = elegibilidad;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public CollegeBasketballPlayer() {
		super();
		this.elegibilidad = 4;
		this.rol = "banquillo";
	}
	public CollegeBasketballPlayer(String nombre, String posicion, String equipo, int altura, int peso, int agilidad,
			int velocidad, int manejo, int elegibilidad, String rol) {
		super(nombre, posicion, equipo, altura, peso, agilidad, velocidad, manejo);
		this.elegibilidad = elegibilidad;
		this.rol = rol;
	}
	public CollegeBasketballPlayer(String nombre, String posicion, String equipo) {
		super(nombre, posicion, equipo);
		this.elegibilidad = 4;
		this.rol = "banquillo";
	}
	
	public String toString() {
		return super.toString() + "\t" + rol;
	}
	
	public boolean draftable() {
		if(rol.equals("Quinteto") && super.getValue() > 4) {
			return true;
		}else if(rol.equals("banquillo") && super.getValue() >= 8) {
			return true;
		}
		return false;
	}
}
