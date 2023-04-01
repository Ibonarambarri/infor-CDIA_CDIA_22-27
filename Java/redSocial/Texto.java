package redSocial;

import java.util.ArrayList;

public class Texto extends Publicacion implements Editable{
	protected String texto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Texto() {
		super();
		texto = "";
	}
	public Texto(Texto txt) {
		super(txt);
		this.texto = txt.texto;
	}
	public Texto(Usuario usuario, String fecha, ArrayList<Usuario> favs, String texto) {
		super(usuario, fecha, favs);
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "Texto [texto=" + texto + ", usuario=" + usuario + ", fecha=" + fecha + ", favs=" + favs + "]";
	}
	@Override
	public String borrar() {
		return "Texto eliminado";
	}

	@Override
	public String editar(String nuevoTexto) {
		// TODO Auto-generated method stub
		return null;
	}
}
