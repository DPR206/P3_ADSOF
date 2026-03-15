/**
 *  Este paquete contiene las pruebas hechas
 */
package pruebas;

import red_social.*;

/**
 * Esta clase representa una batería de pruebas
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Prueba1EnlaceSeñuelo.java
 * 
 */
public class Prueba1EnlaceSeñuelo {

	/**
	 * Punto de entrada para pruebas de la aplicación
	 * 
	 * @param args, Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		Usuario duna = new Usuario("duna", 10, Exposicion.ALTA);
		Usuario claudia = new Usuario("claudia", 9, Exposicion.VIRAL);

		Mensaje m1 = new Mensaje("Hola Clotilda!", 20, duna);
		Mensaje m2 = new Mensaje("Hola Tuna!", 20, claudia);
		
		/*Este mensaje nunca se enviará porque la probabilidad de retorno es 100%*/
		duna.addEnlace(new EnlaceSeñuelo(duna, claudia, 5, 2, 100));
		m1.difunde(claudia);
		System.out.println(m1);
		
		/*Este mensaje siempre se enviará porque su probabilidad de retorno es 0%*/
		claudia.addEnlace(new EnlaceSeñuelo(claudia, duna, 5, 2, 0));
		/*Coste real = coste + (coste * costeExtra) = 5 + 5*2 = 15 */
		/*Nuevo alcance = alcance - costeReal + amplificacion = 20 - 15 + 10 = 15 */
		m2.difunde(duna);
		System.out.println(m2);

	}

}

