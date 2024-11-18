package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Divina extends Relacion {
	
	private Ser receptor;
	
	public Divina(Ser sujeto, Ser receptor)
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
