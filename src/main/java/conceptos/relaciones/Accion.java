package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Accion extends Relacion {
	
	public Accion(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public Ser getSujeto() 
	{
		return (Ser)super.getSujeto();
	}
	
	@Override
	public Ser getReceptor() 
	{
		// TODO Auto-generated method stub
		return (Ser)super.getReceptor();
	}
		
}
