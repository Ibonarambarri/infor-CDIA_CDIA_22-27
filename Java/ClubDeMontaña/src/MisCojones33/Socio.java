package MisCojones33;

public class Socio {
	//Atributos Socio
		private String nombre; 
		private String dni; 
		private String email; 
		private String telefono;
		
		
		public Socio() {
			this.nombre = "";
			this.dni = "";
			this.email = "";
			this.telefono = "";
		}
		
		public Socio(String nombre, String dni, String email, String telefono) {
			super();
			this.nombre = nombre;
			this.dni = dni;
			this.email = email;
			this.telefono = telefono;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		@Override
		public String toString() {
			return "Socio [nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", telefono=" + telefono + "]";
		}
		
		

}
