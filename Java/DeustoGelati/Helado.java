package POO;

import java.util.Scanner;

public class Helado {
	//Atributos
	private int tipo;
	private int tamayo;
	private String cobertura;
	private boolean adornos;
	private Sabor[] sabores = new Sabor[5];
	
	//Getters y setters
	public int getTipo() {
		return this.tipo;
	}
	public void setTipo(int tipo) {
		if(tipo == 1 || tipo == 0) {
			this.tipo = tipo;
		}else {
			System.out.println("CUIDADO! El tipo de helado no es válido. Elige 0:cucurucho o 1:tarrina");
			Scanner entrada = new Scanner(System.in);
			int tipo1 = entrada.nextInt();
			this.setTipo(tipo1);
		}
	}
	public int getTamayo() {
		return this.tamayo;
	}
	public void setTamayo(int tamayo) {
		if (tamayo > -1 && tamayo < 3) {
			this.tamayo = tamayo;
		}else {
			System.out.println("CUIDADO! El tamaño de helado no es válido. No se va a modificar.");
		}
	}
	public String getCobertura() {
		return this.cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	public boolean getAdornos() {
		return this.adornos;
	}
	public void setAdornos(boolean adornos) {
		this.adornos = adornos;
	}
	public Sabor[] getSabores() {
		return this.sabores;
	}
	public void setSabores(Sabor[] sabores) {
		for(int i = 0; i<sabores.length; i++) {
			if (sabores[i] != null) {
				this.sabores[i] = new Sabor(sabores[i]);
			}
		}
	}
	
	//Constructores
	public Helado() {
		this.tipo = 0;
		this.tamayo = 0;
		this.cobertura = "nata";
		this.adornos = true;
		for(int i = 0; i<this.sabores.length; i++) {
			this.sabores[i] = new Sabor();
		}
		
	}
	public Helado(int tipo, int tamayo, String cobertura, boolean adornos, Sabor[] sabores) {
		if(tipo == 0 || tipo == 1) {
			this.tipo = tipo;
		}else {
			System.out.println("CUIDADO! El tipo de helado no es válido. Elige entre 0: cucurucho o 1: Helado");
			Scanner entrada = new Scanner(System.in);
			int tipo1 = entrada.nextInt();
			this.setTipo(tipo1);
		}
		
		if(tamayo > -1 && tamayo < 3) {
			this.tamayo = tamayo;
		} else {
			System.out.println("CUIDADO! El tamaño de helado no es válido. Se cambiará a pequeño.");
			this.tamayo = 0;
		}
		
		
		this.cobertura = cobertura;
		this.adornos = adornos;
		for(int i = 0; i<sabores.length;i++) {
			if(sabores[i] != null) {
				this.sabores[i] = new Sabor(sabores[i]);
			}
		}
	}
	public Helado(Helado helado) {
		this.tipo = helado.tipo;
		this.tamayo = helado.tamayo;
		this.cobertura = helado.cobertura;
		this.adornos = helado.adornos;
		for(int i = 0; i<helado.sabores.length;i++) {
			if(helado.sabores[i] != null) {
				this.sabores[i] = new Sabor(helado.sabores[i]);
			}
		}
	}
	
	//toString()
	public String toString() {
		String str =  "Helado en ";
		
		if(this.tipo == 0) {
			str += "cucurucho ";
		} else if(this.tipo == 1) {
			str += "tarrina ";
		}
		
		if(this.tamayo == 0) {
			str += "pequeño, ";
		}else if(this.tamayo == 1) {
			str += "mediano, ";
		}else if (this.tamayo == 2) {
			str += "grande. ";
		}
		
		str += this.cobertura + ", ";
		
		if (this.adornos) {
			str += " con adornos. ";
		}else {
			str += " sin adornos. ";
		}
		str += "Sabores: ";
		for(int i = 0 ; i<this.sabores.length;i++) {
			if(this.sabores[i] != null) {
				str += this.sabores[i].getNombre() + ", ";
			}
		}
		return str;
	}
	
	//Otros métodos
	public double getPrecio() {
		double precio = 0;
		if(this.tamayo == 0) { //pequeño
			for(int i = 0; i< this.sabores.length; i++) {
				if(this.sabores[i] != null) {
					precio += 0.5;
				}
			}
		}else if(this.tamayo == 1) { //mediano
			for(int i = 0; i<this.sabores.length;i++) {
				if(this.sabores[i] != null) {
					precio += 0.75;
				}
			}
		}else { //grande
			for(int i = 0; i<this.sabores.length;i++) {
				if(this.sabores[i] != null) {
					precio += 1;
				}
			}
		}
		
		if(!this.cobertura.equals("sin cobertura")) {
			precio += 0.5;
		}
		
		if(this.adornos) {
			precio += 1;
		}
		
		return precio;
	}
}
