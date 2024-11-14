package conceptos.seres;

import java.util.LinkedList;
import java.util.List;

import conceptos.objetos.Objeto;

public abstract class Ser {
	private final String nombre;
	private List<Ser> es_hijo_de, es_padre_de,  ha_apresado_a, ha_liberado_a, ha_matado_a, tiene_localizado_a;
	private Ser apresado_por, liberado_por, matado_por;
	private List<Objeto> tiene;
	
	public Ser(String nombre)
	{
		this.nombre = nombre;
		es_hijo_de = new LinkedList<>();
		es_padre_de = new LinkedList<>();
		ha_apresado_a = new LinkedList<>();
		ha_liberado_a = new LinkedList<>();
		ha_matado_a = new LinkedList<>();
		tiene_localizado_a = new LinkedList<>();
		apresado_por = null;
		liberado_por = null;
		matado_por = null;
		tiene = new LinkedList<Objeto>();
	}	
	
	public List<Ser> getEs_hijo_de() {
		return es_hijo_de;
	}

	public void addPadre(Ser padre)
	{
		if(es_hijo_de.size() <= 2)
		{
			es_hijo_de.add(padre);
		}
	}
	
	public void addHijo(Ser ser)
	{
		es_padre_de.add(ser);
	}

	public void setEs_hijo_de(List<Ser> es_hijo_de) {
		this.es_hijo_de = es_hijo_de;
	}



	public List<Ser> getEs_padre_de() {
		return es_padre_de;
	}



	public void setEs_padre_de(List<Ser> es_padre_de) {
		this.es_padre_de = es_padre_de;
	}



	public List<Ser> getHa_apresado_a() {
		return ha_apresado_a;
	}



	public void setHa_apresado_a(List<Ser> ha_apresado_a) {
		this.ha_apresado_a = ha_apresado_a;
	}



	public List<Ser> getHa_liberado_a() {
		return ha_liberado_a;
	}



	public void setHa_liberado_a(List<Ser> ha_liberado_a) {
		this.ha_liberado_a = ha_liberado_a;
	}



	public List<Ser> getHa_matado_a() {
		return ha_matado_a;
	}



	public void setHa_matado_a(List<Ser> ha_matado_a) {
		this.ha_matado_a = ha_matado_a;
	}



	public List<Ser> getTiene_localizado_a() {
		return tiene_localizado_a;
	}



	public void setTiene_localizado_a(List<Ser> tiene_localizado_a) {
		this.tiene_localizado_a = tiene_localizado_a;
	}



	public Ser getApresado_por() {
		return apresado_por;
	}



	public void setApresado_por(Ser apresado_por) {
		this.apresado_por = apresado_por;
	}



	public Ser getLiberado_por() {
		return liberado_por;
	}



	public void setLiberado_por(Ser liberador) {
		this.liberado_por = liberador;
		
//		// Lista con los que ha liberado anteriores.
//		List<Ser> liberadosPorLiberador = liberador.getHa_liberado_a();
//		
//		// Añado el nuevo liberado (esta instancia).
//		liberadosPorLiberador.add(this);
//		
//		// Se lo asigno.
//		liberador.setHa_liberado_a(liberadosPorLiberador);
	}



	public Ser getMatado_por() {
		return matado_por;
	}



	public void setMatado_por(Ser matado_por) {
		this.matado_por = matado_por;
	}



	public List<Objeto> getTiene() {
		return tiene;
	}



	public void setTiene(List<Objeto> tiene) {
		this.tiene = tiene;
	}



	public String getNombre() {
		return nombre;
	}
	
	public void addObjeto(Objeto objeto)
	{
		tiene.add(objeto);
	}
	
	public void quitarObjeto(Objeto objeto)
	{
		tiene.remove(objeto);
	}
	
	public void addLocalizado(Ser ser)
	{
		tiene_localizado_a.add(ser);
	}
	
	public void addVictima(Ser ser)
	{
		ha_matado_a.add(ser);
	}
	
	public void addLiberado(Ser ser)
	{
		ha_liberado_a.add(ser);
	}
	
	public void eliminarPrisionero(Ser ser)
	{
		ha_apresado_a.remove(ser);
	}
}
