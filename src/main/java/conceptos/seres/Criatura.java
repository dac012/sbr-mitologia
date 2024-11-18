package conceptos.seres;

public abstract class Criatura extends Ser {
	
	TipoCriatura tipo;
	
	public Criatura(String nombre, TipoCriatura tipo)
	{
		super(nombre);
		this.tipo = tipo;
	}
	
	public void setTipoCriatura(TipoCriatura tipo) {
		this.tipo=tipo;
	}
	
}
