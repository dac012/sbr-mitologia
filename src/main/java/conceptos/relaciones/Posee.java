package conceptos.relaciones;

import conceptos.objetos.Objeto;
import conceptos.seres.Ser;

public class Posee extends Relacion {
	
	private Objeto objeto;
	
	public Posee(Ser sujeto, Objeto objeto)
	{
		super(sujeto);
		this.objeto = objeto;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	@Override
	public String toString() {
		return getSujeto().toString() + " tiene " + getObjeto().toString();
	}
}
