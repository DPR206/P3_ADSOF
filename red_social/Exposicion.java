/**
 * Este paquete contiene las clases necesarias para la gestión de una red social
 */
package red_social;

/**
 * Esta clase representa la exposicion de un enlace señuelo
 * @author Claudia Saiz Escribano y Duna Puente Romera. 
 * @version 1.0
 * Nombre del fichero: Exposicion.java
 * 
 */
public enum Exposicion {
	OCULTA(0), BAJA(5), MEDIA(10), ALTA(20), VIRAL(50);
	
	private int rigidezMin;
	
	/**
	 * Crea un nuevo tipo de exposición
	 * 
	 * @param rigidezMin, rigidez mínima de la exposición
	 */
	private Exposicion(int rigidezMin) {
		this.rigidezMin = rigidezMin;
	}
	
	/**
	 * Obtiene la rigidez mínima de la exposición
	 * 
	 * @return int, la rigidez mínima
	 */
	public int getRigidezMin() {
		return rigidezMin;
	}

	/**
	 * Obtiene el siguiente nivel de exposición a otro dado
	 * 
	 * @return Exposicion, siguiente nivel de exposición
	 */
	public Exposicion siguiente() {
		Exposicion[] valores = values();
        int i = this.ordinal() + 1;

        if (i >= valores.length) {
            return this;
        }

        return valores[i];
	}
	
	/**
	 * Obtiene el nivel anterior de exposición a otro dado
	 * 
	 * @return Exposicion, anterior nivel de exposición
	 */
	public Exposicion anterior() {
	    Exposicion[] valores = values();
	    int i = this.ordinal() - 1;

	    if (i < 0) {
	        return this;
	    }

	    return valores[i];
	}
}
