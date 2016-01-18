package bz.pock.restcontroller.dto;


public class MessageDTO {
    public String message;
    public MessageType type;

    /**
     * Constructeur.
     */
    public MessageDTO() {
        super();
    }

    /**
     * Constructeur.
     *
     * @param type    type de message
     * @param message message à transmettre
     */
    public MessageDTO(MessageType type, String message) {
        super();
        this.message = message;
        this.type = type;
    }
}