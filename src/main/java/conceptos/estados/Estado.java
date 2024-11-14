package conceptos.estados;

import conceptos.seres.Ser;

public abstract class Estado {
	private Ser sujeto;
		
	public Estado(Ser sujeto)
	{
		this.sujeto = sujeto;
	}
	
	public Ser getSujeto()
	{
		return sujeto;
	}
	
	public void setSujeto(Ser sujeto)
	{
		this.sujeto = sujeto;
	}
}
