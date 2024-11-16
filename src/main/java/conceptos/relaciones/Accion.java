package conceptos.relaciones;

import conceptos.seres.Ser;

public abstract class Accion extends Relacion {
	
	private Ser receptor;
	
	public Accion(Ser sujeto, Ser receptor)
	{
		super(sujeto);
		this.receptor = receptor;
	}

	public Ser getReceptor() {
		return receptor;
	}

	public void setReceptor(Ser receptor) {
		this.receptor = receptor;
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
