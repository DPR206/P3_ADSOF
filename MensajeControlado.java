/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa un mensaje controlado
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: MensajeControlado.java
 * 
 */
public class MensajeControlado extends Mensaje {
	private int rigidez;

	/**
	 * Crea un nuevo mensaje controlado
	 * 
	 * @param texto, el texto del mensaje
	 * @param alcance, el alcance del mensaje
	 * @param usuarioActual, el usuario actual del mensaje
	 * @param rigidez, la rigidez del mensaje
	 */
	public MensajeControlado(String texto, int alcance, Usuario usuarioActual, int rigidez) {
		super(texto, alcance, usuarioActual);
		this.rigidez = rigidez;
	}
	
	/**
	 * Obtiene la rigidez del mensaje
	 * 
	 * @return int, el valor de la rigidez
	 */
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