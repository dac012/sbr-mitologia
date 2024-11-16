package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Letal extends Capacidad {

	public Letal(Objeto objeto)
	{
		super(objeto);
	}
	
	public Letal(Ser sujeto)
	{
		super(sujeto);
	}
	
	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Letal";
		return getObjeto().toString() + " tiene capacidad Letal"; 
	}
}
