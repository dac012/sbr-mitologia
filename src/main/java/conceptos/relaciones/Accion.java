package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Accion extends Relacion {
	
	private Ser receptor;
	
	public Accion(Ser sujeto, Ser receptor)
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
