package main;

public class Hecho {

	
	String tipohecho;
	String hecho;
	
	public Hecho(String tipohecho, String hecho) {
		super();
		this.tipohecho = tipohecho;
		this.hecho = hecho;
	}
	
	
	public String getTipohecho() {
		return tipohecho;
	}
	public void setTipohecho(String tipohecho) {
		this.tipohecho = tipohecho;
	}
	public String getHecho() {
		return hecho;
	}
	public void setHecho(String hecho) {
		this.hecho = hecho;
	}
}
