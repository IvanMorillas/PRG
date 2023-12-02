package classes;

import java.io.Serializable;
/**
 * @author David de Antonio Manrique
 *
 */
public class Terreny implements Serializable { //falta metodo para acceder una planta especifica de las 5 que contiene el terreno
	private static final long serialVersionUID = 1L;
	
	private String tipusTerreny;
	private int[] nPlantesHra;
	private Planta[] llista;
	private int nPlantes, nPlantesperhra;
	private float superficie;
	
	public Terreny(String nomTerreny, float superficie) {
		this.tipusTerreny = nomTerreny;
		this.llista = new Planta[5];
		this.nPlantes = 0;
		this.nPlantesHra = new int[5];
		this.nPlantesperhra = 0;
		this.superficie = superficie;
	}
	
	public String getTipusTerreny() {
		return tipusTerreny;
	}
	
	public float getSuperficie() {
		return superficie;
	}
	
	public int getNplantes() {
		return nPlantes;
	}
	
	
	public void setTipusTerreny(String nom) {
		tipusTerreny = nom;
	}
	
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}	
	public void afegirPlanta(Planta p, int plantHra) { //faltaria otro metodo similar que modifique una de las plantas segun el nombre y le cambie tambien el nPlantesHra
		if(!(nPlantes >= llista.length)) {
			llista[nPlantes++] = p;
		} 
		if(!(nPlantesperhra >= nPlantesHra.length)) {
			nPlantesHra[nPlantesperhra++] = plantHra;
		}
	}
	
	public boolean contePlanta(String nom) {
		for(int i = 0; i<this.nPlantes; i++) {
			if(llista[i].getNomPlanta().equalsIgnoreCase(nom)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String dades = "Tipus terreny: " + this.getTipusTerreny() + ". Superficie: " + this.superficie + "Ha\nContinguts:\n";
		for(int i = 0; i<llista.length; i++) {
			dades += "Planta=> " + llista[i].toString() + ", nPlantes per Ha: " + nPlantesHra[i] + "\n";
		}
		
		return dades;
	}
}