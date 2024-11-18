package conceptos.relaciones;

import conceptos.seres.Ser;

public class Enamora extends Personal {
	
	public Enamora(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public String toString() {
		return getSujeto().toString() + " esta enamorado de " + getReceptor().toString();
	}
	
}
