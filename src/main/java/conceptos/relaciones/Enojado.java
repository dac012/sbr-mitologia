package conceptos.relaciones;

import conceptos.seres.Ser;

public class Enojado extends Personal {

	public Enojado(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " esta enojado con " + getReceptor().toString());
	}
}
