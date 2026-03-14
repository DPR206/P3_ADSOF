/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

import java.io.*;

/**
 * Esta clase representa una batería de pruebas
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: EjemploUspMensajesBasicos.java
 * 
 */
public class EjemploDeUsoRedSocial {

	/**
	 * Punto de entrada para pruebas de la aplicación
	 * 
	 * @param args, Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		try {
			RedSocial s;
			s = new RedSocial("USUARIOS.txt", "ENLACES.txt", "MENSAJE.txt");
			s = new RedSocial("USUARIOS.txt", "ENLACES.txt", "MENSAJE2.txt");
		} catch (IOException e) {
			System.out.println("Error en archivos");
		}

	}

}