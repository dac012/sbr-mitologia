package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import conceptos.capacidades.Capacidad;
import conceptos.capacidades.Contenedor;
import conceptos.capacidades.Domar;
import conceptos.capacidades.Letal;
import conceptos.capacidades.Invisibilidad;
import conceptos.capacidades.Petrificar;
import conceptos.capacidades.Reflectante;
import conceptos.capacidades.Vuelo;
import conceptos.objetos.Objeto;
import conceptos.objetos.ObjetoMitologico;
import conceptos.objetos.ObjetoNormal;
import conceptos.relaciones.Apresa;
import conceptos.relaciones.EnojadoCon;
import conceptos.relaciones.Favorece;
import conceptos.relaciones.Libera;
import conceptos.relaciones.Localiza;
import conceptos.relaciones.Mata;
import conceptos.relaciones.Padre;
import conceptos.relaciones.Posee;
import conceptos.relaciones.Relacion;
import conceptos.seres.Criatura;
import conceptos.seres.CriaturaMitologica;
import conceptos.seres.CriaturaNormal;
import conceptos.seres.Dios;
import conceptos.seres.DiosMayor;
import conceptos.seres.DiosMenor;
import conceptos.seres.Heroe;
import conceptos.seres.Humano;
import conceptos.seres.Mortal;
import conceptos.seres.Semidios;
import conceptos.seres.Ser;
import conceptos.seres.TipoCriatura;

public class Inicializador {
	
	List<Object> instancias = null;
	List<Ser> seres = null;
	List<Objeto> objetos = null;
	List<Relacion> relaciones = null;
	List<Capacidad> capacidades = null;
	Dictionary<String, Integer> diccionario_hechos = leerDiccionarioReglas();
	String string_objetivo = "NO_OBJETIVO";
	Object hecho_objetivo;
	
	public Inicializador(String fichero_relato) {
		instancias = new LinkedList<>();
		
		// 1. Seres que aparecen.
		seres = new LinkedList<>();
		// 2. Objetos.
    	objetos = new LinkedList<>();
    	// 3. Relaciones.
    	relaciones = new LinkedList<>();
    	// 4. Capacidades.
    	capacidades = new LinkedList<>();
		
    	int tipo_hecho = -1;
		try {
			File myObj = new File("Conocimiento_Inicial.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		    	String linea = myReader.nextLine();
		        tipo_hecho = leerHecho(linea);
		        if(tipo_hecho== 0) {
		        	string_objetivo = linea.replace("OBJETIVO ", "");
		        	tipo_hecho = leerHecho(string_objetivo);
		        	introducirHecho(tipo_hecho, string_objetivo, true);
		        }
		        else {
		        	introducirHecho(tipo_hecho, linea, false);
		        }
		    }
		    myReader.close();
		} 	catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		tipo_hecho = -1;
		try {
			File myObj = new File(fichero_relato);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		    	String linea = myReader.nextLine();
		        tipo_hecho = leerHecho(linea);
		        if(tipo_hecho== 0) {
		        	string_objetivo = linea.replace("OBJETIVO ", "");
		        	tipo_hecho = leerHecho(string_objetivo);
		        	introducirHecho(tipo_hecho, string_objetivo, true);
		        }
		        else {
		        	introducirHecho(tipo_hecho, linea, false);
		        }
		    }
		    myReader.close();
		} 	catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		
    	/*Heroe perseo = new Heroe("Perseo");
    	DiosMayor zeus = new DiosMayor("Zeus");
    	CriaturaMitologica ceto = new CriaturaMitologica("Ceto", TipoCriatura.MARINA);
    	DiosMayor poseidon = new DiosMayor("Poseidon");
    	Mortal andromeda = new Humano("Andromeda");
    	Mortal casiopea = new Humano("Casiopea");
    	DiosMayor hades = new DiosMayor("Hades");
    	Mortal danae = new Humano("Danae");
    	Criatura medusa = new CriaturaMitologica("Medusa", TipoCriatura.TERRESTRE);
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
    	Capacidad corteHoz = new Letal(hoz);
    	Capacidad corteEspada = new Letal(espadaIndestructible);
    	Capacidad reflectanteEscudo = new Reflectante(escudoBronce);
    	Capacidad volarSandalias = new Vuelo(sandaliasAladas);
    	
    	Collections.addAll(capacidades, cascoHadesInvi, petrificarMedusa, corteHoz, corteEspada,
    			reflectanteEscudo, volarSandalias);
    	    	
    	// Relaciones entre conceptos.
    	Apresa poseidonCeto = new Apresa(poseidon, ceto);
        Padre zeusPerseo = new Padre(zeus, perseo);
        Padre danaePerseo = new Padre(danae, perseo);
        Posee grayasOjo = new Posee(grayas, ojoGrayas);
        Posee grayasDiente = new Posee(grayas, dienteGrayas);
        Posee ninfasZurron = new Posee(ninfas, zurron);
        Posee ninfasSandalias = new Posee(ninfas, sandaliasAladas);
        Posee hermesHoz = new Posee(hermes, hoz);
        Posee hadesCasco = new Posee(hades, cascoHades);
        Posee hefestoEspada = new Posee(hefesto, espadaIndestructible);
        Posee ateneaEscudo = new Posee(atenea, escudoBronce);
    	Padre casiopeaMadreAndrom = new Padre(casiopea, andromeda);
        Localiza ateneaLocGrayas = new Localiza(atenea, grayas);
        Localiza hadesLocGrayas = new Localiza(hades, grayas);
        Localiza hermesLocGrayas = new Localiza(hermes, grayas);
    	Localiza grayasLocNinfas = new Localiza(grayas, ninfas);
        
    	Collections.addAll(relaciones, poseidonCeto, zeusPerseo, danaePerseo, grayasOjo, grayasDiente, ninfasZurron, ninfasSandalias, hermesHoz, hadesCasco,
    			hefestoEspada, ateneaEscudo, casiopeaMadreAndrom, ateneaLocGrayas, hadesLocGrayas, hermesLocGrayas,
    			grayasLocNinfas);
    	*/
		
