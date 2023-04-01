package redSocial;

import java.util.ArrayList;

public class Foto extends Publicacion{
	protected String nombreFoto;

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}
	
	public Foto() {
		super();
		nombreFoto = "";
	}

	public Foto(Foto foto) {
		super(foto);
		nombreFoto = foto.nombreFoto;
	}
	public Foto(Usuario usuario, String fecha, ArrayList<Usuario> favs, String nombreFoto) {
		super(usuario, fecha, favs);
		this.nombreFoto = nombreFoto;
	}
}
