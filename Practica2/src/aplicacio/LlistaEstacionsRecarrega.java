package aplicacio;
import dades.*;

/**
 * 
 * @author Ivan Morillas Gomez i David De Antonio Manrique
 *
 */

public class LlistaEstacionsRecarrega {
	private int midaLlista;
	private EstacioRecarregaVE[] llista;
	private int distancia;
	
	/**
	 * Constructor de la classe LlistaEstacionsRecarrega
	 * @param llista, llista de les estacions
	 */
	public LlistaEstacionsRecarrega(EstacioRecarregaVE[] llista) {

		this.midaLlista = llista.length;
		this.llista = llista;
		this.distancia = 30;
	}
	
	/**
	 * Metode que canvia el tipus de com estan guardades les estacions per al que
	 * necessitem per poder treballar amb les dades
	 * @param dataset, taula on hi ha guardat les estacions llegides del fitxer en tipus String
	 * @return retorna la taula pero en tipus EstacioRecarregaVE[]
	 */
	public static EstacioRecarregaVE[] agafarDades(String[] dataset) {
		EstacioRecarregaVE[] novaLlista = new EstacioRecarregaVE[dataset.length];
		int pos = 0;			
						
		while(pos < dataset.length) {
			// Separem els valors separats entre comas
			String[] auxString  = dataset[pos].split(",");
			//Guardar valors en els atributs respectius
			novaLlista[pos] = new EstacioRecarregaVE(auxString[0], auxString[1], Float.parseFloat(auxString[2]), Float.parseFloat(auxString[3]), auxString[4], auxString[5], Integer.parseInt(auxString[6]));
			pos++;
		}	
		return novaLlista;
	}
	
	/**
	 * Metode que permet mostrar l'atribut en altres classes
	 * @return Retorna l'atribut midaLlista
	 */
	public int GetMidaLlista() {
		return midaLlista;
	}
	
	/**
	 * Metode que permet mostrar l'atribut en altres classes
	 * @return Retorna l'atribut llista
	 */
	public EstacioRecarregaVE[] GetLlista(){
		return llista;
	}
	
	/**
	 * Metode que permet mostrar l'atribut en altres classes
	 * @return Retorna l'atribut distancia
	 */
	public int GetDistancia() {
		return distancia;
	}

	/**
	 * Metode que permet canviar l'atribut en altres classes
	 * @param midaLlista Nou valor per l'atribut actual
	 */
	public void SetMidaLlista(int midaLlista) {
		this.midaLlista = midaLlista;
	}

	/**
	 * Metode que permet canviar l'atribut en altres classes
	 * @param llista Nou valor per l'atribut actual
	 */
	public void SetLlista(EstacioRecarregaVE[] llista) {
		this.llista = llista;
	}

	/**
	 * Metode que permet canviar l'atribut en altres classes
	 * @param distancia Nou valor per l'atribut actual
	 */
	public void SetDistancia (int distancia) {
		this.distancia = distancia;
	}
	
	/**
	 * Metode que retorna una cadena que representa l'objecte
	 */
	public String toString() {
		String aux = "Total de estacions: " + GetMidaLlista();
		for(int i = 0; i < midaLlista; i++) 
			aux = aux.concat("\n" + llista[i].toString());
		return aux;
	}
	
	/**
	 * Metode que copia l'instancia amb la que s'esta tractant
	 * @return Retorna una copia de l'instancia
	 */
	public LlistaEstacionsRecarrega copia() {
		return new LlistaEstacionsRecarrega(llista);
	}
	
	/**
	 * Metode que afegeix una nova estació
	 * @param novaEstacio, nova estació a afegir
	 */
	public void afegirEstacio(EstacioRecarregaVE novaEstacio) {		
		if (midaLlista < llista.length) {
			llista[midaLlista] = novaEstacio.copia();
			midaLlista++;
		}
	}
	
	/**
	 * Metode que elimina les estacions d'un poble que es passa per paràmetre
	 * @param població, nom de la poblacio que es busca 
	 */
	public void eliminarEstacioPoblacio(String poblacio) {
		int i = 0;
		while(i < midaLlista) {
			if(llista[i].esTrobaEnAquestMunicipi(poblacio)) {
				for(int j = i; j < midaLlista-1;j++) {
					llista[j] = llista[j+1];
				}
				midaLlista--;
			}
			else {
				i++;
			}
		}
	}
	
