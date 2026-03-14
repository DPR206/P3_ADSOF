/**
 *  Este paquete contiene las pruebas hechas
 */
package pruebas;

import java.io.IOException;
import red_social.*;

/**
 * Esta clase representa una batería de pruebas
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: PruebaUsoRedSocial2.java
 * 
 */
public class Prueba2RedSocial {

	/**
	 * Punto de entrada para pruebas de la aplicación
	 * 
	 * @param args, Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		RedSocial s = null;
		try {
			s = new RedSocial("USUARIOS.txt", "ENLACES.txt", "MENSAJE.txt");
			
			s.addUsuario("claudia", 19, Exposicion.VIRAL);
			s.addUsuario("duna", 20, Exposicion.ALTA);
			s.addEnlace("claudia", "duna", 8);
			
			s.addAndSendMensaje("Hola Tuna!", 15, "claudia", "duna");
			
			s.guardarEnArchivo("USUARIOS2.txt", "ENLACES2.txt", "MENSAJE2.txt");
			
		} catch (IOException e) {
			System.out.println("Error en archivos");
		}
	}
}
