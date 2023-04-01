package Baloncesto;

public class BasketballPlayer {
	protected String nombre;
	protected String posicion;
	protected String equipo;
	protected int altura;
	protected int peso;
	protected int agilidad;
	protected int velocidad;
	protected int manejo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAgilidad() {
		return agilidad;
	}
	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getManejo() {
		return manejo;
	}
	public void setManejo(int manejo) {
		this.manejo = manejo;
	}
	
	public BasketballPlayer() {
		super();
		this.nombre = "";
		this.posicion = "";
		this.equipo = "";
		this.altura = 0;
		this.peso = 0;
		this.agilidad = 0;
		this.velocidad = 0;
		this.manejo = 0;
	}
	public BasketballPlayer(String nombre, String posicion, String equipo) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = equipo;
		this.altura = 0;
		this.peso = 0;
		this.agilidad = 0;
		this.velocidad = 0;
		this.manejo = 0;
	}
	public BasketballPlayer(String nombre, String posicion, String equipo, int altura, int peso, int agilidad,
			int velocidad, int manejo) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = equipo;
		this.altura = altura;
		this.peso = peso;
		this.agilidad = agilidad;
		this.velocidad = velocidad;
		this.manejo = manejo;
	}
	int getValue() {
		if(posicion.equals("Pivot")) {
			if(altura >= 82 && peso >= 220 && peso <= 250 && manejo > 5) {
				return 10;
			}else if(altura >= 80 && peso >=210 && peso <=260 && manejo > 5) {
				return 8;
			}else if(altura >= 80 && manejo > 4) {
				return 6;
			}else if(altura >= 78 && agilidad > 7) {
				return 5;
			}else if (altura >= 78) {
				return 4;
			}else {
				return 0;
			}
		}else if(posicion.equals("Alero")) {
			if(altura >= 80 && (agilidad > 8 || velocidad > 7)) {
				return 0;
			}else if(altura >= 78 && agilidad>6 && velocidad>7) {
				return 8;
			}else if(altura >= 77 & agilidad > 5) {
				return 6;
			}else if(altura >= 76 && velocidad > 4) {
				return 5;
			}else if (altura >= 75 && (agilidad > 3 || velocidad > 3)) {
				return 3;
			}else if(altura >= 74) {
				return 1;
			}else {
				return 0;
			}
		}else if(posicion.equals("Escolta")) {
			if(altura >= 78 && manejo > 7 && (agilidad > 7 || velocidad> 7)) {
				return 10;
			}else if(altura >= 76 && manejo > 7 && (agilidad > 6 || velocidad > 6)) {
				return 8;
			}else if(altura >= 74 && manejo > 5 && agilidad > 5 && velocidad >6) {
				return 6;
			}else if(manejo > 6 && agilidad > 6 && velocidad > 5) {
				return 4;
			}else if(manejo > 4 && agilidad > 4) {
				return 2;
			}else {
				return 0;
			}
		}
		return 0;
	}
	@Override
	public String toString() {
		return "BasketballPlayer [nombre=" + nombre + ", posicion=" + posicion + ", equipo=" + equipo + ", altura="
				+ altura + ", peso=" + peso + ", agilidad=" + agilidad + ", velocidad=" + velocidad + ", manejo="
				+ manejo + "]";
	}
	
}
