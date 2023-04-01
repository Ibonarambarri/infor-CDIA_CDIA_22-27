package redSocial;

import java.util.ArrayList;

public abstract class Publicacion implements Borrable{
	protected Usuario usuario;
	protected String fecha;
	protected ArrayList<Usuario> favs;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Usuario> getFavs() {
		return favs;
	}
	public void setFavs(ArrayList<Usuario> favs) {
		if(this.favs == null) {
			this.favs = new ArrayList<Usuario>();
		}
		
		if(favs != null) {
			for(int i = 0; i<favs.size(); i++) {
				if(favs.get(i) != null) {
					this.favs.add(new Usuario(favs.get(i)));
				}
			}
		}
	}
	public Publicacion() {
		super();
		this.usuario = null;
		this.fecha = "";
		this.favs = new ArrayList<Usuario>();
	}
	public Publicacion(Usuario usuario, String fecha, ArrayList<Usuario> favs) {
		super();
		this.usuario = new Usuario(usuario);
		this.fecha = fecha;
		this.favs = new ArrayList<Usuario>();
		
		for(int i = 0; i<favs.size(); i++) {
			if(favs.get(i) != null) {
				this.favs.add(new Usuario(favs.get(i)));
			}
		}
	}
	public Publicacion(Publicacion pub) {
		super();
		this.usuario = new Usuario(pub.usuario);
		this.fecha = pub.fecha;
		this.favs = new ArrayList<Usuario>();
		
		for(int i = 0; i<pub.favs.size(); i++) {
			if(pub.favs.get(i) != null) {
				this.favs.add(new Usuario(pub.favs.get(i)));
			}
		}
	}
	@Override
	public String toString() {
		return "Publicacion [usuario=" + usuario + ", fecha=" + fecha + ", favs=" + favs + "]";
	}
	
	public int nFavs() {
		return favs.size();
	}
	
	public String borrar() {
		return "La publicación ha sido borrada";
	}
}
