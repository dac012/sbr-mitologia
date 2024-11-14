package conceptos.objetos;

import conceptos.seres.Ser;

public abstract class Objeto {
	private String nombre;
	private Ser poseido_por;
	
	public Objeto(String nombre)
	{
		this.nombre = nombre;
		poseido_por = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ser getPoseido_por() {
		return poseido_por;
	}

	public void setPoseido_por(Ser poseido_por) {
		this.poseido_por = poseido_por;
	}
	
	
}
