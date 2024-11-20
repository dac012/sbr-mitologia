package conceptos.relaciones;

import conceptos.capacidades.Capacidad;
import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Domina extends Posesion {
	
	public Domina(Ser sujeto, Capacidad receptor)
	{
		super(sujeto, receptor);
	}
	
	public Domina(Objeto objeto, Capacidad receptor)
	{
		super(objeto, receptor);
	}
	
	@Override
	public Ser getSujeto() 
	{
		Object sujeto = super.getSujeto();
		if(!(sujeto instanceof Ser)) return null;
		return (Ser) sujeto;
	}
	
	public Objeto getObjeto()
	{
		Object sujeto = super.getSujeto();
		if(!(sujeto instanceof Objeto)) return null;
		return (Objeto)super.getSujeto();
	}
	
	public Capacidad getCapacidad()
	{
		return (Capacidad)super.getReceptor();
	}
	
	@Override
	public String toString() 
	{
		if(getSujeto() == null)
			return getObjeto().toString() + " tiene la capacidad " + getReceptor().toString();
		return getSujeto().toString() + " tiene la capacidad " + getReceptor().toString(); 
	}
}
