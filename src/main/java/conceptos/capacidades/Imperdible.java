package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Imperdible extends Capacidad {
	
	public Imperdible(Objeto objeto)
	{
		super(objeto);
	}
	
	public Imperdible(Ser ser)
	{
		super(ser);
	}
	
	@Override
	public String toString() {
		String capacitado = null;
		if(getSujeto() == null)
			capacitado = getObjeto().toString();
		else
			capacitado = getSujeto().toString();
		return capacitado + " tiene capacidad Imperdible";
	}
	
}
