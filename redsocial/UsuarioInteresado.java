package red_social;

public class UsuarioInteresado extends Usuario {

	public UsuarioInteresado(String nombre) {
		super(nombre);
	}

	public UsuarioInteresado(String nombre, Exposicion e) {
		super(nombre, e);
	}

	public UsuarioInteresado(String nombre, int amplificacion) {
		super(nombre, amplificacion);
	}

	public UsuarioInteresado(String nombre, int amplificacion, Exposicion e) {
		super(nombre, amplificacion, e);
	}

	public Enlace getBestEnlace() {
		for(Enlace e : this.getEnlaces()) {
	        if(e.getUsuarioDestino().getExposicion() == Exposicion.ALTA ||
	           e.getUsuarioDestino().getExposicion() == Exposicion.VIRAL) {
	        	return e;
	        }
		}
		return null;
	}
}
