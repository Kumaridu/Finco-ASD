package framework.services;

public class Email {
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    private String sender;
    private String receiver;
    private String message;

    public String getSubject() {
        return subject;
    }

    private String subject;

    /**
     *
     * @param subject
     * @param sender
     * @param receiver
     * @param message
     */
    Email(String subject, String sender, String receiver, String message){
        this.message = message;
        this.receiver = receiver;
        this.sender = sender;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Subject: " + this.subject + " \n " +
                "Sender: " + this.sender + " \n" +
                "Receiver: " + this.receiver + "\n" +
                "Message: " + this.message;
    }
}
