package red_social;

public enum Exposicion {
	OCULTA(0), BAJA(5), MEDIA(10), ALTA(20), VIRAL(50);
	
	private int rigidezMin;
	
	private Exposicion(int rigidezMin) {
		this.rigidezMin = rigidezMin;
	}
	
	public int getRigidezMin() {
		return rigidezMin;
	}

	public Exposicion siguiente() {
		Exposicion[] valores = values();
        int i = this.ordinal() + 1;

        if (i >= valores.length) {
            return this;
        }

        return valores[i];
	}
	
	public Exposicion anterior() {
	    Exposicion[] valores = values();
	    int i = this.ordinal() - 1;

	    if (i < 0) {
	        return this;
	    }

	    return valores[i];
	}
}
