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
	private int coste;
	private static int total_coste = 0;
	
	/**
	 * Crea un nuevo enlace
	 * 
	 * @param usuarioOrigen, usuario de origen
	 * @param usuarioDestino, usuario de destino
	 * @param coste, coste del enlace
	 */
	public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino, int coste) {
		this.usuarioOrigen = usuarioOrigen;
		this.usuarioDestino = usuarioDestino;
		if(coste <= 0)
			this.coste=1;
		else 
			this.coste = coste;
		Enlace.total_coste+=this.coste;
	}
	
	/**
	 * Crea un nuevo enlace sin un coste, se asigna el valor 1 por defecto
	 * 
	 * @param usuarioOrigen, usuario de origen
	 * @param usuarioDestino, usuario de destino
	 */
	public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino) {
		this(usuarioOrigen, usuarioDestino, 1);
	}
	
	/**
	 * Obtiene el usuario de origen
	 * 
	 * @return Usuario, usuario de origen
	 */
	public Usuario getUsuarioOrigen() {
		return this.usuarioOrigen;
	}
	
	/**
	 * Obtiene el usario de destino
	 * 
	 * @return Usuario, usuario de destino
	 */
	public Usuario getUsuarioDestino() {
		return this.usuarioDestino;
	}
	
	/**
	 * Obtiene el coste del enlace
	 * 
	 * @return int, coste del enlace
	 */
	public int getCoste() {
		return this.coste;
	}
	
	/**
	 * Obtiene la suma de costes de todos los enlaces creados
	 * 
	 * @return int, suma total de costes
	 */
	public int getTotalCostes() {
		return Enlace.total_coste;
	}
	
	/**
	 * Obtiene el coste de los enlaces especiales
	 * 
	 * @return int, coste del enlace especial
	 */
	public int costeEspecial() {
		return 0;
	}
	
	/**
	 * Obtiene el coste real de un enlace
	 * 
	 * @return int, coste real del enlace
	 */
	public int costeReal() {
		return this.coste + this.costeEspecial();
	}
	
	/**
	 * Obtiene la probabilidad de que el mensaje se retorne al usuario que lo lanza
	 * 
	 * @return probabilidad de que retorne
	 */
	public double getProbabilidad() {
		return 0;
	}
	
	/**
	 * Devuelve si el enlace ha sido exitoso o no dependiendo de la probabilidad de retorno
	 * 
	 * @return true si ha sido exitoso, falso en caso contrario
	 */
	public boolean enlaceExitoso() {
		return 100 * Math.random() >= this.getProbabilidad();
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
		return "(@"+this.usuarioOrigen.getNombre()+"--"+this.coste+"-->@"+this.usuarioDestino.getNombre() + ")";
	}
}
