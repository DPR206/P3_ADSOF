/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

import java.util.*;
/**
 * Esta clase representa un mensaje
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Mensaje.java
 * 
 */
public class Mensaje {
	private Usuario autor;
	private int alcance;
	private Usuario usuarioActual;
	
	/**
	 * Crea un nuevo mensaje
	 * 
	 * @param autor, autor del mensaje
	 * @param alcance, alcance del mensaje
	 * @param usuarioActual, usuario actual del mensaje
	 */
	public Mensaje(Usuario autor, int alcance, Usuario usuarioActual) {
		this.autor = autor;
		this.alcance = alcance;
		this.usuarioActual = usuarioActual;
	}

	/**
	 * Obtiene el autor del mensaje
	 * 
	 * @return Usuario, el autor
	 */
	public Usuario getAutor() {
		return autor;
	}

	/**
	 * Establece el nombre de usuario
	 * 
	 * @param autor, autor a determinar
	 */
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	/**
	 * Obtiene el alcance del mensaje
	 * 
	 * @return int, valor de alcance disponible
	 */
	public int getAlcance() {
		return alcance;
	}

	/**
	 * Establece el alcance del mensaje
	 * 
	 * @param alcance el valor del alcance del mensaje
	 */
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	/**
	 * Obtiene el usuario actual
	 * 
	 * @return Usuario, el usuario actual
	 */
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	/**
	 * Establecer el usuario actual
	 * 
	 * @param usuarioActual el usuario actual a establecer
	 */
	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	
	/**
	 * Devuelve la información de un mensaje como cadena de texto
	 * 
	 * @return String, cadena de texto con la información del mensaje
	 */
	public String toString() {
		return "Mensaje(m:"+alcance+") en @"+usuarioActual.getNombre();
	}
	
	/**
	 * Determina si el alcance del mensaje es mayor que el coste real del enlace
	 * 
	 * @param e enlace
	 * @return true si el alcance es mayor o igual que el coste, false en caso contrario
	 */
	public boolean puedeDifundirPor(Enlace e) {
		if(this.alcance >= e.getCoste())
			return true;
		return false;
	}
	
	/**
	 * Definida para futuras extensiones
	 * 
	 * @param u usuario
	 * @return true
	 */
	public boolean aceptadoPor(Usuario u) {
		return true;
	}
	
	/**
	 * Difunde un mensaje si se dan las condiciones adecuadas
	 * 
	 * @param e enlace para la difusión
	 * @return true si se ha difundido el mensaje, false en caso contrario
	 */
	public boolean difunde(Enlace e) {
		
		if(e.getUsuarioOrigen()==this.usuarioActual && this.puedeDifundirPor(e) && this.aceptadoPor(e.getUsuarioDestino())) {
			e.cambiarDestino(usuarioActual, e.getCoste());
			alcance = alcance - e.getCoste() + e.getUsuarioDestino().getAmplicacion();
			return true;
		} else
			return false;	
	}
	
	/**
	 * Difunde un mensaje dentro de una lista de usuarios si se dan las condiciones
	 * 
	 * @param usuarios usuarios sobre los que realizar la difusión
	 * @return true si se ha difundido el mensaje, false en caso contrario
	 */
	public boolean difunde(List<Usuario> usuarios) {
		boolean status = true;
		Enlace e;
		int index;
		for(Usuario u:usuarios) {
			index = usuarios.indexOf(u);
			e = u.getEnlace(usuarios.get(index));
			if(difunde(e) == false)
				status = false;
		}
		return status;
	}
}
