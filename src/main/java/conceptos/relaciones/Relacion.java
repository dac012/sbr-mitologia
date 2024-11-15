package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Relacion {
	
	private Ser sujeto;

	public Relacion(Ser sujeto)
	{
		this.sujeto = sujeto;
	}
	
	public Ser getSujeto() {
		return sujeto;
	}

	public void setSujeto(Ser sujeto) {
		this.sujeto = sujeto;
	}
	
}
