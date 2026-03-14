package red_social;

public class MensajeControlado extends Mensaje {
	private int rigidez;

	public MensajeControlado(String texto, int alcance, Usuario usuarioActual, int rigidez) {
		super(texto, alcance, usuarioActual);
		this.rigidez = rigidez;
	}
	
	public int getRigidez() {
		return rigidez;
	}

	/**
	 * Determina si un mensaje se puede difundir por un enlace
	 * 
	 * @param e enlace
	 * @return true si el alcance es mayor o igual que el coste, false en caso contrario
	 */
	public boolean puedeDifundirPor(Enlace e) {
		if(e instanceof EnlaceSeñuelo) {
			return false;
		}
		return super.puedeDifundirPor(e);
	}
	
	/**
	 * Determina si un mensaje se puede aceptar por un usuario
	 * 
	 * @param u usuario
	 * @return true
	 */
	public boolean aceptadoPor(Usuario u) {
		if(u.getExposicion() == Exposicion.OCULTA) {
			return true;
		} else {
			if(this.rigidez >= u.getExposicion().getRigidezMin())
				return true;
			return false;
		}
	}
}
