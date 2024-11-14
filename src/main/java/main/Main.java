package main;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import conceptos.objetos.Objeto;
import conceptos.objetos.ObjetoMitologico;
import conceptos.objetos.ObjetoNormal;
import conceptos.seres.CriaturaMitologica;
import conceptos.seres.Dios;
import conceptos.seres.DiosMayor;
import conceptos.seres.Heroe;
import conceptos.seres.Humano;
import conceptos.seres.Mortal;
import conceptos.seres.Semidios;
import conceptos.seres.Ser;
// hola
public class Main {

	public static void main(String[] args) 
	{
		KieServices ks = KieServices.Factory.get();
    	KieContainer kContainer = ks.getKieClasspathContainer();
    	
    	KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");
    	
    	/*
    	 * Cargar los hechos iniciales.
    	 */
    	List<Object> inicio = Inicializador.inicializar(); 
    	
    	Mortal perseo = (Mortal) Inicializador.getInstanciaNombre("Perseo", inicio);
    	Dios atenea = (Dios) Inicializador.getInstanciaNombre("Atenea", inicio);
    	Dios hades = (Dios) Inicializador.getInstanciaNombre("Hades", inicio);
    	Dios hermes = (Dios) Inicializador.getInstanciaNombre("Hermes", inicio);
    	
    	perseo.addDiosConFavor(atenea);
    	atenea.addMortalFavorecido(perseo);
    	
    	perseo.addDiosConFavor(hades);
    	hades.addMortalFavorecido(perseo);
    	
    	perseo.addDiosConFavor(hermes);
    	hermes.addMortalFavorecido(perseo);
    	
    	inicio.stream().forEach(hecho -> kSession.insert(hecho));
    	kSession.fireAllRules();
	}
}
