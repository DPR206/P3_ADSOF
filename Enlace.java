/**
 * Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa un enlace
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Enlace.java
 * 
 */
public class Enlace {
	private Usuario usuarioOrigen;
	private Usuario usuarioDestino;
	private double coste;
	
	/**
	 * Crea un nuevo enlace
	 * 
	 * @param usuarioOrigen, usuario de origen
	 * @param usuarioDestino, usuario de destino
	 * @param coste, coste del enlace
	 */
	public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino, double coste) {
		this.usuarioOrigen = usuarioOrigen;
		this.usuarioDestino = usuarioDestino;
		if(coste <= 0)
			this.coste=1;
		this.coste = coste;
	}
	
	/**
	 * Crea un nuevo enlace sin un coste, se asigna el valor 1 por defecto
	 * 
	 * @param usuarioOrigen, usuario de origen
	 * @param usuarioDestino, usuario de destino
	 */
	public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino) {
		this.usuarioOrigen = usuarioOrigen;
		this.usuarioDestino = usuarioDestino;
		this.coste=1;
	}
	
	/**
	 * Obtiene el usuario de origen
	 * 
	 * @return usuarioOrigen, usuario de origen
	 */
	public Usuario getUsuarioOrigen() {
		return this.usuarioOrigen;
	}
	
	/**
	 * Obtiene el usario de destino
	 * 
	 * @return usuarioDestino, usuario de destino
	 */
	public Usuario getUsuarioDestino() {
		return this.usuarioDestino;
	}
	
	/**
	 * Obtiene el coste del enlace
	 * 
	 * @return coste, coste del enlace
	 */
	public double getCoste() {
		return this.coste;
	}
	
	/**
	 * Modifica el usuario de destino y el coste de un enlace
	 * 
	 * @param user, nuevo usuario de destino
	 * @param valor, nuevo coste del enlace
	 */
	public void cambiarDestino(Usuario user, int valor) {
		this.usuarioDestino = user;
		this.coste = valor;
	}
	
	/**
	 * Devuelve la información de un enlace como cadena de texto
	 * 
	 * @return String, cadena de texto con la información del enlace
	 */
	public String toString() {
		return "@"+this.usuarioOrigen.getName()+"--"+this.coste+"-->@"+this.usuarioDestino.getName();
	}
}
