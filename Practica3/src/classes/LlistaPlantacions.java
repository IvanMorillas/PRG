package classes;

import Errors.*;

/**
 * @author Iván Soler Parra
 *
 */
public class LlistaPlantacions {
	private Plantacio[] llista;
	private int nPlantacions;
	
	public LlistaPlantacions(int num) {
		nPlantacions = num;
		llista = new Plantacio[num];
	}
	
	public int getnPlantacions() {
		return nPlantacions;
	}

	public Plantacio[] getLlista() {
		return llista;
	}
	
	public Plantacio getPlantacio(String nomPlantacio) {
		for(int i = 0; i<nPlantacions; i++) {
			if(llista[i].getNomFinca().equalsIgnoreCase(nomPlantacio)) {
				return llista[i];
			}
		}
		return null;
	}
	
	public void afegirPlantacio(Plantacio element) {
		if(nPlantacions == llista.length || conteFinca(element.getNomFinca())) {
			return;
		} else {
			llista[nPlantacions++] = element;
		}
	}
	
	public boolean conteFinca(String nom) {
		for(int i = 0; i<this.nPlantacions; i++) {
			if(llista[i].getNomFinca().equalsIgnoreCase(nom)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String dades = "";
		for(int i = 0; i<nPlantacions; i++) {
			dades += llista[i].toString();
		}
		return dades;
	}


	public LlistaPlantacions dadesTotesPlantacions() throws LlistaPlena{
		LlistaPlantacions llistaRetorn = new LlistaPlantacions(nPlantacions);
		for (int i = 0; i < nPlantacions; i++){
			llistaRetorn.afegirPlantacio(llista[i]);
		}
		return llistaRetorn;
	}
	
	public LlistaPlantacions dadesPlantacionsTerreny(String nomTerreny) throws LlistaPlena{
		LlistaPlantacions llistaRetorn = new LlistaPlantacions(nPlantacions);
		int m = 0;
		for (int i = 0; i < nPlantacions; i++) {
			if(llista[i].getNomFinca().equalsIgnoreCase(nomTerreny)) {
				llistaRetorn.afegirPlantacio(llista[i]);
			}
		}
		LlistaPlantacions finals = new LlistaPlantacions(llistaRetorn.getnPlantacions());
		for (int i = 0; i < m; i++) {
			finals.afegirPlantacio(llistaRetorn.getLlista()[i]);
		}
		return finals;
	}
	
	public int unitatsEspecie (String nomPlantacio) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		int numEspecies = 0;
		for (int i = 0; i < nPlantacions; i++) {
			//hacer
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nomPlantacio);
		
		return numEspecies;
	
	}
	
	public int quantitatCO2 (String nomEspecie, int any) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		int quantitat = 0;
		for (int i = 0; i < nPlantacions; i++) {
			//hacer
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nomEspecie);
		
		return quantitat;
	}

	public boolean esborrarDadesPlantacions (String nomPlantacio) {
		boolean existeixPlantacio = false;
		if (nPlantacions > 0) {
			int i;
			for(i = 0; i < nPlantacions - 1; i++) {
				if (llista[i].getNomFinca().equalsIgnoreCase(nomPlantacio)) {
					existeixPlantacio = true;
					Plantacio p;
					for (int m = i + 1; m < nPlantacions - 1; m++) {
						p = llista[m];
						llista[m-1] = p;
					}
					nPlantacions -= 1;
				}
			}
			if(llista[i].getNomFinca().equalsIgnoreCase(nomPlantacio)) {
				nPlantacions -= 1;
				existeixPlantacio = true;
			}
		}
		return existeixPlantacio;
	}
	
	public void modificarAnyPlantacio(String nom, int any) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		for (int i = 0; i < nPlantacions; i++) {
			if (llista[i].getNomFinca().equals(nom)) {
				llista[i].setAnyPlantacio(any);
				existeixPlantacio = true;
				break;
			}
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nom);
	}
/*	
	public void modificarRodal (String nom, int rodal) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		for (int i = 0; i < nPlantacions; i++) {
			if (llista[i].getNomFinca().equals(nom)) {
				llista[i].setnRodals(rodal);;
				existeixPlantacio = true;
				break;
			}
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nom);
	}
*/	
	public void modificarAny(int any) {
		//hacer
	}
	
	public int quantitatCO2Rodal (String nomPlantacio, int any) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		int quantitat = 0;
		for (int i = 0; i < nPlantacions; i++) {
			//hacer
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nomPlantacio);
		
		return quantitat;
	}

	public int quantitatCO2Conjunt (String nomPlantacio, int any) throws NoExisteixPlantacio{
		boolean existeixPlantacio = false;
		int quantitat = 0;
		for (int i = 0; i < nPlantacions; i++) {
			//hacer
		}
		if(!existeixPlantacio) throw new NoExisteixPlantacio(nomPlantacio);
		
		return quantitat;
	}

	
}
