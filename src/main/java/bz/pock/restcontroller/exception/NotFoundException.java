package bz.pock.restcontroller.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(long id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }

}