    	seres.stream().forEach(ser -> instancias.add(ser));
    	objetos.stream().forEach(objeto -> instancias.add(objeto));
    	relaciones.stream().forEach(relacion -> instancias.add(relacion));
    	capacidades.stream().forEach(capacidad -> instancias.add(capacidad));
	}
		
	public List<Object> getInstancias()
	{
		return new LinkedList<>(instancias);
	}
	
	public Object get(String nombre)
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
	
	public Object getObjetivo() {
		return hecho_objetivo;
	}
	
	public Dictionary<String, Integer> leerDiccionarioReglas() {
		Dictionary diccionario_hechos = new Hashtable();
		
		try {
			File myObj = new File("Diccionario_Hechos.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		    	String linea = myReader.nextLine();
		    	String[] linea_dividida = linea.split(" ");
		       diccionario_hechos.put(linea_dividida[0], Integer.parseInt(linea_dividida[1]));
		    }
		    myReader.close();
		} 	catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		System.out.println(diccionario_hechos.size()+" Tipos de reglas");
		System.out.println(diccionario_hechos);
		return diccionario_hechos;
	}
	
	public int leerHecho(String linea) {
		String[] linea_dividida = linea.split(" ");
		int codigo_hecho = 0;
		int num_codigos = 0;
		if(linea_dividida[0].contains("OBJETIVO")) {
			return 0;
		}
		if(linea_dividida.length>3) {
			return -1;
		}
		for(int i=0;i<linea_dividida.length;i++) {
			if(((Hashtable) diccionario_hechos).containsKey(linea_dividida[i])) {
				num_codigos++;
				codigo_hecho = diccionario_hechos.get(linea_dividida[i]);
			}
		}
		if(num_codigos>1) {
			return -2;
		}
		if(num_codigos==0) {
			return -3;
		}
		return codigo_hecho;
	}
	
	public int introducirHecho(int tipo_hecho, String linea, boolean esObjetivo) {
		String[] linea_dividida = linea.split(" ");
		//System.out.println("Se va a introducir un hecho tipo "+tipo_hecho+": "+linea);
		switch (tipo_hecho) {
		 	case -3:	//ERROR: Hecho con demasiadas palabras clave
				System.out.println("ERROR: Hecho con demasiadas palabras clave, sera ignorado: "+linea);
				break;
			case -2:	//ERROR: Hecho sin ninguna palabra clave
				System.out.println("ERROR: Hecho sin ninguna palabra clave, sera ignorado: "+linea);
				break;
			case -1:	//ERROR: Hecho con demasiados argumentos
				System.out.println("ERROR: Hecho con demasiados argumentos, sera ignorado: "+linea);
				break;
			case 0:	//HECHO OBJETIVO
				string_objetivo = linea.replace("OBJETIVO ", "");
				
		        System.out.println("Hecho objetivo: "+string_objetivo);
				break;
			case 1:	//DiosMayor
				DiosMayor diosmayor = new DiosMayor(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)diosmayor;
				}
				else {
					seres.add(diosmayor);
					instancias.add(diosmayor);
				}
				
				break;
				
			case 2:	//DiosMenor
				DiosMenor diosmenor = new DiosMenor(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)diosmenor;
				}
				else {
					seres.add(diosmenor);
					instancias.add(diosmenor);
				}
				
				break;
		
			case 3:	//Heroe
				Heroe heroe = new Heroe(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)heroe;
				}
				else {
					seres.add(heroe);
					instancias.add(heroe);
				}
				
				break;
			
			case 4:	//Semidios
				Semidios semidios = new Semidios(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)semidios;
				}
				else {
					seres.add(semidios);
					instancias.add(semidios);
				}
				
				break;
			
			case 5:	//Humano
				Humano humano = new Humano(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)humano;
				}
				else {
					seres.add(humano);
					instancias.add(humano);
				}
				
				break;
			
			case 6:	//Criatura_normal
				//TipoCriatura tipocriatura = (TipoCriatura) get(linea_dividida[2]);
				CriaturaNormal criaturanormal = new CriaturaNormal(linea_dividida[1], TipoCriatura.TERRESTRE);
				if(esObjetivo) {
					hecho_objetivo = (Object)criaturanormal;
				}
				else {
					seres.add(criaturanormal);
					instancias.add(criaturanormal);
				}
				
				break;
			
			case 7:	//Criatura_mitologica
				CriaturaMitologica criaturamitologica = new CriaturaMitologica(linea_dividida[1], TipoCriatura.TERRESTRE);
				if(esObjetivo) {
					hecho_objetivo = (Object)criaturamitologica;
				}
				else {
					seres.add(criaturamitologica);
					instancias.add(criaturamitologica);
				}
				
				
				break;
			
			case 8:	//Objeto_normal
				ObjetoNormal objetonormal = new ObjetoNormal(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)objetonormal;
				}
				else {
					objetos.add(objetonormal);
					instancias.add(objetonormal);
				}
				
				break;
			
			case 9:	//Objeto_mitologico
				ObjetoMitologico objetomitologico = new ObjetoMitologico(linea_dividida[1]);
				if(esObjetivo) {
					hecho_objetivo = (Object)objetomitologico;
				}
				else {
					objetos.add(objetomitologico);
					instancias.add(objetomitologico);
				}
				
				break;
			
			case 10:	//Capacidad_contenedor
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Contenedor contenedor = new Contenedor(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)contenedor;
					}
					else {
						capacidades.add(contenedor);
						instancias.add(contenedor);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Contenedor contenedor = new Contenedor(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)contenedor;
					}
					else {
						capacidades.add(contenedor);
						instancias.add(contenedor);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD CONTENEDOR, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 11:	//Capacidad_letal
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Letal letal = new Letal(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)letal;
					}
					else {
						capacidades.add(letal);
						instancias.add(letal);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Letal letal = new Letal(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)letal;
					}
					else {
						capacidades.add(letal);
						instancias.add(letal);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD LETAL, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 12:	//Capacidad_domar
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Domar domar = new Domar(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)domar;
					}
					else {
						capacidades.add(domar);
						instancias.add(domar);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Domar domar = new Domar(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)domar;
					}
					else {
						capacidades.add(domar);
						instancias.add(domar);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD DOMAR, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 13:	//Capacidad_invisibilidad
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Invisibilidad invisibilidad = new Invisibilidad(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)invisibilidad;
					}
					else {
						capacidades.add(invisibilidad);
						instancias.add(invisibilidad);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Invisibilidad invisibilidad = new Invisibilidad(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)invisibilidad;
					}
					else {
						capacidades.add(invisibilidad);
						instancias.add(invisibilidad);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD INVISIBILIDAD, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 14:	//Capacidad_petrificar
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Petrificar petrificar = new Petrificar(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)petrificar;
					}
					else {
						capacidades.add(petrificar);
						instancias.add(petrificar);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Petrificar petrificar = new Petrificar(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)petrificar;
					}
					else {
						capacidades.add(petrificar);
						instancias.add(petrificar);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD PETRIFICAR, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 15:	//Capacidad_reflectante
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Reflectante reflectante = new Reflectante(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)reflectante;
					}
					else {
						capacidades.add(reflectante);
						instancias.add(reflectante);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Reflectante reflectante = new Reflectante(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)reflectante;
					}
					else {
						capacidades.add(reflectante);
						instancias.add(reflectante);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD REFLECTANTE, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 16:	//Capacidad_vuelo
				if(get(linea_dividida[1]) instanceof Ser) {
					Ser recibidor = (Ser)get(linea_dividida[1]);
					Vuelo vuelo = new Vuelo(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)vuelo;
					}
					else {
						capacidades.add(vuelo);
						instancias.add(vuelo);
					}
					
				}
				else if (get(linea_dividida[1]) instanceof Objeto) {
					Objeto recibidor = (Objeto)get(linea_dividida[1]);
					Vuelo vuelo = new Vuelo(recibidor);
					if(esObjetivo) {
						hecho_objetivo = (Object)vuelo;
					}
					else {
						capacidades.add(vuelo);
						instancias.add(vuelo);
					}
					
				}
				else {System.out.println("ERROR AL INTRODUCIR CAPACIDAD VUELO, EL OBJETIVO NO ES NI UN SER NI UN OBJETO");}
				break;
				
			case 17:	//Ofrece_favor / Favor
				Dios emisor_favor = (Dios)get(linea_dividida[0]);
				Mortal receptor_favor = (Mortal)get(linea_dividida[2]);
				Favorece favorece = new Favorece(emisor_favor, receptor_favor);
				if(esObjetivo) {
					hecho_objetivo = (Object)favorece;
				}
				else {
					relaciones.add(favorece);
					instancias.add(favorece);
				}
				
				break;
				
			case 18:	//Tiene_enojo_de / Enojo
				Dios emisor_enojo = (Dios)get(linea_dividida[0]);
				Mortal receptor_enojo = (Mortal)get(linea_dividida[2]);
				EnojadoCon enojadocon = new EnojadoCon(emisor_enojo, receptor_enojo);
				if(esObjetivo) {
					hecho_objetivo = (Object)enojadocon;
				}
				else {
					relaciones.add(enojadocon);
					instancias.add(enojadocon);
				}
				
				break;
				
			case 19:	//Posee_objeto
				Ser poseedor = (Ser)get(linea_dividida[0]);
				Objeto poseido = (Objeto)get(linea_dividida[2]);
				Posee posee = new Posee(poseedor, poseido);
				if(esObjetivo) {
					hecho_objetivo = (Object)posee;
				}
				else {
					relaciones.add(posee);
					instancias.add(posee);
				}
				
				break;
				
			case 20:	//Es_hijo_de / Padre
				Ser sujeto_padre = (Ser)get(linea_dividida[0]);
				Ser sujeto_hijo = (Ser)get(linea_dividida[2]);
				Padre padre = new Padre(sujeto_padre, sujeto_hijo);
				if(esObjetivo) {
					hecho_objetivo = (Object)padre;
				}
				else {
					relaciones.add(padre);
					instancias.add(padre);
				}
				
				break;
				
			case 21:	//Tiene_localizado_a / Localiza
				Ser sujeto_localizador = (Ser)get(linea_dividida[0]);
				Ser sujeto_localizado = (Ser)get(linea_dividida[2]);
				Localiza localiza = new Localiza(sujeto_localizador, sujeto_localizado);
				if(esObjetivo) {
					hecho_objetivo = (Object)localiza;
				}
				else {
					relaciones.add(localiza);
					instancias.add(localiza);
				}
				
				break;
				
			case 22:	//Ha_matado_a / Mata
				Ser sujeto_asesino = (Ser)get(linea_dividida[0]);
				Ser sujeto_muerto = (Ser)get(linea_dividida[2]);
				Mata mata = new Mata(sujeto_asesino, sujeto_muerto);
				if(esObjetivo) {
					hecho_objetivo = (Object)mata;
				}
				else {
					relaciones.add(mata);
					instancias.add(mata);
				}
				
				break;
				
			case 23:	//Ha_liberado_a / Libera
				Ser sujeto_liberador = (Ser)get(linea_dividida[0]);
				Ser sujeto_liberado = (Ser)get(linea_dividida[2]);
				Libera libera = new Libera(sujeto_liberador, sujeto_liberado);
				if(esObjetivo) {
					hecho_objetivo = (Object)libera;
				}
				else {
					relaciones.add(libera);
					instancias.add(libera);
				}
				
				break;
				
			case 24:	//Ha_apresado_a / Apresa
				Ser sujeto_apresador = (Ser)get(linea_dividida[0]);
				Ser sujeto_apresado = (Ser)get(linea_dividida[2]);
				Apresa apresa = new Apresa(sujeto_apresador, sujeto_apresado);
				if(esObjetivo) {
					hecho_objetivo = (Object)apresa;
				}
				else {
					relaciones.add(apresa);
					instancias.add(apresa);
				}
				
				break;
			case 25:	//TO-DO: TIPOS DE CRIATURAS
				if(get(linea_dividida[1]) instanceof Criatura) {
					((Criatura)get(linea_dividida[1])).setTipoCriatura(TipoCriatura.TERRESTRE);
				}
				
				break;
			case 26:
				if(get(linea_dividida[1]) instanceof Criatura) {
					((Criatura)get(linea_dividida[1])).setTipoCriatura(TipoCriatura.MARINA);
				}
				break;
			default:
				System.out.println("Hecho no válido encontrado, será omitido");
				break;
		}
		return 0;
	}
	
}
