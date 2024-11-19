package conceptos.relaciones;

import conceptos.capacidades.Capacidad;
import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Domina extends Posesion {
	
	public Domina(Ser sujeto, Capacidad receptor)
	{
		super(sujeto, receptor);
	}
	
	public Domina(Objeto sujeto, Capacidad receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() 
	{
		return getSujeto().toString() + " tiene la capacidad " + getReceptor().toString(); 
	}
}
