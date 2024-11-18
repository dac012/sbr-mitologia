package conceptos.seres;

public abstract class Criatura extends Ser {
	
	TipoCriatura tipo;
	
	public Criatura(String nombre, TipoCriatura tipo)
	{
		super(nombre);
		this.tipo = tipo;
	}
	
	public TipoCriatura getTipo()
	{
		return tipo;
	}
	
	public void setTipo(TipoCriatura tipo)
	{
		this.tipo = tipo;
	}
	
	public void setTipoCriatura(TipoCriatura tipo) {
		this.tipo=tipo;
	}
	
}
