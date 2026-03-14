/**
 *  Este paquete contiene las pruebas hechas
 */
package pruebas;

import red_social.*;

/**
 * Esta clase representa una batería de pruebas
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: EjemploUspMensajesBasicos.java
 * 
 */
public class Prueba2Mensaje {

	/**
	 * Punto de entrada para pruebas de la aplicación
	 * 
	 * @param args, Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		Usuario ana = new Usuario("ana", 3);
		Usuario luis = new Usuario("luis", 11);
		Usuario carmen = new Usuario("carmen"); // por defecto capacidad 2
		Usuario diego = new Usuario("diego");
		
		Mensaje m1 = new Mensaje("¡HOLA!", 50, ana);
		
		ana.addEnlace(new Enlace(ana, luis, 68)); // totalCoste = 0 + 68
		ana.addEnlace(carmen, 33); // totalCoste = 101 = 68 + 33
		ana.addEnlace(diego, 20); // totalCoste = 121 = 101 + 20 
		System.out.println(m1);
		System.out.println(ana);
		System.out.println(ana.getEnlace(2));
		
		m1.difunde(luis.getEnlace(carmen));
		System.out.println(m1);
		
		carmen.addEnlace(new Enlace(carmen, luis, 11)); // totalCoste = 132 = 121 + 11
		luis.addEnlace(diego, 8); // totalCoste = 140 = 132 + 8
		m1.difunde(carmen, luis, diego, ana); // parará en diego
		System.out.println(m1); // alcance 13 = 50 - 33 + 2 - 11 + 11 - 8 + 2
		System.out.println(diego);
		
		diego.addEnlace(ana, 7); // totalCoste = 147 = 140 + 7
		m1.difunde(carmen, luis, diego, luis, ana); // hace la difusión entre diego y ana
		System.out.println(m1); // alcance 9 = 13 - 7 + 3
		System.out.println(diego);
		 
		Enlace e1 = new Enlace(carmen, diego, 0); // totalCoste = 148 = 147 + 1  // por defecto coste 1
		carmen.addEnlace(e1);
		System.out.println(e1);
		System.out.println("Total coste: "+e1.getTotalCostes());
		System.out.println("Número de enlaces (Carmen): "+carmen.getNumEnlaces());
		
		e1.cambiarDestino(ana, -1); // por defecto coste 1
		System.out.println(e1);

	}

}
