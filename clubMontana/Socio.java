package clubMontana;

import java.io.Serializable;
import java.util.Objects;

public class Socio implements Serializable{
	private String nombre;
	private String DNI;
	private String email;
	private String tlfn;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTlfn() {
		return tlfn;
	}
	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	public Socio() {
		super();
		this.nombre = "";
		DNI = "";
		this.email = "";
		this.tlfn = "";
	}
	public Socio(String nombre, String dNI, String email, String tlfn) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.email = email;
		this.tlfn = tlfn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DNI, email, nombre, tlfn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tlfn, other.tlfn);
	}
	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", DNI=" + DNI + ", email=" + email + ", tlfn=" + tlfn + "]";
	}
	
}
