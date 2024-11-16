package conceptos.relaciones;

import conceptos.seres.Ser;

public class Libera extends Accion {
	
	public Libera(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " ha liberado a " + getReceptor().toString());
	}
}
