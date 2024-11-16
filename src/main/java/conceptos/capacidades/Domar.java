package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Domar extends Capacidad {

	public Domar(Objeto objeto)
	{
		super(objeto);
	}
	
	public Domar(Ser sujeto)
	{
		super(sujeto);
	}
	
	@Override
	public String toString() {
		if(getSujeto() != null) return getSujeto().toString() + " tiene capacidad Domar";
		return getObjeto().toString() + " tiene capacidad Domar"; 
	}
}
