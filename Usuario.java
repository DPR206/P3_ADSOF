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
	private List<Enlace> enlacesDirectos;
	private Exposicion exposicion;
	private List<Mensaje> mensajes;
	private double avgAlcance;
	
	/**
	 * Crea un nuevo usuario con una amplificación por defecto (2), exposicion por defecto (ALTA) y una colección de enlaces vacía
	 * 
	 * @param nombre, nombre del usuario
	 */
	public Usuario(String nombre) {
		this(nombre, 2, Exposicion.ALTA);
	}
	
	/**
	 * Crea un nuevo usuario con una amplificación por defecto (2) y una colección de enlaces vacía
	 * 
	 * @param nombre, nombre del usuario
	 * @param e, exposicion del usuario
	 */
	public Usuario(String nombre, Exposicion e) {
		this(nombre, 2, e);
	}

	/**
	 * Crea un nuevo usuario con una colección de enlaces vacía, con exposicion por defecto (ALTA)
	 * 
	 * @param nombre, nombre del usuario
	 * @param amplificacion, valor de la capacidad de amplificación
	 */
	public Usuario(String nombre, int amplificacion) {
		this(nombre, amplificacion, Exposicion.ALTA);
	}
	
	/**
	 * Crea un nuevo usuario con una colección de enlaces vacía
	 * 
	 * @param nombre, nombre del usuario
	 * @param amplificacion, valor de la capacidad de amplificación
	 * @param e, exposicion del usuario
	 */
	public Usuario(String nombre, int amplificacion, Exposicion e) {
		this.nombre = nombre;
		this.amplificacion = amplificacion;
		this.exposicion = e;
		this.avgAlcance = 0;
		this.enlacesDirectos = new LinkedList<>();
		this.mensajes = new LinkedList<>();
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
	public int getAmplificacion() {
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
		
		if(destino == null)
			return null;
		
		for(Enlace e: enlacesDirectos)
			if(e.getUsuarioDestino() == destino)
				return e;
		return null;
	}
	
	/**
	 * Obtiene la exposición de un usuario
	 * @return Exposicion, la exposición del usuario
	 */
	public Exposicion getExposicion() {
		return exposicion;
	}
	
	/**
	 * Añade un nuevo enlace al usuario, siempre y cuando no sea preexistente o una autoreferencia
	 * 
	 * @param e, enlace nuevo a añadir
	 * @return true si el enlace se ha añadido correctamente, false en el caso contrario
	 */
	public boolean addEnlace(Enlace e) {
		
		if(e == null)
			return false;
		
		for(Enlace en: enlacesDirectos)
			if(en == e)
				return false;
		
		if(e.getUsuarioOrigen() != this)
			return false;
		else if(e.getUsuarioDestino() == this)
			return false;
		else {
			this.enlacesDirectos.add(e);
			return true;
		}
	}
	
	/**
	 * Añade un nuevo enlace en base a un usuario de destino y un coste
	 * 
	 * @param usuario_des, el usuario de destino del enlace
	 * @param coste, el coste del enlace
	 * @return true si el enlace se ha añadido correctamente, false en el caso contrario
	 */
	public boolean addEnlace(Usuario usuario_des, int coste) {
		if(usuario_des == null)
			return false;
		Enlace e = new Enlace(this, usuario_des, coste);
		return this.addEnlace(e);
	}
	
	/**
	 * Cambia la exposicion de un usuario al valor dado
	 * 
	 * @param e, nueva exposicion del usuario
	 * @return void
	 */
	public void cambiarExposicion(Exposicion e) {
		this.exposicion = e;
	}
	
	/**
	 * Añade un mensaje al historial del usuario y ajusta su exposicion
	 * 
	 * @param mensaje, mensaje que el usuario ha recibido
	 * @return boolean, true si el mensaje se añade correctamente, false en caso contrario
	 */
	public boolean addMensaje(Mensaje mensaje) {
		if(mensaje.getAlcance() > this.avgAlcance) {
			this.cambiarExposicion(this.exposicion.siguiente());
		} else {
			this.cambiarExposicion(this.exposicion.anterior());
		}
		
		this.avgAlcance = (avgAlcance * mensajes.size() + mensaje.getAlcance())/(mensajes.size() + 1);
		mensajes.add(mensaje);
		return true;
	}
	
	
	/**
	 * Devuelve la información de un usuario como cadena de texto
	 * 
	 * @return String, cadena de texto con la información del usuario
	 */
	public String toString() {
		return "@"+this.nombre+"("+this.amplificacion+")"+"["+this.enlacesDirectos+"]";
	}
}
