package pruebas;

import java.io.IOException;
import red_social.*;

public class Prueba2RedSocial {

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
