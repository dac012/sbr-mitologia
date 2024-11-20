package conceptos.capacidades;

public class Capacidad {
	String nombre;
	
	public Capacidad(String nombre)
	{
		this.nombre = nombre;
	}
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Capacidad)) return false;
		
		Capacidad objeto = (Capacidad)obj;
		return this.getNombre().equals(objeto.getNombre());
	}
	
	@Override
	public String toString() 
	{
		return nombre;
	}
}
