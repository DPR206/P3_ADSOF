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
	 * @param nombre
	 */
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.amplificacion = 2;
		this.enlacesDirectos = new LinkedList<Enlace>();
	}

	/**
	 * @param nombre
	 * @param amplificacion
	 */
	public Usuario(String nombre, int amplificacion) {
		this.nombre = nombre;
		this.amplificacion = amplificacion;
		this.enlacesDirectos = new LinkedList<Enlace>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getAmplicacion() {
		return this.amplificacion;
	}
	
	public List<Enlace> getEnlaces(){
		return this.enlacesDirectos;
	}
	
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
	
	public Enlace getEnlace(int i) {
		return this.enlacesDirectos.get(i);
	}
	
	public int getNumEnlaces(){
		return this.enlacesDirectos.size();
	}
	
	public Enlace getEnlace(Usuario destino) {
		for(Enlace e: enlacesDirectos)
			if(e.getUsuarioDestino() == destino)
				return e;
		return null;
	}
	
	//Falta el método toString
}
