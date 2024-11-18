package conceptos.relaciones;

import conceptos.seres.Ser;

public class EnojadoCon extends Divina {

	public EnojadoCon(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " esta enojado con " + getReceptor().toString());
	}
}
