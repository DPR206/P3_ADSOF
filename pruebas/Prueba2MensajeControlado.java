/**
 *  Este paquete contiene las pruebas hechas
 */
package pruebas;

import red_social.*;

/**
 * Esta clase representa una batería de pruebas
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Prueba2MensajeControlado.java
 * 
 */
public class Prueba2MensajeControlado {

	/**
	 * Punto de entrada para pruebas de la aplicación
	 * 
	 * @param args, Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		Usuario duna = new Usuario("duna", 10, Exposicion.ALTA);
		Usuario claudia = new Usuario("claudia", 10, Exposicion.ALTA);
		Mensaje m1 = new MensajeControlado("Hola Clotilda!", 20, claudia, 15);
		Mensaje m2 = new MensajeControlado("Hola Tuna!", 20, duna, 25);
		
		claudia.addEnlace(new Enlace(claudia, duna, 6));
		duna.addEnlace(new Enlace(duna, claudia, 6));
		
		/* El segundo mensaje se enviará, pero el primero no, por no tener suficiente rigidez para la exposición ALTA (20 o más)*/
		if(!m1.difunde(duna))
			System.out.println("El mensaje controlado no se envía por tener rigidez insuficiente (15 < 20)");
		if(m2.difunde(claudia))
			System.out.println("El mensaje controlado se envía correctamente por tener suficiente rigidez (25 >= 20)");
		System.out.println(m1 + "\n" + m2);
	}
}
