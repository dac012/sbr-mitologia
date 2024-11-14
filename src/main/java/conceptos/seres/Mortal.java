package conceptos.seres;

import java.util.LinkedList;
import java.util.List;

public abstract class Mortal extends Ser {
	private List<Dios> tiene_el_favor_de, tiene_enojo_de;

	public Mortal(String nombre)
	{
		super(nombre);
		tiene_el_favor_de = new LinkedList<>();
		tiene_enojo_de = new LinkedList<>();
	}
	
	public List<Dios> getTiene_el_favor_de() {
		return tiene_el_favor_de;
	}

	public void setTiene_el_favor_de(List<Dios> tiene_el_favor_de) {
		this.tiene_el_favor_de = tiene_el_favor_de;
	}

	public List<Dios> getTiene_enojo_de() {
		return tiene_enojo_de;
	}

	public void setTiene_enojo_de(List<Dios> tiene_enojo_de) {
		this.tiene_enojo_de = tiene_enojo_de;
	}
	
	public void addEnojado(Dios dios)
	{
		this.tiene_enojo_de.add(dios);
	}
	
	public void addDiosConFavor(Dios dios)
	{
		this.tiene_el_favor_de.add(dios);
	}
	
}
