package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Personal extends Relacion {
	
	private Ser receptor;
	
	public Personal(Ser sujeto, Ser receptor)
	{
		super(sujeto);
		this.receptor = receptor;
	}

	public Ser getReceptor() {
		return receptor;
	}

	public void setReceptor(Ser receptor) {
		this.receptor = receptor;
	}
	
}
