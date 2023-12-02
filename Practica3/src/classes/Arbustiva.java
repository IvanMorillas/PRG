package classes;

/**
 * @author Stefan Tabirca
 *
 */
public class Arbustiva extends Planta {
	private static final long serialVersionUID = 1L;
	
	protected int absco2, edatFin;
	
	public Arbustiva(String nomPlanta, int absco2, int edatFin) {
		super(nomPlanta);
		this.absco2 = absco2;
		this.edatFin = edatFin;
	}
	
	public int getAbsco2() {
		return absco2;
	}
	
	public int getEdatFin() {
		return edatFin;
	}
	
	public void setAbsco2(int num) {
		absco2 = num;
	}
	
	public void setEdatFin(int num) {
		edatFin = num;
	}
	
	public float getAbsorcio(int edatPlanta) {
		if(edatPlanta <= edatFin && edatPlanta >= 5) {
			return absco2;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Nom planta: " + super.nomPlanta;
	}
}
