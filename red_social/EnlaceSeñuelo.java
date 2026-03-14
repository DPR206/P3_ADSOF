/**
 * Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa un enlace señuelo
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: EnlaceSeñuelo.java
 * 
 */
public class EnlaceSeñuelo extends Enlace{
	private int costeExtra;
	private double probRetorno;

	/**
	 * Crea un nuevo enlace señuelo
	 * 
	 * @param usuarioOrigen, usuario origen del enlace
	 * @param usuarioDestino, usuario destino del enlace
	 * @param coste, coste del enlace
	 * @param costeExtra, coste extra del enlace
	 * @param probRetorno, probabilidad de retorno del enlace
	 */
	public EnlaceSeñuelo(Usuario usuarioOrigen, Usuario usuarioDestino, int coste, int costeExtra, double probRetorno) {
		super(usuarioOrigen, usuarioDestino, coste);
		this.costeExtra = costeExtra;
		this.probRetorno = probRetorno;
	}
	
	/**
	 * Crea un nuevo enlace señuelo con un coste por defecto
	 * 
	 * @param usuarioOrigen, usuario origen del enlace
	 * @param usuarioDestino, usuario destino del enlace
	 * @param costeExtra, coste extra del enlace
	 * @param probRetorno, probabilidad de retorno del enlace
	 */
	public EnlaceSeñuelo(Usuario usuarioOrigen, Usuario usuarioDestino, int costeExtra, double probRetorno) {
		super(usuarioOrigen, usuarioDestino);
		this.costeExtra = costeExtra;
		this.probRetorno = probRetorno;
	}
	
	/**
	 * Obtiene el coste especial del enlace señuelo
	 * 
	 * @return int, el coste especial del enlace
	 */
	public int costeEspecial(){
		return this.getCoste() * this.costeExtra;
	}
	
	/**
	 * Obtiene la probabilidad de retorno del enlace
	 * 
	 * @return double, la probabilidad de retorno
	 */
	public double getProbabilidad() {
		return probRetorno;
	}
}
