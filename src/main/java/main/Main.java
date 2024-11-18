package main;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.AgendaGroup;

import conceptos.capacidades.Petrificar;
import conceptos.objetos.Objeto;
import conceptos.objetos.ObjetoMitologico;
import conceptos.objetos.ObjetoNormal;
import conceptos.relaciones.Accion;
import conceptos.relaciones.Apresa;
import conceptos.relaciones.EnojadoCon;
import conceptos.relaciones.Favorece;
import conceptos.relaciones.Libera;
import conceptos.relaciones.Localiza;
import conceptos.relaciones.Padre;
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
import conceptos.seres.TipoCriatura;

public class Main {

	public static void main(String[] args) 
	{
		KieServices ks = KieServices.Factory.get();
    	KieContainer kContainer = ks.getKieClasspathContainer();
    	
    	KieSession kSession = kContainer.newKieSession("ksession-rules-dsi2");
    	
    	/*
    	 * Cargar los hechos iniciales.
    	 */
    	Inicializador ini = new Inicializador();
    	
    	List<Object> inicio = ini.getInstancias();
    	
    	DiosMayor poseidon = (DiosMayor)ini.get("Poseidon");
    	DiosMayor atenea = (DiosMayor)ini.get("Atenea");
    	DiosMayor hermes = (DiosMayor)ini.get("Hermes");
    	DiosMayor hades = (DiosMayor)ini.get("Hades");
    	Mortal casiopea = (Mortal)ini.get("Casiopea");
    	Heroe perseo = (Heroe)ini.get("Perseo");
    	Mortal andromeda = (Mortal)ini.get("Andromeda");
    	
    	inicio.add(new EnojadoCon(poseidon, casiopea));
    	inicio.add(new Favorece(atenea, perseo));
    	inicio.add(new Favorece(hades, perseo));
    	inicio.add(new Favorece(hermes, perseo));
    	
    	//Libera liberaPerseoAndro = new Libera(perseo, andromeda);
    	Object objetivo = ini.getObjetivo();
    	if(objetivo == null) {
    		System.out.println("Objetivo no válido!");
    		return;
    	}
    	insertarObjetivo(kSession, objetivo);
    	
    	inicio.stream().forEach(hecho -> kSession.insert(hecho));
    	
    	AgendaGroup info = kSession.getAgenda().getAgendaGroup("informacion");
    	AgendaGroup general = kSession.getAgenda().getAgendaGroup("generales");
    	
    	System.out.println("\n\t\tInicialmente...");
    	info.setFocus();
    	kSession.fireAllRules();
    	
    	System.out.println("\n\t\tY en un momento dado...");
    	general.setFocus();
    	kSession.fireAllRules();
    	kSession.dispose();
	}
	
	public static void avisarObjetivoCumplido(Object objetivo)
	{
		System.out.println("\n\tSE HA CUMPLIDO EL OBJETIVO: " + objetivo.toString());		
	}
	
	public static void insertarObjetivo(KieSession kSession, Object objetivo)
	{
		kSession.addEventListener(new DefaultAgendaEventListener() {
			@Override
			public void afterMatchFired(AfterMatchFiredEvent event) {
				if(kSession.getObjects().stream()
					.anyMatch(obj -> obj.equals(objetivo)))
				{
					avisarObjetivoCumplido(objetivo);
					kSession.halt();
				}
			}
		});
	}
}
