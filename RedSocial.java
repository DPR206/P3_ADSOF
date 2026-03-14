/**
 * Este paquete contiene las clases necesarias para la gestión de una red social
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
	 * Crea una RedSocial a partir de un fichero de usuario, enlaces y un mensaje inicial
	 * 
	 * @param f_usuarios, nombre del fichero con usuarios
	 * @param f_enlaces, nombre del fichero con enlaces
	 * @param f_mensaje, nombre del fichero con un mensaje
	 * @throws IOException
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
		Mensaje mensaje;
		Usuario usr = null;
		try (BufferedReader br = new BufferedReader(new FileReader(f_mensaje))) {
			linea = br.readLine();
			while (true) {
				int inicio = linea.indexOf("\"") + 1;
				int fin = linea.indexOf("\"", inicio);
				String texto = linea.substring(inicio, fin);
				
				linea = linea.substring(fin + 1).trim();
				partes = linea.split("\\s+");
				if(partes.length != 2) {
		    		throw new IOException("Formato incorrecto de archivo de mensaje");
		    	}

				usr = usuarios.get(partes[1]);
				if(usr == null) {
					throw new IOException("UsuarioActual incorrecto en archivo de mensaje");
				}
				mensaje = new Mensaje(texto, Integer.parseInt(partes[0]), usr);
				
				while ((linea = br.readLine()) != null) {
					if((linea.split("\\s+")).length > 1) {
						break;
					}
					usr = null;
					usr = usuarios.get(linea);
					if (usr == null) {
						throw new IOException("Error en usuarios en archivo de mensaje");
					}
					if (mensaje.difunde(usr) == true) {
						System.out.println(mensaje);
					} else {
						usr.addMensaje(mensaje);
					}
			    }
				mensajes.add(mensaje);
				if(linea == null)
					break;

			}
		}
	}
	
	/**
	 * Crea y añade un usuario a la RedSocial
	 * 
	 * @param nombre del usuario
	 * @param amplificacion del usuario
	 * @param e, exposicion del usuario
	 * @return true si se añade correctamente, false en caso contrario
	 */
	public boolean addUsuario(String nombre, int amplificacion, Exposicion e) {
		Usuario u = new Usuario(nombre, amplificacion, e);
		usuarios.put(nombre, u);
		return true;
	}
	
	/**
	 * Crea y añade un enlace a la RedSocial
	 * 
	 * @param usuarioOrigen del enlace
	 * @param usuarioDestino del enlace
	 * @param coste del enlace
	 * @return true si se añade correctamente, false en caso contrario
	 */
	public boolean addEnlace(String usuarioOrigen, String usuarioDestino, int coste) {
		Usuario origen = null;
		Usuario destino = null;
		
		origen = usuarios.get(usuarioOrigen);
		destino = usuarios.get(usuarioDestino);
		if(origen == null || destino == null) {
			return false;
		}
		
		origen.addEnlace(new Enlace(origen, destino, coste));
		return true;
	}
	
	/**
	 * Crea y añade un mensaje a la RedSocial
	 * 
	 * @param texto del mensaje
	 * @param alcance del mensaje
	 * @param usuarioActual del mensaje
	 * @return true si se añade correctamente, false en caso contrario
	 */
	public boolean addMensaje(String texto, int alcance, String usuarioActual) {
		Usuario actual = null;
		
		actual = usuarios.get(usuarioActual);
		if(actual == null) {
			return false;
		}
		
		mensajes.add(new Mensaje(texto, alcance, actual));
		return true;
	}
	
	/**
	 * Crea, añade y envía un mensaje a una lista de usuarios dada 
	 * 
	 * @param texto del mensaje
	 * @param alcance del mensaje
	 * @param usuarioActual del mensaje
	 * @param listaUsuarios a los que se envía dicho mensaje
	 * @return true si se añade correctamente, false en caso contrario
	 */
	public boolean addAndSendMensaje(String texto, int alcance, String usuarioActual, String...listaUsuarios) {
		Usuario actual = null;
		boolean status = true;
		
		actual = usuarios.get(usuarioActual);
		if(actual == null) {
			return false;
		}
		
		Mensaje m = new Mensaje(texto, alcance, actual);
		mensajes.add(m);
		for(String s : listaUsuarios) {
			if (!m.difunde(usuarios.get(s))) {
				status = false;
			}
			System.out.println(m);
		}
		return status;
	}
	
	/**
	 * Guarda en ficheros los datos actuales de la RedSocial, como los usuarios, los enlaces entre ellos y los mensajes que se han mandado
	 * 
	 * @param f_usuarios
	 * @param f_enlaces
	 * @param f_mensajes
	 * @throws IOException
	 */
	public void guardarEnArchivo(String f_usuarios, String f_enlaces, String f_mensajes) throws IOException {
		
		/* Escribir usuarios */
		FileWriter writer = new FileWriter(f_usuarios);
		for (Usuario u : usuarios.values()) {
			writer.write(u.getNombre() + " " + u.getAmplificacion() + "\n");
		}
		writer.close();
		
		/* Escribir enlaces */
		writer = new FileWriter(f_enlaces);
		for(Usuario u : usuarios.values()) {
			for(Enlace e : u.getEnlaces()) {
				writer.write(e.getUsuarioOrigen().getNombre() + " " + e.getUsuarioDestino().getNombre() + " " + e.getCoste() + "\n");
			}
		}
		writer.close();
		
		/* Escribir mensajes */
		writer = new FileWriter(f_mensajes);
		for(Mensaje m : mensajes) {
			writer.write("\"" + m.getTexto() + "\"" + " " + m.getAlcance() + " " + m.getUsuarioActual().getNombre() + "\n");
			for(Usuario u : usuarios.values()) {
				if(u.contieneMensaje(m)) {
					writer.write(u.getNombre() + "\n");
				}
			}
		}
		writer.close();

	}
}
