package by.k19.posts;

public class Inspector implements MailService{
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            String content = ((MailPackage)mail).getContent().getContent();
            if (content.contains("weapons") ||
                content.contains("banned substance"))
                throw new IllegalPackageException();
            if (content.contains("stolen"))
                throw new StolenPackageException();
        }
        return mail;
    }
}
