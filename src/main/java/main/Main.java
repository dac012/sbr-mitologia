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
import conceptos.relaciones.EnojadoCon;
import conceptos.relaciones.Favorece;
import conceptos.relaciones.Libera;
import conceptos.relaciones.Localiza;
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
    	
    	KieSession kSession = kContainer.newKieSession("ksession-rules-dsi2");
    	
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
    	
    	/*
    	 * Inserción objetivo.
    	 */
    	Ser andromeda = (Ser)Inicializador.getInstanciaNombre("Andromeda", inicio);
    	Libera apresaPerseo = new Libera(perseo, andromeda);
    	insertarObjetivo(kSession, apresaPerseo);
    	
    	inicio.stream().forEach(hecho -> kSession.insert(hecho));
    	AgendaGroup informacion = kSession.getAgenda().getAgendaGroup("informacion");
//    	AgendaGroup historia = kSession.getAgenda().getAgendaGroup("historia");
    	AgendaGroup generales = kSession.getAgenda().getAgendaGroup("generales");
//    	
    	informacion.setFocus();
    	System.out.println("\nInicialmente...\n");
    	kSession.fireAllRules();
//    	
//    	System.out.println("\nY es por ello que...\n");
//    	informacion.setFocus();
//    	historia.setFocus();
    	generales.setFocus();
    	System.out.println("\nEs por esto que...\n");
    	kSession.fireUntilHalt();
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
