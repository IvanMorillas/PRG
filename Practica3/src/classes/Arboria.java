package classes;

/**
 * @author Ivan Morillas
 *
 */
public class Arboria extends Planta{
	private static final long serialVersionUID = 1L;
	
	protected float[] absco2;
	protected int[] anualitats;
	
	public Arboria(String nomPlanta, int[] anualitats, float[] absco2) {
		super(nomPlanta);
		this.anualitats = anualitats;
		this.absco2 = absco2;
	}
	
	public float[] getAbsco2() {
		return absco2;
	}
	
	public int[] getAnualitats() {
		return anualitats;
	}
	
	public void setAbsco2(float[] valors) {
		absco2 = valors;
	}
	
	public void setAnualitats(int[] anys) {
		anualitats = anys;
	}
	
	public float getAbsorcio(int edatPlanta) {
		float absorcio = 0;
		for(int i = 0; i<anualitats.length; i++) {
			if(edatPlanta < anualitats[0]) {
				return 0;
			} else if(edatPlanta > anualitats[i]) {
				absorcio = absco2[i];
			}
		}
		return absorcio;
	}
	
	@Override
	public String toString() {
		return "Nom planta: " + super.nomPlanta;
	}
}