package conceptos.relaciones;

import conceptos.seres.Ser;

public class Apresa extends Accion {
	
	public Apresa(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return(getSujeto().toString() + " ha apresado a " + getReceptor().toString());
	}
}
