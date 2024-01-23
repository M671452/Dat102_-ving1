package øving2_Oppg1og2;

import java.util.Scanner;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny( FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		//filmarkiv.leggTilFilm(new Film(int filmnr, String produsent, String tittle, int lanseringsaar, Sjanger sjanger, String filmselskap)
		leggTilForhaandsdefinerteFilmer();
		

       // Scanner scanner = new Scanner(System.in);
	     int valg;
	     do {
	    	 System.out.println("Meny: ");
	    	 System.out.println("1. Legg til film");
	    	 System.out.println("2. Slett film");
	    	 System.out.println("3. Søk tittel på film");
	    	 System.out.println("4. Søk etter produsent");
	    	 System.out.println("5. Vis statistikkene");
	    	 System.out.println("0. Exit");
	    	 System.out.println("Skriv inn ditt valg: ");
	    	 valg = tekstgr.lesInnHeltall();
	    	 
            switch (valg) {
                case 1:
                    filmarkiv.leggTilFilm(lesFilm());
                    break;
                case 2:
                    System.out.println("Skriv inn filmnummeret du vil slette:");
                    int filmnummer = tekstgr.lesInnHeltall();
                    boolean slettet = filmarkiv.slettFilm(filmnummer);
                    if (slettet) {
                        System.out.println("Filmen ble slettet.");
                    } else {
                        System.out.println("Filmen ble ikke funnet.");
                    }
                    break;
                case 3:
                    System.out.println("Skriv inn delstreng i tittelen:");
                    String delstreng = tekstgr.lesInnTekst();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstreng);
                    break;
                case 4:
                    System.out.println("Skriv inn delstreng i produsentens navn:");
                    String produsentDelstreng = tekstgr.lesInnTekst();
                    break;
                case 5:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 0: 
                	System.out.println("Avslutter programmet.");
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
            
    private void leggTilForhaandsdefinerteFilmer() {
    	filmarkiv.leggTilFilm(new Film(1, "John Johnson", "Capabara", 2020, Sjanger.DRAMA,"Valve Movies AS"));
	    filmarkiv.leggTilFilm(new Film(2, "Olav Nilsen", "Gunshot", 2000, Sjanger.ACTION, "Valve Movies AS"));
	    filmarkiv.leggTilFilm(new Film(3, "Pernille Myking", "The Guy",2021, Sjanger.HISTORY, "Dreamworks"));
	    filmarkiv.leggTilFilm(new Film(4, "Benedicte Olsen", "The Computer Revolution",1950, Sjanger.SCIFI, "Disney"));
	    filmarkiv.leggTilFilm(new Film(5, "Olaug Jacobsen", "Dragon Attack",2023, Sjanger.DRAMA, "Rushmore"));
        		
	}

    
}
