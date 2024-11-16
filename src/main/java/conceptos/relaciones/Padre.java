package conceptos.relaciones;

import conceptos.seres.Ser;

public class Padre extends Personal {

	public Padre(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() {
		return getReceptor().toString() + " es hijo o hija de " + getSujeto().toString();
	}
}
