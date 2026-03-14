package pruebas;

import red_social.*;

/**
 * Este programa prueba el funcionamiento de la difusión para Usuarios Interesados
 */
public class Prueba1UsuarioInteresado{

	public static void main(String[] args) {
		Usuario tiago = new Usuario("tiago", 3, Exposicion.BAJA);
		Usuario andrea = new Usuario("andrea", 5, Exposicion.MEDIA);
		
		Usuario duna = new UsuarioInteresado("duna", 10, Exposicion.ALTA);
		Usuario claudia = new UsuarioInteresado("claudia", 9, Exposicion.VIRAL);
		
		Mensaje m1 = new Mensaje("Hola a todos!", 20, duna);
		
		duna.addEnlace(claudia, 10);
		duna.addEnlace(tiago, 4);
		duna.addEnlace(andrea, 6);
		
		/* Como Duna es UsuarioInteresado, el mensaje se difundirá a su primer enlace con exposicion VIRAL/ALTA (claudia)*/
		m1.difunde(tiago, andrea);
		System.out.println(m1);
		
		claudia.addEnlace(tiago, 10);
		tiago.addEnlace(andrea, 2);
		
		/*Ahora Claudia no tiene un enlace con exposicion VIRAL/ALTA, así que lo difunde de la manera por defecto*/
		m1.difunde(tiago, andrea);
		System.out.println(m1);
	}

}
