package conceptos.capacidades;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Contenedor extends Capacidad {
	
	public Contenedor(Objeto objeto)
	{
		super(objeto);
	}
	
	public Contenedor(Ser sujeto)
	{
		super(sujeto);
	}
}
