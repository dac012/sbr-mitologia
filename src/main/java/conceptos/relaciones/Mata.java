package conceptos.relaciones;

import conceptos.seres.Ser;

public class Mata extends Accion {
	
	public Mata(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " ha matado a " + getReceptor().toString());
	}
}
