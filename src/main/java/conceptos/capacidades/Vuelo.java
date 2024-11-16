package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Vuelo extends Capacidad {

	public Vuelo(Objeto objeto)
	{
		super(objeto);
	}
	
	public Vuelo(Ser sujeto)
	{
		super(sujeto);
	}
	
	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Vuelo";
		return getObjeto().toString() + " tiene capacidad Vuelo"; 
	}
}
