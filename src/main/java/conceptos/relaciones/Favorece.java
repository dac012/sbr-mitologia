package conceptos.relaciones;

import conceptos.seres.Dios;
import conceptos.seres.Mortal;

public class Favorece extends Divina {

	public Favorece(Dios sujeto, Mortal receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " favorece a " + getReceptor().toString());
	}
}
