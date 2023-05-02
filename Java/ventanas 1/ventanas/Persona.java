package ventanas;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{
	private String nombre;
	private String apellidos;
	private String sexo;
	private boolean isDni;
	private String dni;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isDni() {
		return isDni;
	}
	public void setDni(boolean isDni) {
		this.isDni = isDni;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Persona(String nombre, String apellidos, String sexo, boolean isDni, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.isDni = isDni;
		this.dni = dni;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	@Override
	public String toString() {
		String st = "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo + ", isDni=" + isDni
				+ ", ";
		if(isDni) {
			st += "dni=" + dni + "]";
		}else {
			st += "pasaporte=" + dni + "]";
		}
		return st;
	}
	
	
}
