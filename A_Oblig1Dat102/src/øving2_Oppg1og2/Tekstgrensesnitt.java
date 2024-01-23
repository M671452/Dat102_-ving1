package øving2_Oppg1og2;

import java.util.Arrays;
import java.util.Scanner;


public class Tekstgrensesnitt {
	private Scanner scanner;
	
	public Tekstgrensesnitt() {
		scanner = new Scanner(System.in);
	}
	
	public Film lesFilm() {
        System.out.print("Filmnummer: ");
        int filmnr = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();
        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();
        System.out.print("Lanseringsår: ");
        int lanseringsaar = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Sjanger: ");
        String sjangerStr = scanner.nextLine();
        Sjanger sjanger = Sjanger.navn(sjangerStr);
        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();

        return new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("Produsent: " + film.getProdusent());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Lanseringsår: " + film.getLanseringsaar());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Filmselskap: " + film.getFilmselskap());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
    	 Film[] result = arkiv.soekTittel(delstreng);
         if (result.length > 0) {
             System.out.println("Filmer med delstreng '" + delstreng + "' i tittelen:");
             Arrays.stream(result).forEach(this::skrivUtFilm);
         } else {
             System.out.println("Ingen filmer funnet med delstreng '" + delstreng + "' i tittelen.");
         }
     }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] resultater = arkiv.soekProdusent(delstreng);
        if (resultater.length == 0) {
            System.out.println("Ingen filmer funnet med produsenten '" + delstreng + "'.");
        } else {
            System.out.println("Filmer med produsenten '" + delstreng + "':");
            Arrays.stream(resultater).forEach(this::skrivUtFilm);
            
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer i arkivet: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println("Antall filmer av sjanger " + sjanger + ": " + arkiv.antall(sjanger));
        }
    }
    
    //Leser inn en tekststreng fra tastaturet
    String lesInnTekst() {
    	return scanner.nextLine();
    }
    
    //Leser inn et heltall fra tastaturet
    int lesInnHeltall() {
    	while(!scanner.hasNextInt()) {
    		System.out.println("Ugyldig input. Skriv inn et heltall: ");
    		scanner.next(); //Fjerner ugyldig input fra bufferen
    	}
    	int input = scanner.nextInt();
    	scanner.nextLine(); // Konsumerer resten av linjen
    	return input;
    }
    
    public void avslutt() {
    	scanner.close();
    }

    // osv ... andre metoder
}
