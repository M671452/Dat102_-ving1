package øving2_Oppg1og2;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String filmselskap;
	
	//Konstruktører
	public Film() {
		//Tom komstruktør for å opprette et "tomt" film-øbjekt	
	}
	
	public Film(int filmnr, String produsent, String tittle, int lanseringsaar, Sjanger sjanger, String filmselskap) {
		 this.filmnr = filmnr;
	     this.produsent = produsent;
	     this.tittel = tittel;
	     this.lanseringsaar = lanseringsaar;
	     this.sjanger = sjanger;
	     this.filmselskap = filmselskap;
		
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return produsent;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsaar() {
		return lanseringsaar;
	}

	public void setLanseringsår(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	// equals- og hashCode-metoder
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Film film = (Film) obj;
		return filmnr == film.filmnr;
	}
	
	public int hashCode() {
		return Integer.hashCode(filmnr);
	}

}

