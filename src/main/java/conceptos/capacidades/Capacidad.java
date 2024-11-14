package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public abstract class Capacidad {
	private final Objeto objeto;
	private final Ser sujeto;
	
	public Capacidad(Objeto objeto)
	{
		this.objeto = objeto;
		sujeto = null;
	}
	
	public Capacidad(Ser sujeto)
	{
		this.sujeto = sujeto;
		objeto = null;
	}
	
	public Objeto getObjeto() {
		return objeto;
	}
	
	public Ser getSujeto() {
		return sujeto;
	}
		
}
