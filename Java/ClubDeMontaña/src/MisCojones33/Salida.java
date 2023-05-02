package MisCojones33;

public class Salida {

	//Atributos Salida
	private int dia; 
	private int mes; 
	private int hora; 
	private String lugar;
	
	public Salida(int dia, int mes, int hora, String lugar) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.hora = hora;
		this.lugar = lugar;
	}

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

	@Override
	public String toString() {
		return "Salida [dia=" + dia + ", mes=" + mes + ", hora=" + hora + ", lugar=" + lugar + "]";
	} 
}
