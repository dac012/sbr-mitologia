package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Personal extends Relacion {
		
	public Personal(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public Ser getSujeto() 
	{
		return (Ser) super.getSujeto();
	}
	
	@Override
	public Ser getReceptor() 
	{
		return (Ser)super.getReceptor();
	}
	
}
