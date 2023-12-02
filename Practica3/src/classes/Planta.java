package classes;

import java.io.Serializable;
/**
 * @author Stefan Tabirca
 * @author Ivan Morillas
 *
 */
public abstract class Planta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String nomPlanta;
	
	public Planta(String planta) {
		this.nomPlanta = planta;
	}
	
	public String getNomPlanta() {
		return nomPlanta;
	}
	
	public void setNomPlanta(String nom) {
		this.nomPlanta = nom;
	}
	
	public abstract float getAbsorcio(int edatPlanta);
	
	@Override
	public abstract String toString();
}
