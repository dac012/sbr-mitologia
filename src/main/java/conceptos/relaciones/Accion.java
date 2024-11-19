package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Accion extends Relacion {
	
	public Accion(Ser sujeto, Ser receptor)
	{
		super(sujeto, receptor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(!(obj instanceof Accion))
			return false;
		
		Accion objeto = (Accion)obj;
		return objeto.getSujeto().equals(this.getSujeto())
				&& objeto.getReceptor().equals(this.getReceptor());
	}
	
}
