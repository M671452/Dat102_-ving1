package øving2_Oppg1og2;


import java.util.ArrayList;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmer;
    private int antall;

    /**
     * Constructor for creating an empty film archive with a given capacity.
     *
     * @param kapasitet The initial capacity of the film archive.
     */
    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet];
        antall = 0;
    }

    /**
     * Helper method to double the size of the array when it's full.
     */
    private void utvid() {
        filmer = Arrays.copyOf(filmer, filmer.length * 2);
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : filmer) {
            if (film != null && film.getFilmnr() == nr) {
                return film;
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvid();
        }
        filmer[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getFilmnr() == filmnr) {
                // Move the last film to the deleted film's position and set the last index to null
                filmer[i] = filmer[antall - 1];
                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] result = new Film[antall];
        int count = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getTittel().contains(delstreng)) {
                result[count] = filmer[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] result = new Film[antall];
        int count = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i] != null && filmer[i].getProdusent().contains(delstreng)) {
                result[count] = filmer[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        for (Film film : filmer) {
            if (film != null && film.getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
    }
}