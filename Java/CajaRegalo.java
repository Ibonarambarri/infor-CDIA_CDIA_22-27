package ariketasObjetos;

public class CajaRegalo extends Caja {
	boolean lazo;

	public CajaRegalo() {
		super();
	}

	public CajaRegalo(String modelo, String color, double altura, double anchura, boolean llena, boolean lazo) {
		super(modelo, color, altura, anchura, llena);
		this.lazo = lazo; 
	}

	public boolean isLazo() {
		return lazo;
	}

	public void setLazo(boolean lazo) {
		this.lazo = lazo;
	}

	@Override
	public String toString() {
		return "CajaRegalo [lazo=" + lazo + ", modelo=" + modelo + ", color=" + color + ", altura=" + altura
				+ ", anchura=" + anchura + ", llena=" + llena + ", nserie=" + nserie + "]";
	} 
	
	
	
	
	
 
}
