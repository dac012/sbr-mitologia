package main;

import java.util.Collections;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import conceptos.capacidades.Petrificar;
import conceptos.objetos.Objeto;
import conceptos.objetos.ObjetoMitologico;
import conceptos.objetos.ObjetoNormal;
import conceptos.relaciones.EnojadoCon;
import conceptos.relaciones.Favorece;
import conceptos.relaciones.Libera;
import conceptos.relaciones.Posee;
import conceptos.seres.Criatura;
import conceptos.seres.CriaturaMitologica;
import conceptos.seres.Dios;
import conceptos.seres.DiosMayor;
import conceptos.seres.Heroe;
import conceptos.seres.Humano;
import conceptos.seres.Mortal;
import conceptos.seres.Semidios;
import conceptos.seres.Ser;

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
    	
    	Mortal casiopea = (Mortal)Inicializador.getInstanciaNombre("Casiopea", inicio);
    	Dios poseidon = (Dios)Inicializador.getInstanciaNombre("Poseidon", inicio);    	
    	Mortal perseo = (Mortal) Inicializador.getInstanciaNombre("Perseo", inicio);
    	Dios atenea = (Dios) Inicializador.getInstanciaNombre("Atenea", inicio);
    	Dios hades = (Dios) Inicializador.getInstanciaNombre("Hades", inicio);
    	Dios hermes = (Dios) Inicializador.getInstanciaNombre("Hermes", inicio);
    	
    	EnojadoCon poseiCasio = new EnojadoCon(poseidon, casiopea);
    	Favorece ateneaPerseo = new Favorece(atenea, perseo);
    	Favorece hadesPerseo = new Favorece(hades, perseo);
    	Favorece hermesPerseo = new Favorece(hermes, perseo);
    	
    	Collections.addAll(inicio, poseiCasio, ateneaPerseo, hadesPerseo, hermesPerseo);   
    	
    	/*
    	 * Prueba
    	 */
    	Criatura ceto = (Criatura)Inicializador.getInstanciaNombre("Ceto", inicio);
    	Objeto escoba = new ObjetoNormal("Escobita de Ceto");
    	Posee poseeCetoEscoba = new Posee(ceto, escoba);
    	Collections.addAll(inicio, escoba, poseeCetoEscoba);
    	
    	inicio.stream().forEach(hecho -> kSession.insert(hecho));
    	kSession.fireAllRules();
	}
}
