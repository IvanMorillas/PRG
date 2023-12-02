package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

/**
 * 
 * @author Ivan Morillas Gomez i David De Antonio Manrique
 *
 */

public class UsaLlistaEstacionsVE {
	static Scanner teclat = new Scanner(System.in);
	
	/**
	 * Metode per iniciar la ejecucio del programa
	 * @param args Parametre obligatori del main
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Indica el número de línies a llegir del fitxer (màxim 418)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		char opcio;
		String replace = ".";
		String newreplace = ",";
		String[] dataset = llegirLiniesFitxer(numLinies);
		
		LlistaEstacionsRecarrega llista = new LlistaEstacionsRecarrega(LlistaEstacionsRecarrega.agafarDades(dataset));
		
		for (int i = 0; i < dataset.length; i++) {
			String newllista = dataset[i].replace(replace, newreplace);
			System.out.println("Linia " + (i + 1) + " conté: " + newllista);
		}
		
        do{
        	System.out.print("\n\n\n=-=-= MENÚ =-=-=\n  0. Sortir del programa."
        					 + "\n  1. Eliminar el conjunt d'estacions de recàrrega d'una estació."
        					 + "\n  2. Trobar i mostrar la instància de la primera estació que hi ha a la llista ubicada a Lleida."
        					 + "\n  3. Mostrar el número d'estacions d'un tipus de velocitat."
        					 + "\n  4. Mostrar la instància de l'estació que té més places de capacitat."
        					 + "\n  5. Mostrar la instància de l'estació més propera a la nostra posició."
        					 + "\n  6. Mostrar les dades de les estacions que es troben properes a la nostra posició(radi de 30km)."
        					 + "\n  7. Mostrar les dades de les estacions que es troben properes a la nostra posició(radi de 50km)."
        					 + "\n  8. Mostrar dades de la estació més propera amb més places de capacitat."
        					 + "\n  9. Mostrar el conjunt d'estacions de la llista."
        					 + "\nQuina opció vols? ");
        	
        	opcio = teclat.nextLine().charAt(0);
        	System.out.print("\n\n");
        	switch(opcio) {
        	case '0': System.out.println("Has sortit del programa");
        		break;
        	case '1': 
        		System.out.println(">>> MENÚ D'ELIMINAR UN CONJUNT D'UNA ESTACIÓ CONCRETA <<<\n");
        		eliminarEstacio(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '2':
        		System.out.println(">>> MENÚ DE TROBAR I MOSTRAR LA PRIMERA ESTACIÓ DE LA LLISTA UBICADA A LLEIDA <<<\n");
        		trobarEstacioPoblacio(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '3':
        		System.out.println(">>> MENÚ DE MOSTRAR EL NÚMERO D'ESTACIONS D'UN TIPUS DE VELOCITAT CONCRET <<<\n");
        		numEstacionsVelocitat(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '4':
        		System.out.println(">>> MENÚ DE MOSTRAR L'ESTACIÓ QUE TÉ MÉS PLACES DE CAPACITAT <<<\n");
        		estacioMesCapacitat(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '5':
        		System.out.println(">>> MENÚ DE MOSTRAR L'ESTACIÓ MÉS PROPERA A LA NOSTRA POSICIÓ <<<\n");
        		estacioMesPropera(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '6':
        		System.out.println(">>> MENÚ DE MOSTRAR LES ESTACIONS MÉS PROPERES A LA NOSTRA POSICIÓ(30KM) <<<\n");
        		estacionsMesProperes30km(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '7':
        		System.out.println(">>> MENÚ DE MOSTRAR LES ESTACIONS MÉS PROPOERES A LA NOSTRA POSICIÓ(50KM) <<<\n");
        		estacionsMesProperes50km(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '8':
        		System.out.println(">>> MENÚ DE MOSTRAR L'ESTACIÓ MES PROPERA(50KM) QUE TÉ MÉS PLACES DE CAPACITAT <<<\n");
        		estacioMesProperaMesCapacitat(llista);
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	case '9':
        		System.out.println(">>> MENÚ DE MOSTRAR LES ESTACIONS DE LA LLISTA <<<\n");
        		mostrarLlistaEstacions();
        		System.out.println("\n<<< TORNANT AL MENÚ PRINCIPAL >>>");
        		break;
        	default:  
        		System.out.println("Aquesta opció no existeix, torna a introduir la opció.");
        		break;        		
        	}    	        	
        }while(opcio != '0');        
         System.out.println("EXIT");
                 	
         teclat.close();   		
	}

    /**
     *    
     * @param nLinies, numero de linies que haura de llegir del fitxer
     * @return Retorna les estacions llegides del fitxer
     * @throws FileNotFoundException
     */
	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 418)
			nLinies = 418;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("EstacionsRecarregaReduit.csv"));

		String capcalera = f.nextLine();
		System.out.println("\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}	
	
    /**
     * Metode que pregunta quina poblacio vol eliminar i truca al metode que elimina les estacions
     * i mostra per consola
     * @param llista, llista amb el que estem tractant durant la practica
     */
	private static void eliminarEstacio(LlistaEstacionsRecarrega llista) {
		String poblacio;
		System.out.print("\nIntrodueix la població que vols eliminar: ");
		poblacio = teclat.nextLine();
		EstacioRecarregaVE[] llistaPoblacio = llista.mostrarEstacioPoblacio(poblacio);
		for (int i = 0; i < llistaPoblacio.length; i++) {
			System.out.println("Estació " + (i + 1) + ": " + llistaPoblacio[i]);	
		}
		llista.eliminarEstacioPoblacio(poblacio);
		
		System.out.println("\n"+llista);

    	System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
    	teclat.nextLine();
	}

	/**
	 * Metode que troba la primera estacio de la llista ubicada a Lleida i Barcelona, truca al metode 
	 * i les mostra per consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void trobarEstacioPoblacio(LlistaEstacionsRecarrega llista) {
		String nomPoblacio = "Lleida";
		String nomPoblacio2 = "Barcelona";

		EstacioRecarregaVE estacio = llista.primeraEstacioPoblacio(nomPoblacio);
		EstacioRecarregaVE estacio2 = llista.primeraEstacioPoblacio(nomPoblacio2);
		if (estacio == null) {
			System.out.println("No hi ha cap estació a Lleida");
		}
		else {
			System.out.println("\n" + estacio.toString()); 
		}

		if (estacio2 == null) {
			System.out.println("No hi ha cap estació a Barcelona");
		}
		else {
			System.out.println("\n" + estacio2.toString()); 
		}

	    System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
	    teclat.nextLine();
	}

	/**
	 * Metode que calcula quantes estacions tenen la velocitat introduida per teclat, truca al metode
	 * i el resultat el mostra per pantalla
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void numEstacionsVelocitat(LlistaEstacionsRecarrega llista) {
		String velocitat;
		int numEst = 0;
		System.out.print("\nIntrodueix la velocitat que vols comptar: ");
		velocitat = teclat.nextLine();
    	numEst = llista.numEstacionsVelocitat(velocitat);
    	System.out.println("El número de velocitats es de: "+numEst);
	}

	/**
	 * Metode que troba l'estació amb més capacitat, truca al metode i el mostra per consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void estacioMesCapacitat(LlistaEstacionsRecarrega llista) {
		System.out.println("La estació amb més capacitat és:\n"+ llista.estacioMesCapacitat());
	   	System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
    	teclat.nextLine();
	}

	/**
	 * Metode que troba l'estació més propera a la ubicacio intrduida per teclat
	 * truca al metode i el mostra per consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void estacioMesPropera(LlistaEstacionsRecarrega llista) {
		float lon, lat;
		EstacioRecarregaVE estacio;
		System.out.print("\nIntrodueix la latitud: ");
		lat = teclat.nextFloat();
		System.out.print("\nIntrodueix la longitud: ");
		lon = teclat.nextFloat();
	    teclat.nextLine();

		estacio = llista.estacioMesPropera(lat, lon);
		System.out.print(estacio);

	    System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
	    teclat.nextLine();
	}

	/**
	 * Metode que troba les estacions més properes dins del rang introduit per teclat
	 * truca al metode i els mostra per la consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void estacionsMesProperes30km(LlistaEstacionsRecarrega llista) {
		float lon, lat;
		int dist;
		
		System.out.print("\nIntrodueix la latitud: ");
		lat = teclat.nextFloat();
		System.out.print("\nIntrodueix la longitud: ");
		lon = teclat.nextFloat();
		System.out.print("\nIntrodueix la distancia: ");
		dist = teclat.nextInt();
	    teclat.nextLine();

		EstacioRecarregaVE[] estacio = llista.estacionsProperes(lat, lon, dist);
		for (int i = 0; i < estacio.length; i++) {
			System.out.println("Estació " + (i + 1) + ": " + estacio[i]);		}
		
	    System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
	    teclat.nextLine();
	}

	/**
	 * Metode que troba les estacions més properes dins del rang introduit per teclat, 
	 * truca al metode i els mostra per la consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void estacionsMesProperes50km(LlistaEstacionsRecarrega llista) {
		float lon, lat;
		int dist;
		
		System.out.print("\nIntrodueix la latitud: ");
		lat = teclat.nextFloat();
		System.out.print("\nIntrodueix la longitud: ");
		lon = teclat.nextFloat();
		System.out.print("\nIntrodueix la distancia: ");
		dist = teclat.nextInt();
	    teclat.nextLine();

		EstacioRecarregaVE[] estacio = llista.estacionsProperes(lat, lon, dist);
		for (int i = 0; i < estacio.length; i++) {
			System.out.println("Estació " + (i + 1) + ": " + estacio[i]);		
		}
		
	    System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
	    teclat.nextLine();
	}

	/**
	 * Metode que troba l'estació mes propera amb més capacitat, truca als metodes 
	 * i el mostra per la consola
	 * @param llista, llista amb el que estem tractant durant la practica
	 */
	private static void estacioMesProperaMesCapacitat(LlistaEstacionsRecarrega llista) {
		float lon, lat;
		int dist;

		System.out.print("\nIntrodueix la latitud: ");
		lat = teclat.nextFloat();
		System.out.print("\nIntrodueix la longitud: ");
		lon = teclat.nextFloat();
		System.out.print("\nIntrodueix la distancia: ");
		dist = teclat.nextInt();
	    teclat.nextLine();
		
		LlistaEstacionsRecarrega estacio = new LlistaEstacionsRecarrega (llista.estacionsProperes(lat, lon, dist));
		
		System.out.println("La estació més propera amb més capacitat és:\n"+ estacio.estacioMesCapacitat());
	   	System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
    	teclat.nextLine();
	}

	/**
	 * Metode que mostra totes les estacions de la llista
	 * @throws FileNotFoundException
	 */
	private static void mostrarLlistaEstacions() throws FileNotFoundException {
		int numLinies = 418;
		String[] dataset = llegirLiniesFitxer(numLinies);
		for (int i = 0; i < dataset.length; i++) {
			System.out.println("Estació " + (i + 1) + ": " + dataset[i]);
		}
    	System.out.println("\n->->-> Clica al ENTER per tornar al menú.");
    	teclat.nextLine();
	}
}