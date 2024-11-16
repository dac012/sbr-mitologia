package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Reflectante extends Capacidad{

	public Reflectante(Objeto objeto)
	{
		super(objeto);
	}
	
	public Reflectante(Ser sujeto)
	{
		super(sujeto);
	}
	
	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Reflectante";
		return getObjeto().toString() + " tiene capacidad Reflectante"; 
	}
}
