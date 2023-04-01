package deustotravel;

public class Trayecto {
		protected double latitudOrigen;
		protected double longitudOrigen;
		protected double latitudDestino;
		protected double longitudDestino;
		protected double distancia;
		protected Transporte transporte;
		
		public Trayecto(double latitudOrigen, double longitudOrigen, double latitudDestino, double longitudDestino,
				double distancia, Transporte transporte) {
			super();
			this.latitudOrigen = latitudOrigen;
			this.longitudOrigen = longitudOrigen;
			this.latitudDestino = latitudDestino;
			this.longitudDestino = longitudDestino;
			this.distancia = distancia;
			this.transporte = transporte;
		}
		
		public Trayecto() {
			super();
		}

		public double getLatitudOrigen() {
			return latitudOrigen;
		}

		public void setLatitudOrigen(double latitudOrigen) {
			this.latitudOrigen = latitudOrigen;
		}

		public double getLongitudOrigen() {
			return longitudOrigen;
		}

		public void setLongitudOrigen(double longitudOrigen) {
			this.longitudOrigen = longitudOrigen;
		}

		public double getLatitudDestino() {
			return latitudDestino;
		}

		public void setLatitudDestino(double latitudDestino) {
			this.latitudDestino = latitudDestino;
		}

		public double getLongitudDestino() {
			return longitudDestino;
		}

		public void setLongitudDestino(double longitudDestino) {
			this.longitudDestino = longitudDestino;
		}

		public double getDistancia() {
			return distancia;
		}

		public void setDistancia(double distancia) {
			this.distancia = distancia;
		}

		public Transporte getTransporte() {
			return transporte;
		}

		public void setTransporte(Transporte transporte) {
			this.transporte = transporte;
		}

		@Override
		public String toString() {
			return "Trayecto [latitudOrigen=" + latitudOrigen + ", longitudOrigen=" + longitudOrigen
					+ ", latitudDestino=" + latitudDestino + ", longitudDestino=" + longitudDestino + ", distancia="
					+ distancia + ", transporte=" + transporte + "]";
		}
		
		
}
