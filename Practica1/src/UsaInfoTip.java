public class UsaInfoTip {

	public static void main(String[] args) {
		
		//Llista dels tips
		InfoTip tip1 = new InfoTip("Alies01", "Importar un projecte a Eclipse", "Laboratori 01", new Data (10,9,2021), 120, 87, 35, 24);
		InfoTip tip2 = new InfoTip("Alies02", "Exportar un projecte d'Eclipse", "Laboratori 02", new Data (10,9,2021), 40, 15, 5, 0);
		InfoTip tip3 = new InfoTip("Alies01", "Primers passos amb el debug", "Laboratori 03", new Data (24,9,2021), 185, 0, 0, 0);
		
		//Tips afegits extres
		InfoTip tip4 = new InfoTip("Alies03", "Prova 1", "Laboratori 04", new Data (25,9,2021), 88, 34, 9, 22);	
		InfoTip tip5 = new InfoTip("Alies04", "Prova 2", "Laboratori 05", new Data (26,9,2021), 0, 0, 0, 0);	
		InfoTip tip6 = tip1.copiar();
		
		//Mostrar per pantalla els atributs dels tips amb toString
		System.out.println(tip1);
		System.out.println(tip2);
		System.out.println(tip3);
		System.out.println(tip4);
		System.out.println(tip5);
		System.out.println(tip6);
		
		//METODES
		
		metodeSetter(tip6);
		
		metodeGetter(tip6);
		
		metodeModificarVisualitzacions(tip1, tip2, tip3, tip4, tip5, tip6, 10);
		
		metodeModificarGuardats(tip1, tip2, tip3, tip4, tip5, tip6, 15);
		
		metodeModificarLikes(tip1, tip2, tip3, tip4, tip5, tip6, 20);
		
		metodeProporcioGuardatsVisualitzacions(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeTipUtil(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeMesGuardats(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeTipMesDurada(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeVisualitzacionsDiaries(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeTipBenValorat(tip1, tip2, tip3, tip4, tip5, tip6);
		
		metodeCanviBenValorat(tip1, tip2, tip3, tip4, tip5, tip6, 80);
	}
	
	//Metode Setter
	private static void metodeSetter(InfoTip tip6) {
		tip6.setTema("Practica 1");
		
	}
	
	//Metode Getter
	private static void metodeGetter(InfoTip tip6) {
		tip6.getAlies();
		tip6.getTitol();
		tip6.getTema();
		tip6.getData();
		tip6.getSegons();
		tip6.getVisualitzacions();
		tip6.getGuardats();
		tip6.getLikes();
		
	}
	
	//Metode per mostrar les visualitzacions modificades 
	private static void metodeModificarVisualitzacions(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6, int x) {
		System.out.println("Les visualitzacions del tip1 es de: "+tip1.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip1.modificarVisualitzacions(x));
		System.out.println("Les visualitzacions del tip2 es de: "+tip2.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip2.modificarVisualitzacions(x));
		System.out.println("Les visualitzacions del tip3 es de: "+tip3.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip3.modificarVisualitzacions(x));
		System.out.println("Les visualitzacions del tip4 es de: "+tip4.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip4.modificarVisualitzacions(x));
		System.out.println("Les visualitzacions del tip5 es de: "+tip5.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip5.modificarVisualitzacions(x));
		System.out.println("Les visualitzacions del tip6 es de: "+tip6.getVisualitzacions()+" i les visualitzacions modificades es de: "+tip6.modificarVisualitzacions(x));
	}
	
	//Metode per mostrar els guardats modificades 
	private static void metodeModificarGuardats(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6, int x) {
		System.out.println("\nEls guardats del tip1 es de: "+tip1.getGuardats()+" i els guardats modificats es de: "+tip1.modificarGuardats(x));
		System.out.println("Els guardats del tip2 es de: "+tip2.getGuardats()+" i els guardats modificats es de: "+tip2.modificarGuardats(x));
		System.out.println("Els guardats del tip3 es de: "+tip3.getGuardats()+" i els guardats modificats es de: "+tip3.modificarGuardats(x));
		System.out.println("Els guardats del tip4 es de: "+tip4.getGuardats()+" i els guardats modificats es de: "+tip4.modificarGuardats(x));
		System.out.println("Els guardats del tip5 es de: "+tip5.getGuardats()+" i els guardats modificats es de: "+tip5.modificarGuardats(x));
		System.out.println("Els guardats del tip6 es de: "+tip6.getGuardats()+" i els guardats modificats es de: "+tip6.modificarGuardats(x));
	}

	//Metode per mostrar els likes modificades 
	private static void metodeModificarLikes(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6, int x) {
		System.out.println("\nEls likes del tip1 es de: "+tip1.getLikes()+" i els likes modificats es de: "+tip1.modificarLikes(x));
		System.out.println("Els likes del tip2 es de: "+tip2.getLikes()+" i els likes modificats es de: "+tip2.modificarLikes(x));
		System.out.println("Els likes del tip3 es de: "+tip3.getLikes()+" i els likes modificats es de: "+tip3.modificarLikes(x));
		System.out.println("Els likes del tip4 es de: "+tip4.getLikes()+" i els likes modificats es de: "+tip4.modificarLikes(x));
		System.out.println("Els likes del tip5 es de: "+tip5.getLikes()+" i els likes modificats es de: "+tip5.modificarLikes(x));
		System.out.println("Els likes del tip6 es de: "+tip6.getLikes()+" i els likes modificats es de: "+tip6.modificarLikes(x));
	}
	
	//Metode per mostrar la proporcio de guardats respecte visualtizacions
	private static void metodeProporcioGuardatsVisualitzacions(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {
		System.out.println("\nLa proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip1.proporcioGuardatsVisualitzacions()));
		System.out.println("La proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip2.proporcioGuardatsVisualitzacions()));
		System.out.println("La proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip3.proporcioGuardatsVisualitzacions()));
		System.out.println("La proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip4.proporcioGuardatsVisualitzacions()));
		System.out.println("La proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip5.proporcioGuardatsVisualitzacions()));
		System.out.println("La proporcio de guardats respecte visualitzacions del tip1 es de: "+String.format("%.2f", tip6.proporcioGuardatsVisualitzacions()));
		
	}
	
	//Metode per mostrar si el tip es util o no
	private static void metodeTipUtil(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {
		if(tip1.tipUtil()) {
			System.out.println("\nEl tip1 es util");
		}else
			System.out.println("El tip1 no es util");
		if(tip2.tipUtil()) {
			System.out.println("El tip2 es util");
		}else
			System.out.println("El tip2 no es util");
		if(tip3.tipUtil()) {
			System.out.println("El tip3 es util");
		}else
			System.out.println("El tip3 no es util");
		if(tip4.tipUtil()) {
			System.out.println("El tip4 es util");
		}else
			System.out.println("El tip4 no es util");
		if(tip5.tipUtil()) {
			System.out.println("El tip5 es util");
		}else
			System.out.println("El tip5 no es util");
		if(tip6.tipUtil()) {
			System.out.println("El tip6 es util");
		}else
			System.out.println("El tip6 no es util");
	}

	//Metode per mostrar quin tip es el mes guardat
	private static void metodeMesGuardats(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {
		if(tip1.tipMesGuardats(tip2)) {
			System.out.println("\nEl tip1 ha estat mes guardat");
		}else
			System.out.println("El tip2 ha estat mes guardat");
		if(tip3.tipMesGuardats(tip4)) {
			System.out.println("El tip3 ha estat mes guardat");
		}else
			System.out.println("El tip4 ha estat mes guardat");
		if(tip5.tipMesGuardats(tip6)) {
			System.out.println("El tip5 ha estat mes guardat");
		}else
			System.out.println("El tip6 ha estat mes guardat");
	}
	
	//Metode per mostrar quin tip te mes durada
	private static void metodeTipMesDurada(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {	
		System.out.println("\nComparant tip1 amb tip2: "+tip1.tipMesDurada(tip2));
		System.out.println("Comparant tip3 amb tip4 "+tip3.tipMesDurada(tip4));
		System.out.println("Comparant tip5 amb tip6 "+tip5.tipMesDurada(tip6));
	}
	
	//Metode per mostrar les visualitzacions diaries
	private static void metodeVisualitzacionsDiaries(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {
		Data data2 = new Data(15, 10, 2021);
		System.out.println("Dies del tip1: "+String.format("%.2f", tip1.visualitzacionsDiaries(data2)));
		System.out.println("Dies del tip2: "+String.format("%.2f", tip2.visualitzacionsDiaries(data2)));
		System.out.println("Dies del tip3: "+String.format("%.2f", tip3.visualitzacionsDiaries(data2)));
		System.out.println("Dies del tip4: "+String.format("%.2f", tip4.visualitzacionsDiaries(data2)));
		System.out.println("Dies del tip5: "+String.format("%.2f", tip5.visualitzacionsDiaries(data2)));
		System.out.println("Dies del tip6: "+String.format("%.2f", tip6.visualitzacionsDiaries(data2)));
	}
	
	//Metode per mostrar si el tip esta ben valorat
	private static void metodeTipBenValorat(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6) {
		if(tip1.tipBenValorat()) {
			System.out.println("\nEl tip1 esta ben valorat");
		}else
			System.out.println("\nEl tip1 no esta ben valorat");
		if(tip2.tipBenValorat()) {
			System.out.println("El tip2 esta ben valorat");
		}else
			System.out.println("El tip2 no esta ben valorat");
		if(tip3.tipBenValorat()) {
			System.out.println("El tip3 esta ben valorat");
		}else
			System.out.println("El tip3 no esta ben valorat");
		if(tip4.tipBenValorat()) {
			System.out.println("El tip4 esta ben valorat");
		}else
			System.out.println("El tip4 no esta ben valorat");
		if(tip5.tipBenValorat()) {
			System.out.println("El tip5 esta ben valorat");
		}else
			System.out.println("El tip5 no esta ben valorat");
		if(tip6.tipBenValorat()) {
			System.out.println("El tip6 esta ben valorat");
		}else
			System.out.println("El tip6 no esta ben valorat");
		
	}
	
	//Metode per mostrar el canvi de proporcio dins d'un rang
	private static void metodeCanviBenValorat(InfoTip tip1, InfoTip tip2, InfoTip tip3, InfoTip tip4, InfoTip tip5, InfoTip tip6, int n) {
		int m;
		m = tip5.getProporcioBenValorat();
		InfoTip.canviBenValorat(n);
		if(m == tip5.getProporcioBenValorat()) {
			System.out.println("\nLa proporció no está dins del rang i és: "+n);
		}else
			System.out.println("\nLa proporció está dins del rang i és: "+tip5.getProporcioBenValorat());
	}
}
