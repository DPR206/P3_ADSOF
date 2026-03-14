package red_social;

import java.io.IOException;

public class PruebaUsoRedSocial2 {

	public static void main(String[] args) {
		RedSocial s = null;
		try {
			s = new RedSocial("USUARIOS2.txt", "ENLACES2.txt", "MENSAJE2.txt");
			
			/*s.addUsuario("claudia", 19, Exposicion.VIRAL);
			s.addUsuario("duna", 20, Exposicion.ALTA);
			s.addEnlace("claudia", "duna", 8);
			
			s.addAndSendMensaje("Hola Tuna!", 15, "claudia", "duna");
			
			s.guardarEnArchivo("USUARIOS2.txt", "ENLACES2.txt", "MENSAJE2.txt");*/
			
		} catch (IOException e) {
			System.out.println("Error en archivos");
		}
	}
}
