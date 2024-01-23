package øving2_Oppg1og2;
/**
 * Interface for a film archive (ADT).
 */
public interface FilmarkivADT {

    /**
     * Retrieve a film with the given number from the archive.
     *
     * @param nr The number of the film to retrieve.
     * @return The film with the given number. If the number does not exist, null is returned.
     */
    Film finnFilm(int nr);

    /**
     * Add a new film to the archive.
     *
     * @param nyFilm The new film to be added.
     */
    void leggTilFilm(Film nyFilm);

    /**
     * Delete a film with the given number.
     *
     * @param filmnr The number of the film to be deleted.
     * @return True if the film was deleted, false otherwise.
     */
    boolean slettFilm(int filmnr);

    /**
     * Search and retrieve films with a given substring in the title.
     *
     * @param delstreng The substring that must be in the title.
     * @return An array of films that have the substring in the title.
     */
    Film[] soekTittel(String delstreng);

    /**
     * Search and retrieve films with a given substring in the film producer.
     *
     * @param delstreng The substring to search for in the film producer.
     * @return An array of films that have the substring in the film producer.
     */
    Film[] soekProdusent(String delstreng);

    /**
     * Find the number of films with a given genre.
     *
     * @param sjanger The genre to count films for.
     * @return The number of films with the given genre.
     */
    int antall(Sjanger sjanger);

    /**
     * Get the total number of films in the archive.
     *
     * @return The total number of films in the archive.
     */
    int antall();
}