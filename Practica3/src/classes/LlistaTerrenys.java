package classes;

import java.io.Serializable;
/**
 * @author David de Antonio Manrique
 *
 */
public class LlistaTerrenys implements Serializable { //falta metodo que devuelva un terreno dado su nombre/tipo
	private static final long serialVersionUID = 1L;
	
	private Terreny[] llista;
	private int nTerrenys;
	
	public LlistaTerrenys() {
		nTerrenys = 0;
		llista = new Terreny[10];
	}
	
	public int getNterrenys() {
		return nTerrenys;
	}
	
	public Terreny[] getLlista() {
		return llista;
	}
	
	public void afegirTerreny(Terreny element) {
		if(nTerrenys == (llista.length)-1) {
			return;
		} else {
			llista[nTerrenys++] = element;
		}
	}
	
	@Override
	public String toString() {
		String dades = "";
		for(int i = 0; i<nTerrenys; i++) {
			dades += llista[i].toString() + "\n\n";
		}
		return dades;
	}
}
