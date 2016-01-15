package bz.pock.restcontroller.exception;

public class NotFoundException extends RuntimeException {
    /**
     * Constructeur.
     *
     * @param id id de la donnée recherchée
     */
    public NotFoundException(long id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }

}