	/**
	 * Metode que mostra totes les estacions d'un poble que es passa per paràmetre
	 * @param poblacio, nom de la poblacio que es busca
	 * @return retorna una llista de les estacions de la població
	 */
	public EstacioRecarregaVE[] mostrarEstacioPoblacio(String poblacio) {
		EstacioRecarregaVE[] llistaPoblacio;
		int numPoblacio = 0, pos = 0;
		
		for (int i = 0; i < midaLlista; i++) {
			if (llista[i].esTrobaEnAquestMunicipi(poblacio)) {
				numPoblacio++;
			}
		}
		llistaPoblacio = new EstacioRecarregaVE[numPoblacio];
		for (int i = 0; i < midaLlista; i++) {
			if (llista[i].esTrobaEnAquestMunicipi(poblacio)) {
				llistaPoblacio[pos] = llista[i];
				pos++;
			}
		}
		return llistaPoblacio;
	}
	
	/**
	 * Metode que mostra la primera estació de la llista d'una provincia que es passa per paràmetre
	 * @param provincia, nom de la provincia que es busca
	 * @return retorna la primera estacio de la llista a partir de la provincia buscada
	 */
	public EstacioRecarregaVE primeraEstacioPoblacio(String provincia) {
		int i = 0;
		boolean trobat = false;
		EstacioRecarregaVE estacio = llista[0];
		while (i < midaLlista && trobat == false) {
			if (llista[i].esTrobaEnAquestaProvincia(provincia)) {
				trobat = true;
				estacio = llista[i];
			}
			i++;
		}
		if (trobat == true) {
			return estacio;
		}
		else
			return null;
	}

	/**
	 * Metode que mostra el número d'estacions d'una velocitat que es passa per parametre
	 * @param velocitat, nom de la velocitat a buscar
	 * @return retorna el número d'estacions que hi ha 
	 */
	public int numEstacionsVelocitat(String velocitat) {
		int numEst = 0;
		
		for (int i = 0; i < llista.length; i++) {
			if (llista[i].teAquestTipusRecarrega(velocitat)) {
				numEst++;
			}
		}
		return numEst;
	}
	
	/**
	 * Metode que mostra l'estació amb més capacitat
	 * @return retorna l'estació amb mes capacitat
	 */
	public EstacioRecarregaVE estacioMesCapacitat() {
		EstacioRecarregaVE estacio = llista[0];

		for (int i  = 0; i < midaLlista; i++) {
			if (llista[i].getNumPlaces() > estacio.getNumPlaces()) {
				estacio = llista[i];
			}
		}
		return estacio;
	}
	
	/**
	 * Metode per a canviar la distancia que es passa per parametre
	 * @param dist, distacia per a canviar
	 * @return retorna la distancia cambiada
	 */
	public int cambiarDistancia (int dist) {
		distancia = dist;
		return distancia;
	}
	
	/**
	 * Metode que mostra l'estació mes propera a la teva ubicació
	 * @param lat latitud de la teva ubicació
	 * @param lon longitud de la teva ubicació
	 * @return retorna l'estacio mes propera a la teva ubicació
	 */
	public EstacioRecarregaVE estacioMesPropera(float lat, float lon) {
		EstacioRecarregaVE estacioPropera;
		double dist = llista[0].distanciaA(lat, lon);
	    int pos = 0, i = 0;
		for (i = 1; i < midaLlista; i++) {
			if (llista[i].distanciaA(lat, lon) < dist ) {
				dist = llista[i].distanciaA(lat, lon);
				pos = i;
			}
		}	
		estacioPropera = llista[pos];
		
		return estacioPropera;
	}
	
	/**
	 * Metode que mostra una llista d'estacions properes en un rang determinat per parametre
	 * @param lat latitud de la teva ubicació
	 * @param lon longitud de la teva ubicació
	 * @param maxdist rang de distancia
	 * @return retorna les estacions properes dins del rang assingat
	 */
	public EstacioRecarregaVE[] estacionsProperes(float lat, float lon, int maxdist) {
		EstacioRecarregaVE[] llistaEstacions;
		int numEst = 0, pos = 0;
		
		for (int i = 0; i < midaLlista; i++) {
			if (llista[i].distanciaA(lat, lon) < maxdist) {
				numEst++;
			}
		}

		llistaEstacions = new EstacioRecarregaVE[numEst];
		for (int i = 0; i < midaLlista; i++) {
			if (llista[i].distanciaA(lat, lon) < maxdist) {
				llistaEstacions[pos] = llista[i];
				pos++;
			}
		}
		return llistaEstacions;
	}
}