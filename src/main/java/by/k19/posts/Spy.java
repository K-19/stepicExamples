package by.k19.posts;

import java.util.logging.Logger;

public class Spy implements MailService{
    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if (mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers"))
                logger.warning("Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + " \"" + ((MailMessage) mail).getMessage() + "\"");
            else
                logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
        }
        return mail;
    }
}
