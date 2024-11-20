package conceptos.relaciones;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Posee extends Posesion {
	
	public Posee(Ser sujeto, Objeto objeto)
	{
		super(sujeto, objeto);
	}

	@Override
	public Ser getSujeto() 
	{
		return (Ser)super.getSujeto(); 
	}
	
	public Objeto getObjeto()
	{
		return (Objeto)super.getReceptor();
	}
	
	@Override
	public String toString() 
	{
		return getSujeto().toString() + " tiene " + getReceptor().toString();
	}
}
