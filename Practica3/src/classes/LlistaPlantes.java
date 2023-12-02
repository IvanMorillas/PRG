package classes;

/**
 * @author Stefan Tabirca
 *
 */
public class LlistaPlantes {
	private Planta[] llista;
	private int nPlantes;
	
	public LlistaPlantes() {
		this.llista = new Planta[11];
		this.nPlantes = 0;
	}
	
	public int getNplantes() {
		return nPlantes;
	}
	
	public Planta[] getLlista() {
		return llista;
	}
	
	public void afegirPlanta(Planta element) {
		if(nPlantes == llista.length) {
			return;
		} else {
			llista[nPlantes++] = element;
		}
	}
	
	public Planta getPlanta(String nomPlanta) {
		for(int i = 0; i<llista.length; i++) {
			if(nomPlanta.equalsIgnoreCase(llista[i].getNomPlanta())) {
				return llista[i];
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String dades = "";
		
		for(int i = 0; i<nPlantes; i++) {
			dades += llista[i].toString() + "\n";
		}
		
		return dades;
	}
}