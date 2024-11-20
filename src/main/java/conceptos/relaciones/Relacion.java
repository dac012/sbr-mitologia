package conceptos.relaciones;

public abstract class Relacion {
	
	private Object sujeto;
	private Object receptor;

	public Relacion(Object sujeto, Object receptor)
	{
		this.sujeto = sujeto;
		this.receptor = receptor;
	}

	protected Object getSujeto() {
		return sujeto;
	}

	public void setSujeto(Object sujeto) {
		this.sujeto = sujeto;
	}

	protected Object getReceptor() 
	{
		return receptor;
	}

	public void setReceptor(Object receptor) {
		this.receptor = receptor;
	}
	
}
