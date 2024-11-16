package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Invisibilidad extends Capacidad {

	public Invisibilidad(Objeto objeto)
	{
		super(objeto);
	}
	
	public Invisibilidad(Ser sujeto)
	{
		super(sujeto);
	}
	
	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Invisibilidad";
		return getObjeto().toString() + " tiene capacidad Invisibilidad"; 
	}
	
}
