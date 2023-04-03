package examen1ErikEguskiza;

import java.util.ArrayList;

public class Publicacion extends Contenido {
	private String[] comentarios; 

	public Publicacion() {
	}

	public Publicacion(String titulo, String descripcion, String fecha, int nLikes, String[] comentarios) {
		super(titulo, descripcion, fecha, nLikes);
		this.comentarios = comentarios;
	}
	
	public String[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}
	
	public String comentsA( String[] comentarios) {
		ArrayList <String> coments = new ArrayList <String>();
		for(String coment: comentarios) {
			coments.add(coment);
		}
		return coments.toString();
	} 
 
	public String toStringConListaComentarios() {
		return "Publicacion [comentarios=" + comentsA(comentarios) + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", fecha=" + fecha + ", nLikes=" + nLikes + "]";
	}
	@Override	
	public String toString() {
			return "Publicacion [comentarios=" + comentarios+ ", titulo=" + titulo + ", descripcion=" + descripcion
					+ ", fecha=" + fecha + ", nLikes=" + nLikes + "]";
		
	}
	@Override
	protected int monetizar() {
		int valorComentarios = 0;
		for(int i = 0; i < comentarios.length ; i++) {
			String coment = comentarios[i];
			if(coment == null) {
				valorComentarios += 0;
			}else { 
				valorComentarios += 1; 
			}
			 
		}
		return (nLikes + (int)(valorComentarios*1.5));
	}

}
