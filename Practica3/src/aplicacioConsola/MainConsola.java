package aplicacioConsola;

import java.io.*;
import java.util.*;

import classes.*;

/**
 * @author Todos
 *
 */
public class MainConsola {

	static Scanner teclat = new Scanner(System.in);
	static File txt = new File("ficheros/Plantes.txt");
	static LlistaPlantacions llistaPlantacions = null;
	static LlistaPlantes llistaPlantes = new LlistaPlantes();
	static int anyActual = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Quin es l'any actual?");
		anyActual = teclat.nextInt();
		
		int opcio;
		boolean menu = true;
        do{
        	System.out.print("\n\n\n=-=-= MENU =-=-=\n  0. Sortir del programa."
        					 + "\n  1. Carregar les dades dels fitxers."
        					 + "\n  2. Llistar les dades de tots els tipus de terreny."
        					 + "\n  3. Llistar les dades de totes les plantacions."
        					 + "\n  4. Llistar les dades de les plantacions que tenen algun rodal d'un tipus de terreny."
        					 + "\n  5. Mostrar quantes unitats de cada espècie s'hi ha plantat."
        					 + "\n  6. Llistar les dades de totes les espècies."
        					 + "\n  7. Mostrar la quantitat de CO2 que permet absorbir a partir de l'espècie i l'edat."
        					 + "\n  8. Afegir una nova espècie de planta."
        					 + "\n  9. Esborrar les dades d'una plantació."
        					 + "\n  10. Modificar l'any de plantació d'una plantació."
        					 + "\n  11. Modificar les dades d'un rodal d'una plantació."
        					 + "\n  12. Modificar l'any en què ens trobem."
        					 + "\n  13. Mostrar la quantitat de CO2 que permet absorbir cada rodal d'una plantació en l'any actual."
        					 + "\n  14. Mostrar la quantitat de CO2 que permet absorbir el conjunt d'unitats plantades d'uana espècie en l'any actual."
        					 + "\nQuina opció vols? ");
        	
        	opcio = teclat.nextInt();
        	System.out.print("\n\n");
        	switch(opcio) {
        	case 0: System.out.println("Has sortit del programa");
        		menu = false;
        		break;
        	case 1: 
        		System.out.println(">>> MENÚ DE CARREGAR LES DADES DELS FITXERS <<<\n");
        		llistaPlantacions = llegirFitxers(llistaPlantes);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 2:
        		System.out.println(">>> MENÚ DE LLISTAR LES DADES DE TOTS ELS TIPUS DE TERRENY <<<\n");
        		generarProvesRandom(llistaPlantes, anyActual); //Lo he usado para crear datos aleatorios pero no va aqui
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 3:
        		System.out.println(">>> MENÚ DE LLISTAR LES DADES DE TOTES LES PLANTACIONS <<<\n");
        		System.out.println(llistaPlantacions.toString());
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 4:
        		System.out.println(">>> MENÚ DE LLISTAR LES DADES DE LES PLANTACIONS QUE TENEN ALGUN RODAL D'UN TIPUS DE TERRENY <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 5:
        		System.out.println(">>> MENÚ DE MOSTRAR MOSTRAR QUANTES UNITATS DE CADA ESPÈCIE S'HI HA PLANTAT <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 6:
        		System.out.println(">>> MENÚ DE LLISTAR LES DADES DE TOTES LES ESPÈCIES <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 7:
        		System.out.println(">>> MENÚ DE MOSTRAR LA QUANTITAT DE CO2 QUE PERMET ABSORBIR <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 8:
        		System.out.println(">>> MENÚ DE AFEGIR UNA NOVA ESPÈCIE DE PLANTA <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 9:
        		System.out.println(">>> MENÚ DE ESBORRAR LES DADES D'UNA PLANTACIÓ <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 10:
        		System.out.println(">>> MENÚ DE MODIFICAR L'ANY DE PLANTACIÓ D'UNA PLANTACIÓ <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 11:
        		System.out.println(">>> MENÚ DE MODIFICAR LES DADES D'UN RODAL D'UNA PLANTACIÓ <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 12:
        		System.out.println(">>> MENÚ DE MODIFICAR L'ANY EN QUÈ ENS TROBEM <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 13:
        		System.out.println(">>> MENÚ DE MOSTRAR LA QUANTITAT DE CO2 QUE PERMET ABSORBIR CADA RODAL D'UNA PLANTACIÓ EN L'ANY ACTUAL <<<\n");
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case 14:
        		System.out.println(">>> MENU DE MOSTRAR LA QUANTITAT DE CO2 QUE PERMET ABSORBIR EL CONJUNT D'UNITATS PLANTADES D'UNA ESPECIE EN L'ANY ACTUAL <<<\n");
        		System.out.println("\n<<< TORNANT AL MENU PRINCIPAL >>>");
        		break;
        	default:  
        		System.out.println("Aquesta opcio no existeix, torna a introduir la opcio.");
        		break;        		
        	}    	        	
        }while(menu);                 	
         teclat.close();
	}
	
	
	public static LlistaPlantacions llegirFitxers(LlistaPlantes llista) throws FileNotFoundException {
		LlistaPlantacions llistafinques = new LlistaPlantacions(50);
		Scanner lector = new Scanner(txt);
		lector.useDelimiter(";");
		String elementActual;
		
		System.out.println("El format de les plantes es: " + lector.nextLine());
		elementActual = lector.next();
		while(!elementActual.equalsIgnoreCase("Finques")) { //inici while per guardar llista plantes
			if(elementActual.equalsIgnoreCase("Arboria")) {
				String nom = lector.next();
					
				String[] temp2 = lector.next().split("-");
				int[] anys = new int[temp2.length];
				for(int i = 0; i<temp2.length; i++) {
					anys[i] = Integer.parseInt(temp2[i]);
				}
					
				temp2 = lector.next().split("-");
				float[] abs = new float[temp2.length];
				for(int i = 0; i<temp2.length; i++) {
					abs[i] = Float.parseFloat(temp2[i]);
				}

				Arboria temp = new Arboria(nom, anys, abs);
					
				llista.afegirPlanta(temp);
				lector.nextLine();
			} else if(elementActual.equalsIgnoreCase("Arbustiva")) {
				Arbustiva temp = new Arbustiva(lector.next(), lector.nextInt(), lector.nextInt());
				lector.nextLine();
				llista.afegirPlanta(temp);
			} else {
				System.out.println("error al llegir.");
				lector.nextLine();
			}
			elementActual = lector.next();
		} //fi while guardar llista plantes
		lector.nextLine();
		System.out.println("El format de les finques es: " + lector.nextLine());
		
		//lectura fitxer terrenys
		FileInputStream fis = null;
        ObjectInputStream entrada = null;
        LlistaTerrenys list;
        Plantacio temp;
        	
        try {

        	fis = new FileInputStream("ficheros/Terrenys.dat");
        	entrada = new ObjectInputStream(fis);
        	while(true) {
        		list = (LlistaTerrenys) entrada.readObject(); //es necessari el casting
        		temp = new Plantacio(lector.next(), list, lector.nextInt());
        		llistafinques.afegirPlantacio(temp);
        		
        	}
	    } catch (EOFException e) {
	        System.out.println("\nS'han llegit totes les dades del fitxer.\n");
	    } catch (FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println(e.getMessage());
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (fis != null) {
	                fis.close();
	            }
	            if (entrada != null) {
	                entrada.close();
	            }
	        } catch (IOException e) {
	                 System.out.println(e.getMessage());
	        }
	    } //fi lectura fitxer terrenys
	    
		lector.close();
		return llistafinques;
	}
	
	
	public static Plantacio generarRandom(LlistaPlantes llista, int anyActual) { //Para crear plantaciones random
		Plantacio resultat;
		Random rand = new Random();
		//Generar any aleatori
		int anymax = anyActual;
		System.out.println("Quin rang d'anys vols que hi hagi? ");
		int[] anys = new int[teclat.nextInt()];
		for(int i = anys.length-1; i>0; i--) {
			anys[i] = anymax--;
		}
		int anyPlantacio = anys[rand.nextInt(anys.length)];
		//Generar llistaTerrenys aleatoria amb les 5 plantes i el nombre de plantes per hra
		System.out.println("Quants terrenys vols que tingui la plantacio? (Maxim 10)");
		int nTerrenys = teclat.nextInt();
		while(nTerrenys > 10 || nTerrenys < 0) {
			nTerrenys = teclat.nextInt();
		}
		String[] tipusTerrenysA = {"Calcari", "Argila"};
		String[] tipusTerrenysB = {"Solana", "Obaga"};
		String nomTerreny = "";
		LlistaTerrenys rodals = new LlistaTerrenys();
		for(int i = 0; i<nTerrenys; i++) {
			nomTerreny = tipusTerrenysA[rand.nextInt(2)].concat(tipusTerrenysB[rand.nextInt(2)]);
			Terreny nou = new Terreny(nomTerreny, rand.nextFloat()*25);
			while(nou.getNplantes() < 5) {
				Planta temp = llista.getLlista()[rand.nextInt(llista.getNplantes())];
				if(!nou.contePlanta(temp.getNomPlanta())) {
					nou.afegirPlanta(temp, rand.nextInt(250)+50);
				}
			}
			rodals.afegirTerreny(nou);
		}
		//Demanemm un nom per a la nova finca
		teclat.nextLine();
		System.out.println("Finalment, quin nom vols que tingui la finca?");
		resultat = new Plantacio(teclat.nextLine(), rodals, anyPlantacio);
		return resultat;
	}
	
	
	public static void guardarDades(LlistaPlantacions llista) throws FileNotFoundException {
		
		String dadesPlantes = "Tipus planta;Nom planta;Any inici absorcio(Arbories);Valor absorcio;Any fi absorcio(Arbustives);\r\n"
				+ "Arboria;Acer pseudoplatanus;5-8;245-390;\r\n"
				+ "Arboria;Betula alba;4-7-12;190-324-420;\r\n"
				+ "Arboria;Fraxinus excelsior;5-8-15;230-300-390;\r\n"
				+ "Arboria;Pinus nigra;5-10;190-270;\r\n"
				+ "Arboria;Pinus sylvestris;5-10;180-250;\r\n"
				+ "Arboria;Populus nigra;4-7-14;190-340-430;\r\n"
				+ "Arboria;Quercus ilex;4-6-10;210.28-374.19-401.94;\r\n"
				+ "Arbustiva;Corylus Avellana;110;16;\r\n"
				+ "Arbustiva;Spartium junceum;85;19;\r\n"
				+ "Arbustiva;Erica multiflora;50;11;\r\n"
				+ "Arbustiva;Genista scorpius;100;13;\r\n"
				+ "Finques;\r\n"
				+ "Finca;Any plantacio;\r\n";
		Scanner lector = new Scanner(txt);
		lector.useDelimiter(";");
		String element = lector.next();
		while(!element.equalsIgnoreCase("\r\nFinques")) {
			element = lector.next();
		}
		lector.nextLine();
		
		//funcion para guardar datos en el fichero .txt
		try {
			FileWriter output = new FileWriter("ficheros/Plantes.txt");
			output.write(dadesPlantes);
			for(int i = 0; i < llista.getnPlantacions(); i++) {
				output.write(llista.getLlista()[i].getNomFinca() + ";" + llista.getLlista()[i].getAnyPlantacio() + ";\r\n");
			}
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//funcion para guardar datos en el fichero .dat
		FileOutputStream fos = null;
		ObjectOutputStream salida = null;
		        
		try {
			fos = new FileOutputStream("ficheros/Terrenys.dat");
		    salida = new ObjectOutputStream(fos);
		    for(int i = 0; i < llista.getnPlantacions(); i++) {
		    	salida.writeObject(llista.getLlista()[i].getLlista());
		    }
		} catch (FileNotFoundException e) {
		    System.out.println(e.getMessage());                                                              
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		} finally {
		    try {
		    	if(fos!=null) fos.close();
		        if(salida!=null) salida.close();
		    } catch (IOException e) {
		        System.out.println(e.getMessage());
		    }
		}
		System.out.println("Dades guardades correctament.");
		lector.close();
	}
	
	public static void generarProvesRandom(LlistaPlantes llista, int any) throws FileNotFoundException { //Para crear juego de pruebas
		LlistaPlantacions llistaDades = new LlistaPlantacions(50);
		System.out.println("Quantes plantacions vols? (Maxim 50)");
		int lim = teclat.nextInt();
		while(lim > 50 || lim < 0) {
			lim = teclat.nextInt();
		}
		for(int i = 0; i<lim; i++) {
			llistaDades.afegirPlantacio(generarRandom(llista, any));
		}
		guardarDades(llistaDades);
	}
}