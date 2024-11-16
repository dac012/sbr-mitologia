package conceptos.relaciones;

import conceptos.seres.Dios;
import conceptos.seres.Mortal;

public class EnojadoCon extends Divina {

	public EnojadoCon(Dios sujeto, Mortal receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " esta enojado con " + getReceptor().toString());
	}
}
