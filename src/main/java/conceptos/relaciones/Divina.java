package conceptos.relaciones;

import conceptos.seres.Dios;
import conceptos.seres.Mortal;

public abstract class Divina extends Relacion {
	
	private Mortal receptor;
	
	public Divina(Dios sujeto, Mortal receptor)
	{
		super(sujeto);
		this.receptor = receptor;
	}

	public Mortal getReceptor() {
		return receptor;
	}

	public void setReceptor(Mortal receptor) {
		this.receptor = receptor;
	}
		
}
