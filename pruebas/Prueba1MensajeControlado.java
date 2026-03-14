package pruebas;

import red_social.*;

public class Prueba1MensajeControlado {

	public static void main(String[] args) {
		Usuario duna = new Usuario("duna", 10, Exposicion.ALTA);
		Usuario claudia = new Usuario("claudia", 10, Exposicion.ALTA);
		Mensaje m1 = new MensajeControlado("Hola Clotilda!", 20, claudia, 60);
		Mensaje m2 = new MensajeControlado("Hola Tuna!", 20, duna, 60);
		
		claudia.addEnlace(new Enlace(claudia, duna, 6));
		duna.addEnlace(new EnlaceSeñuelo(duna, claudia, 6, 0));
		
		/* El primer mensaje se enviará, pero el segundo no, por ser através de un enlace señuelo*/
		if(m1.difunde(duna))
			System.out.println("El mensaje controlado se envía correctamente por un enlace normal");
		if(!m2.difunde(claudia))
			System.out.println("El mensaje controlado no se envía por un enlace señuelo");
		System.out.println(m1 + "\n" + m2);
	}

}
