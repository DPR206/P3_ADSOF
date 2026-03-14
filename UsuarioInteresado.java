/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa un usuario interesado
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: UsuarioInteresado.java
 * 
 */
public class UsuarioInteresado extends Usuario {

	/**
	 * Crea un nuevo usuario interesado en base a su nombre
	 * 
	 * @param nombre, nombre del usuario interesado
	 */
	public UsuarioInteresado(String nombre) {
		super(nombre);
	}

	/**
	 * Crea un nuevo usuario interesado en base a nombre y exposición
	 * 
	 * @param nombre, nombre del usuario interesado
	 * @param e, exposición del usuario
	 */
	public UsuarioInteresado(String nombre, Exposicion e) {
		super(nombre, e);
	}

	/**
	 * Crea un nuevo usuario interesado en base a su nombre y amplificación
	 * @param nombre, nombre del usuario
	 * @param amplificacion, valor de su amplificación
	 */
	public UsuarioInteresado(String nombre, int amplificacion) {
		super(nombre, amplificacion);
	}

	/**
	 * Crea un nuevo usuario interesadpo
	 * 
	 * @param nombre, nombre del usuario
	 * @param amplificacion, valor de la amplificación
	 * @param e, exposixión del usuario
	 */
	public UsuarioInteresado(String nombre, int amplificacion, Exposicion e) {
		super(nombre, amplificacion, e);
	}

	/**
	 * Obtiene el mejor enlace en base a la exposición de su usuario destino
	 * 
	 * @return Enlace, el mejor enlace del usuario
	 */
	public Enlace getBestEnlace() {
		for(Enlace e : this.getEnlaces()) {
	        if(e.getUsuarioDestino().getExposicion() == Exposicion.ALTA ||
	           e.getUsuarioDestino().getExposicion() == Exposicion.VIRAL) {
	        	return e;
	        }
		}
		return null;
	}
}