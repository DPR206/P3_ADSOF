package red_social;

public class EnlaceSeñuelo extends Enlace{
	private int costeExtra;
	private double probRetorno;

	public EnlaceSeñuelo(Usuario usuarioOrigen, Usuario usuarioDestino, int coste, int costeExtra, double probRetorno) {
		super(usuarioOrigen, usuarioDestino, coste);
		this.costeExtra = costeExtra;
		this.probRetorno = probRetorno;
	}
	
	public EnlaceSeñuelo(Usuario usuarioOrigen, Usuario usuarioDestino, int costeExtra, double probRetorno) {
		super(usuarioOrigen, usuarioDestino);
		this.costeExtra = costeExtra;
		this.probRetorno = probRetorno;
	}
	
	public int costeEspecial(){
		return this.getCoste() * this.costeExtra;
	}
	
	public double getProbabilidad() {
		return probRetorno;
	}
}
