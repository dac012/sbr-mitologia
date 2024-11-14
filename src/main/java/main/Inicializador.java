package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import conceptos.capacidades.Capacidad;
import conceptos.capacidades.Corte;
import conceptos.capacidades.Invisibilidad;
import conceptos.capacidades.Petrificar;
import conceptos.capacidades.Reflectante;
import conceptos.capacidades.Vuelo;
import conceptos.estados.Apresado;
import conceptos.estados.Estado;
import conceptos.estados.Libre;
import conceptos.estados.Vivo;
import conceptos.objetos.Objeto;
import conceptos.objetos.ObjetoMitologico;
import conceptos.objetos.ObjetoNormal;
import conceptos.seres.Criatura;
import conceptos.seres.CriaturaMitologica;
import conceptos.seres.Dios;
import conceptos.seres.DiosMayor;
import conceptos.seres.DiosMenor;
import conceptos.seres.Heroe;
import conceptos.seres.Humano;
import conceptos.seres.Mortal;
import conceptos.seres.Ser;

public class Inicializador {
	
	public static List<Object> inicializar() {
		List<Object> instancias = new LinkedList<>();
		
		// 1. Seres que aparecen.
		List<Ser> seres = new LinkedList<>();
		// 2. Objetos.
    	List<Objeto> objetos = new LinkedList<>();
    	// 3. Estados.
    	List<Estado> estados = new LinkedList<>();
    	// 4. Capacidades.
    	List<Capacidad> capacidades = new LinkedList<>();
		
    	Heroe perseo = new Heroe("Perseo");
    	DiosMayor zeus = new DiosMayor("Zeus");
    	CriaturaMitologica ceto = new CriaturaMitologica("Ceto");
    	DiosMayor poseidon = new DiosMayor("Poseidon");
    	Mortal andromeda = new Humano("Andromeda");
    	Mortal casiopea = new Humano("Casiopea");
    	DiosMayor hades = new DiosMayor("Hades");
    	Mortal danae = new Humano("Danae");
    	Criatura medusa = new CriaturaMitologica("Medusa");
    	Dios grayas = new DiosMenor("Grayas");
    	Dios ninfas = new DiosMenor("Ninfas");
    	Dios hermes = new DiosMayor("Hermes");
    	Dios hefesto = new DiosMayor("Hefesto");
    	Dios atenea = new DiosMayor("Atenea");
    	
    	Collections.addAll(seres, perseo, zeus, ceto, poseidon, andromeda, casiopea, hades,
    			danae, medusa, grayas, ninfas, hermes, hefesto, atenea);
    	
    	// Objetos
    	ObjetoMitologico cascoHades = new ObjetoMitologico("Casco de Hades");
    	ObjetoMitologico zurron = new ObjetoMitologico("Zurron Magico");
    	ObjetoMitologico sandaliasAladas = new ObjetoMitologico("Sandalias Aladas");
    	Objeto hoz = new ObjetoNormal("Hoz de Acero");
    	Objeto espadaIndestructible = new ObjetoMitologico("Espada Indestructible");
    	Objeto escudoBronce = new ObjetoMitologico("Escudo de Bronce");
    	Objeto dienteGrayas = new ObjetoNormal("Diente Grayas");
    	Objeto ojoGrayas = new ObjetoNormal("Ojo Grayas");
    	
    	Collections.addAll(objetos, cascoHades, zurron, sandaliasAladas, hoz, espadaIndestructible,
    			escudoBronce, dienteGrayas, ojoGrayas);
    	
    	// Capacidades.
    	Capacidad cascoHadesInvi = new Invisibilidad(cascoHades);
    	Capacidad petrificarMedusa = new Petrificar(medusa);
    	Capacidad corteHoz = new Corte(hoz);
    	Capacidad corteEspada = new Corte(espadaIndestructible);
    	Capacidad reflectanteEscudo = new Reflectante(escudoBronce);
    	Capacidad volarSandalias = new Vuelo(sandaliasAladas);
    	
    	Collections.addAll(capacidades, cascoHadesInvi, petrificarMedusa, corteHoz, corteEspada,
    			reflectanteEscudo, volarSandalias);
    	
    	// Estados
    	seres.stream().forEach(ser -> {
    		if(ser != ceto) estados.add(new Libre(ser));
    		estados.add(new Vivo(ser));
    	});
    	
    	Apresado apresCeto = new Apresado(ceto);
        
    	Collections.addAll(estados, apresCeto);
    	
    	// Relaciones entre conceptos.
    	
    	// Perseo hijo de Zeus y Danae.
    	perseo.addPadre(zeus);
    	zeus.addHijo(perseo);
    	perseo.addPadre(danae);
    	danae.addHijo(perseo);
    	
    	// Pertenencias.
    	grayas.addObjeto(ojoGrayas);
    	grayas.addObjeto(dienteGrayas);
    	ninfas.addObjeto(zurron);
    	ninfas.addObjeto(sandaliasAladas);
    	hades.addObjeto(cascoHades);
    	hermes.addObjeto(hoz);
    	hefesto.addObjeto(espadaIndestructible);
    	atenea.addObjeto(escudoBronce);
    	
    	seres.stream().forEach(ser -> instancias.add(ser));
    	objetos.stream().forEach(objeto -> instancias.add(objeto));
    	estados.stream().forEach(estado -> instancias.add(estado));
    	capacidades.stream().forEach(capacidad -> instancias.add(capacidad));
    	
    	return instancias;
	}
	
	public static Object getInstanciaNombre(String nombre, List<Object> instancias)
	{
		for(Object instancia: instancias)
		{
			if(instancia instanceof Ser)
			{
				if(((Ser) instancia).getNombre().equals(nombre))
					return instancia;
			}
			else if(instancia instanceof Objeto)
			{
				if(((Objeto) instancia).getNombre().equals(nombre))
					return instancia;
			}
		}
		return null;
	}
}
