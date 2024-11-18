package conceptos.relaciones;

import conceptos.seres.Criatura;
import conceptos.seres.Ser;

public class Doma extends Accion {
		
	public Doma(Ser ser, Criatura criatura)
	{
		super(ser, criatura);
	}
	
	@Override
	public String toString() {
		return getSujeto().toString() + " ha domado a " + getReceptor().toString();
	}
}
