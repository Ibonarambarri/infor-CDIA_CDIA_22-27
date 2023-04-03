package examen1ErikEguskiza;

public class Historia extends Contenido {
	private int nViews;

	public Historia() {
		this.nViews = 0; 
	}
	
	public Historia(String titulo, String descripcion, String fecha, int nLikes, int nViews) {
		super(titulo, descripcion, fecha, nLikes);
		this.nViews = nViews;
	}
	
	public int getnViews() {
		return nViews;
	}

	public void setnViews(int nViews) {
		this.nViews = nViews;
	}
	
	@Override
	public String toString() {
		return "Historia [nViews=" + nViews + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", nLikes=" + nLikes + "]";
	}
 
	@Override
	protected int monetizar() {
		return (int) (nViews*0.75 + nLikes);
	}
}
