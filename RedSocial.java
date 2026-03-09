/**
 * 
 */
package red_social;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class RedSocial {
	private Map <String, Usuario> usuarios = new HashMap<>();
	private List <Mensaje> mensajes = new ArrayList<>();

	/**
	 * 
	 */
	public RedSocial(String f_usuarios, String f_enlaces, String f_mensaje) throws IOException {
		String linea;
		String[] partes;
		
		/* Leer usuarios */
		try (BufferedReader br = new BufferedReader(new FileReader(f_usuarios))) {
			while ((linea = br.readLine()) != null) {
		    	partes = linea.split("\\s+");
		    	if(partes.length != 2) {
		    		throw new IOException("Formato incorrecto de archivo de usuarios");
		    	}
		    	usuarios.put(partes[0], new Usuario(partes[0], Integer.parseInt(partes[1])));
		    }
		}
		
	    /* Leer enlaces */
		Usuario usuarioOrigen = null;
		Usuario usuarioDestino = null;
		try (BufferedReader br = new BufferedReader(new FileReader(f_enlaces))) {
			while ((linea = br.readLine()) != null) {
		    	partes = linea.split("\\s+");
		    	if(partes.length != 3) {
		    		throw new IOException("Formato incorrecto de archivo de enlaces");
		    	}
		    	
		    	usuarioOrigen = usuarios.get(partes[0]);
		    	usuarioDestino = usuarios.get(partes[1]);
		    	
		    	if(usuarioOrigen == null || usuarioDestino == null) {
		    		throw new IOException("Usuarios incorrectos en archivo de enlaces");
		    	}
		    	
		    	usuarioOrigen.addEnlace(new Enlace(usuarioOrigen, usuarioDestino, Integer.parseInt(partes[2])));
		    }
		}
	    
	    /* Leer mensaje */
		List <Usuario> usr_mensaje= new ArrayList<Usuario>();
		Mensaje mensaje;
		usuarioOrigen = null;
		try (BufferedReader br = new BufferedReader(new FileReader(f_mensaje))) {
			linea = br.readLine();
			partes = linea.split("\\s+");
			if(partes.length != 3) {
	    		throw new IOException("Formato incorrecto de archivo de mensaje");
	    	}
			
			usuarioOrigen = usuarios.get(partes[2]);
			if(usuarioOrigen == null) {
				throw new IOException("UsuarioActual incorrecto en archivo de mensaje");
			}
			mensaje = new Mensaje(partes[0], Integer.parseInt(partes[1]), usuarioOrigen);
				
			while ((linea = br.readLine()) != null) {
				usuarioOrigen = null;
				usuarioOrigen = usuarios.get(linea);
				if (usuarioOrigen == null) {
					throw new IOException("Error en usuarios en archivo de mensaje");
				}
		    	usr_mensaje.add(usuarioOrigen);
		    	
		    }
			mensajes.add(mensaje);
			for (Usuario u : usr_mensaje) {
				if (mensaje.difunde(u) == true) {
					System.out.println(mensaje);
				}
			}
		}
	}
	
	public boolean guardarEnArchivo(String f_usuarios, String f_enlaces, String f_mensaje) {
		return true;
	}
}
