package conceptos.seres;

import java.util.LinkedList;
import java.util.List;

public abstract class Dios extends Ser {
	private List<Mortal> enojado_con, ofrece_favor;
	
	public Dios(String nombre)
	{
		super(nombre);
		enojado_con = new LinkedList<>();
		ofrece_favor = new LinkedList<>();
	}

	public List<Mortal> getEnojado_con() {
		return enojado_con;
	}

	public void setEnojado_con(List<Mortal> enojado_con) {
		this.enojado_con = enojado_con;
	}

	public List<Mortal> getOfrece_favor() {
		return ofrece_favor;
	}

	public void setOfrece_favor(List<Mortal> ofrece_favor) {
		this.ofrece_favor = ofrece_favor;
	}
	
	public void addMortalQueEnoja(Mortal mortal)
	{
		this.enojado_con.add(mortal);
	}
	
	public void addMortalFavorecido(Mortal mortal)
	{
		this.ofrece_favor.add(mortal);
	}
}
