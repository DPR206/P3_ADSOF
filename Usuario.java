/**
 *  Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

import java.util.*;

/**
 * Esta clase representa un usuario
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Usuario.java
 * 
 */
public class Usuario {
	private String nombre;
	private int amplificacion;
	private List<Enlace> enlacesDirectos = new LinkedList<Enlace>(); //tengo dudas sobre si hacer la declaracion de new
	
	/**
	 * Crea un nuevo usuario con una amplificación por defecto (2) y una colección de enlaces vacía
	 * 
	 * @param nombre, nombre del usuario
	 */
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.amplificacion = 2;
		this.enlacesDirectos = new LinkedList<Enlace>();
	}

	/**
	 * Crea un nuevo usuario con una colección de enlaces vacía
	 * 
	 * @param nombre, nombre del usuario
	 * @param amplificacion, valor de la capacidad de amplificación
	 */
	public Usuario(String nombre, int amplificacion) {
		this.nombre = nombre;
		this.amplificacion = amplificacion;
		this.enlacesDirectos = new LinkedList<Enlace>();
	}
	
	/**
	 * Obtiene el nombre del usuario
	 * 
	 * @return String, nombre del usuario
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Obtiene la capacidad de amplificación
	 * 
	 * @return int, capacidad de amplificación
	 */
	public int getAmplicacion() {
		return this.amplificacion;
	}
	
	/**
	 * Obtiene la colección de enlaces salientes
	 * 
	 * @return List<Enlace>, lista con los enlaces salientes
	 */
	public List<Enlace> getEnlaces(){
		return this.enlacesDirectos;
	}
	
	/**
	 * Añade un nuevo enlace al usuario, siempre y cuando no sea preexistente o una autoreferencia
	 * 
	 * @param e, enlace nuevo a añadir
	 * @return true si el enlace se ha añadido correctamente, false en el caso contrario
	 */
	public boolean addEnlace(Enlace e) {
		
		for(Enlace en: enlacesDirectos)
			if(en == e)
				return false;
		
		if(e.getUsuarioOrigen() == this)
			return false;
		else if(e.getUsuarioDestino() == this)
			return false;
		else
			this.enlacesDirectos.add(e);
			return true;
	}
	
	//Falta sobreescribir el método
	
	/**
	 * Obtiene el enlace en una posición dada
	 * 
	 * @param i, posición a buscar
	 * @return Enlace, el enlace en dicha posición
	 */
	public Enlace getEnlace(int i) {
		return this.enlacesDirectos.get(i);
	}
	
	/**
	 * Obtiene la cantidad de enlaces salientes de un usuario
	 * 
	 * @return int, representa el número de enlaces 
	 */
	public int getNumEnlaces(){
		return this.enlacesDirectos.size();
	}
	
	/**
	 * Obtiene el enlace directo entre este usuario y el proporcionado
	 * 
	 * @param destino, usuario de destino
	 * @return Enlace, el enlace de conexión o null si no existiera 
	 */
	public Enlace getEnlace(Usuario destino) {
		for(Enlace e: enlacesDirectos)
			if(e.getUsuarioDestino() == destino)
				return e;
		return null;
	}
	
	//Falta el método toString
}
