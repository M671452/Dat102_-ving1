package Test;

import org.junit.jupiter.api.Test;

import øving2_Oppg1og2.Film;
import øving2_Oppg1og2.Filmarkiv;
import øving2_Oppg1og2.FilmarkivADT;
import øving2_Oppg1og2.Sjanger;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FilmarkivTest {
	
	private FilmarkivADT filmarkiv;

    @Before
    public void setUp() {
        // Initialize the film archive before each test
        filmarkiv = new Filmarkiv(5);
    }

    @Test
    public void leggTilFilmTest() {
        Film film1 = new Film(1, "John Johnson", "Capabara", 2020, Sjanger.DRAMA,"Valve Movies AS");
        filmarkiv.leggTilFilm(film1);
        assertEquals(1, filmarkiv.antall());
    }

	@Test
    public void finnFilmTest() {
        Film film1 = new Film(1, "Producer1", "Movie1", 2020, Sjanger.HISTORY, "Company1");
        filmarkiv.leggTilFilm(film1);
        Film foundFilm = filmarkiv.finnFilm(1);
        assertEquals(film1, foundFilm);
    }

    @Test
    public void slettFilmTest() {
        Film film1 = new Film(1, "Producer1", "Movie1", 2020, Sjanger.SCIFI, "Company1");
        filmarkiv.leggTilFilm(film1);
        assertTrue(filmarkiv.slettFilm(1));
        assertEquals(0, filmarkiv.antall());
    }

    @Test
    public void soekTittelTest() {
        Film film1 = new Film(1, "Producer1", "Movie1", 2020, Sjanger.ACTION, "Company1");
        Film film2 = new Film(2, "Producer2", "Movie2", 2021, Sjanger.DRAMA, "Company2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        Film[] result = filmarkiv.soekTittel("Movie");
        assertEquals(2, result.length);
    }

    @Test
    public void antallSjangerTest() {
        Film film1 = new Film(1, "Producer1", "Movie1", 2020, Sjanger.ACTION, "Company1");
        Film film2 = new Film(2, "Producer2", "Movie2", 2021, Sjanger.ACTION, "Company2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        int count = filmarkiv.antall(Sjanger.ACTION);
        assertEquals(2, count);
    }
}