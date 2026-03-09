/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa un mensaje
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Mensaje.java
 * 
 */
public class Mensaje {
	private String texto;
	private int alcance;
	private Usuario usuarioActual;
	
	/**
	 * Crea un nuevo mensaje
	 * 
	 * @param texto, texto del mensaje
	 * @param alcance, alcance del mensaje
	 * @param usuarioActual, usuario actual del mensaje
	 */
	public Mensaje(String texto, int alcance, Usuario usuarioActual) {
		this.texto = texto;
		this.alcance = alcance;
		this.usuarioActual = usuarioActual;
	}

	/**
	 * Obtiene el texto del mensaje
	 * 
	 * @return String, el texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Establece el texto del mensaje
	 * 
	 * @param texto, texto a determinar
	 */
	public void setAutor(String texto) {
		this.texto = texto;
	}

	/**
	 * Obtiene el alcance del mensaje
	 * 
	 * @return int, valor de alcance disponible
	 */
	public int getAlcance() {
		return alcance;
	}

	/**
	 * Establece el alcance del mensaje
	 * 
	 * @param alcance el valor del alcance del mensaje
	 */
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	/**
	 * Obtiene el usuario actual
	 * 
	 * @return Usuario, el usuario actual
	 */
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	/**
	 * Establecer el usuario actual
	 * 
	 * @param usuarioActual el usuario actual a establecer
	 */
	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Devuelve la información de un mensaje como cadena de texto
	 * 
	 * @return String, cadena de texto con la información del mensaje
	 */
	public String toString() {
		return "Mensaje("+texto+":"+alcance+") en @"+usuarioActual.getNombre();
	}
	
	/**
	 * Determina si un mensaje se puede difundir por un enlace
	 * 
	 * @param e enlace
	 * @return true si el alcance es mayor o igual que el coste, false en caso contrario
	 */
	public boolean puedeDifundirPor(Enlace e) {
		if(this.alcance >= e.getCoste())
			return true;
		return false;
	}
	
	/**
	 * Determina si un mensaje se puede aceptar por un usuario
	 * 
	 * @param u usuario
	 * @return true
	 */
	public boolean aceptadoPor(Usuario u) {
		return true;
	}
	
	/**
	 * Difunde un mensaje si se dan las condiciones adecuadas
	 * 
	 * @param e enlace para la difusión
	 * @return true si se ha difundido el mensaje, false en caso contrario
	 */
	public boolean difunde(Enlace e) {
		if(e == null)
			return false;
		if(e.getUsuarioOrigen()==this.usuarioActual && this.puedeDifundirPor(e) && this.aceptadoPor(e.getUsuarioDestino()) && e.enlaceExitoso()) {
			this.setUsuarioActual(e.getUsuarioDestino());
			alcance = alcance - e.costeReal() + e.getUsuarioDestino().getAmplificacion();
			return true;
		} else
			return false;	
	}
	
	/**
	 * Difunde un mensaje dentro de una lista de usuarios si se dan las condiciones
	 * 
	 * @param usuarios usuarios sobre los que realizar la difusión
	 * @return true si se ha difundido el mensaje, false en caso contrario
	 */
	public boolean difunde(Usuario... usuarios) {
		boolean status = true;
		Usuario conMensaje;
		Enlace e;
		
		if(this.usuarioActual instanceof UsuarioInteresado) {
			e = ((UsuarioInteresado) this.usuarioActual).getBestEnlace();
			if(e != null) {
				if(!difunde(e))
			        return false;
				return true;
			}
		}
		
		conMensaje = this.usuarioActual;
		for(Usuario u:usuarios) {
			e = conMensaje.getEnlace(u);
			if(e == null) {
				status = false;
				continue;
			}
			if(difunde(e) == false) {
				status = false;
			} else {
				conMensaje=u;
			}
		}
		return status;
	}
}
