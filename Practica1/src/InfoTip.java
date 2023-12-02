/**
 * Practica 1
 * @author Ivan Morillas Gomez, David De Antonio Manrique
 *
 */
public class InfoTip { 
	private String alies; //nom del usuari
	private String titol; //nom del titol
	private String tema; //nom del tema
	private Data data; //data de publicacio del tip 
	private int segons; //durada en segons
	private int visualitzacions = 0; //nombre de visualitzacions
	private int guardats = 0; //nombre de guardats
	private int likes = 0; //nombre de likes
	private static int proporcioBenValorat = 50; //Variable Estatica
	
	/**
	 * Metode constructor: valors de la informacio dels tips
	 * @param alies				- String amb el nom del usuari/creador del Tip
	 * @param titol				- String amb el titol del Tip
	 * @param tema				- String amb el tema del Tip 
	 * @param data				- Data amb la data de la publicacio del tip
	 * @param segons			- enter amb la durada en segons del Tip
	 * @param visualitzacions	- enter amb el nombre de visualitzacions del Tip
	 * @param guardats			- enter amb el nombre de guardats del Tip
	 * @param likes				- enter amb el nombre de likes del Tip
	 */
	public InfoTip(String alies, String titol, String tema, Data data, int segons, int visualitzacions, int guardats, int likes) {
		this.alies = alies;
		this.titol = titol;
		this.tema = tema;
		this.data = data;
		this.segons = segons;
		this.visualitzacions = visualitzacions;
		this.guardats = guardats;
		this.likes = likes;
	}
	
	// Getters
	
	/**
	 * Getter per l'alies
	 * 
	 * @return el nom de l'alies
	 */
	public String getAlies() {
		return alies;
	}
	
	/**
	 * Getter per el titol
	 * 
	 * @return el nom del titol
	 */
	public String getTitol() {
		return titol;
	}
	
	/**
	 * Getter per el tema
	 * 
	 * @return el nom del tema
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Getter per la data de la publicacio
	 * 
	 * @return la data
	 */
	public Data getData() {
		return data;
	}
	
	/**
	 * Getter per els segons de durada
	 * 
	 * @return el segons de durada
	 */
	public int getSegons() {
		return segons;
	}
	
	/**
	 * Getter per el nombre de visualitzacions
	 *  
	 * @return el nombre de visualitzacions
	 */
	public int getVisualitzacions() {
		return visualitzacions;
	}
	
	/**
	 * Getter per el nombre de guardats
	 * 
	 * @return el nombre de guardats
	 */
	public int getGuardats() {
		return guardats;
	}
	
	/**
	 * Getter per el nombre de likes
	 * 
	 * @return el nombre de likes
	 */
	public int getLikes() {
		return likes;
	}
	
	/**
	 * Getter per la proporcio per a que sigui ben valorat
	 * 
	 * @return la proporcio per a que sigui ben valorat
	 */
	public int getProporcioBenValorat() {
		return proporcioBenValorat;
	}
	
	//Setters
	
	/**
	 * Setter per canviar el tema
	 * 
	 * @param Tema - String que indica el nom del tema
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	//Metodes
	
	/**
	 * 
	 * @param x
	 * @return el nombre de visualitzacions modificat
	 */
	public int modificarVisualitzacions(int x) {
		return (this.visualitzacions + x);
	}
	
	/**
	 * 
	 * @param x
	 * @return el nombre de guardats modificat
	 */
	public int modificarGuardats(int x) {
		return (this.guardats + x);
	}
	
	/**
	 * 
	 * @param x
	 * @return el nombre de likes modificat
	 */
	public int modificarLikes(int x) {
		return (this.likes + x);
	}
	
	/**
	 * Metode per copiar un tip
	 * @return la copia d'un tip
	 */
	public InfoTip copiar() {
		InfoTip copia = new InfoTip (alies, titol, tema, data, segons, visualitzacions, guardats, likes);
		return copia;
	}
	
	/**
	 * Metode per obtenir la informacio del tip escrita
	 * @return un string amb la informacio escrita
	 */
	public String toString() {
		return ("InformacioTip ->\n Alies: "+alies+"\n Titol: "+titol+"\n Tema: "+tema+"\n Data: "+data+"\n Durada: "+segons+"\n Visualitzacions: "+visualitzacions+"\n Guardats: "+guardats+"\n Likes: "+likes+"\n");
	}
	
	/**
	 * Metode per saber la proporcio dels guardats respecte les visualitzacions
	 * @return la proporcio entre el nombre de guardats respecte el nombre de visualitzacions
	 */
	public double proporcioGuardatsVisualitzacions() {
		double proporcio;
		double num_guardats;
		double num_visualitzacions;
		
		num_guardats = this.guardats;
		num_visualitzacions = this.visualitzacions;
		
		if (num_visualitzacions == 0) {
			proporcio = -1;
		}else
			proporcio = (num_guardats/num_visualitzacions)*100;
	
		return proporcio;
	}
	
	/**
	 * Metode per saber si un tip es util
	 * @return si es util o no
	 */
	public boolean tipUtil() {
		if (guardats > likes) {
			return true;
		}else
			return false;
	}
	
	/**
	 * Metode per saber quin tip es el mes guardat
	 * @param altreTip 	- InfoTip amb el que es fa la comparacio
	 * @return si el tip s'ha guardat mes que el tip per referencia
	 */
	public boolean tipMesGuardats(InfoTip altreTip) {
		if (this.guardats > altreTip.guardats) {
			return true;
		}else
			return false;
	}
	
	/**
	 * Metode per saber quin tip te mes durada
	 * @param altreTip	- InfoTip amb el que es fa la comparacio
	 * @return una copia del tip amb mes durada o si son iguals, retorna null
	 */
	public InfoTip tipMesDurada(InfoTip altreTip) {
		if(this.segons == altreTip.segons) {
			return (null);
		}else if (this.segons > altreTip.segons) {
			return this.copiar();
		}else
			return altreTip.copiar();
	}
	
	/**
	 * Metode que rep per parametre la data del dia en que estem i ens calcula la mitja de visualitzacions 
	 * diaries (numero de visualitzacions/numero de dies que porta publicat el tip). 
	 * @param actual - La data actual
	 * @return -1 si la data que es rep per parametre es anterior a la de publicacio del tip, sino return 
	 * la mitjana de visualitzacions diaries
	 */
	public float visualitzacionsDiaries(Data actual) {
		
		int diaspasats = data.numDiesAData(actual);
		if (diaspasats == -1) {
			return -1;
		}	
		return visualitzacions/(float)diaspasats;
	}
	
	/**
	 * Metode per saber si un tip esta ben valorat
	 * @return si el tip esta ben valorat o no
	 */
	public boolean tipBenValorat() {
		double proporcio;
		double num_likes;
		double num_visualitzacions;
		
		num_likes = this.likes;
		num_visualitzacions = this.visualitzacions;
		
		proporcio = (num_likes/num_visualitzacions)*100;
		
		if (proporcio > proporcioBenValorat) {
			return true;
		}else
			return false;
	}
	
	/**
	 * Metode estatic per saber si un tip esta ben valorat cambiant la proporcio en un rang
	 * @param enter que conte el nou valor de la proporcio
	 */
	public static void canviBenValorat(int proporcio) {
		if (proporcio >= 40 && proporcio <= 100) {
			InfoTip.proporcioBenValorat= proporcio;
		}
	}

}
