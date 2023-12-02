package classes;

/**
 * @author Ivan Soler Parra
 *
 */
public class Plantacio {
	private String nomFinca;
	private int anyPlantacio;
	private LlistaTerrenys llista;
	
	public Plantacio(String nom, LlistaTerrenys llista, int any) {
		nomFinca = nom;
		this.llista = llista;
		anyPlantacio = any;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public LlistaTerrenys getLlista() {
		return llista;
	}

	public int getAnyPlantacio() {
		return anyPlantacio;
	}

	public void setAnyPlantacio(int anyPlantacio) {
		this.anyPlantacio = anyPlantacio;
	}
	
	public Plantacio copia() {
		Plantacio plantacio = new Plantacio(nomFinca, llista, anyPlantacio);
		return plantacio;
	}
	
	@Override
	public String toString() {
		return "Nom finca: " + this.nomFinca + ". Any plantacio: " + this.anyPlantacio + ". Terrenys:\n" + this.llista.toString();
	}
}
	
	
