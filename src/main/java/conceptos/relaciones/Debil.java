package conceptos.relaciones;

import conceptos.capacidades.Capacidad;
import conceptos.seres.Criatura;

public class Debil extends Posesion {
	
	public Debil(Criatura sujeto, Capacidad receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() {
		return getSujeto().toString() + " tiene debilidad a " + getReceptor().toString();
	}
	
}
