package pruebas;

import red_social.*;

public class Prueba1AjustarExposicion {

	public static void main(String[] args) {
		Usuario duna = new Usuario("duna", 10, Exposicion.ALTA);
		Usuario claudia = new Usuario("claudia", 9, Exposicion.MEDIA);

		Mensaje m1 = new Mensaje("Hola Clotilda!", 20, claudia);
		Mensaje m2 = new Mensaje("Hola Tuna!", 10, claudia);
		
		duna.addEnlace(claudia, 6);
		claudia.addEnlace(duna, 5);
		
		/*La exposición disminuye a MEDIA por recibir un mensaje con alcance menor que la media */
		m1.difunde(duna);
		m2.difunde(duna);
		System.out.println(duna);
		
		/*La exposición aumenta de nuevo a ALTA por recibir un mensaje con alcance mayor a la media */
		m1.difunde(claudia);
		m1.difunde(duna);
		System.out.println(duna);
	}

}
