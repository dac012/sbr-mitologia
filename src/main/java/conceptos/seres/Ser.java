package conceptos.seres;

import java.util.LinkedList;
import java.util.List;

import conceptos.objetos.Objeto;

public abstract class Ser {
	private final String nombre;
	private boolean muerto;
	
	public Ser(String nombre)
	{
		this.nombre = nombre;
		muerto = false;
	}

	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(!(obj instanceof Ser))
			return false;
		
		Ser objeto = (Ser) obj;
		return objeto.getNombre().equals(this.getNombre()) &&
				objeto.isMuerto() == this.isMuerto();
	}
}
