package Errors;

public class NoExisteixPlantacio extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoExisteixPlantacio(String nomPlantacio) {
		super("No hi ha cap plantació amb el nom "+nomPlantacio+".");
	}
}
