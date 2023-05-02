package clubMontana;

import java.io.Serializable;
import java.util.Objects;

public class Salida implements Serializable{
	private int dia;
	private int mes;
	private int hora;
	private String lugar;
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Salida() {
		super();
		this.dia = 0;
		this.mes = 0;
		this.hora = 0;
		this.lugar = "";
	}
	public Salida(int dia, int mes, int hora, String lugar) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.hora = hora;
		this.lugar = lugar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dia, hora, lugar, mes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salida other = (Salida) obj;
		return dia == other.dia && hora == other.hora && Objects.equals(lugar, other.lugar) && mes == other.mes;
	}
	@Override
	public String toString() {
		return "Salida [dia=" + dia + ", mes=" + mes + ", hora=" + hora + ", lugar=" + lugar + "]";
	}
	
}
