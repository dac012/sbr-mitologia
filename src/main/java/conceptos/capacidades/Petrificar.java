package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Petrificar extends Capacidad {

	public Petrificar(Objeto objeto)
	{
		super(objeto);
	}
	
	public Petrificar(Ser sujeto)
	{
		super(sujeto);
	}

	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Petrificar";
		return getObjeto().toString() + " tiene capacidad Petrificar"; 
	}
}
