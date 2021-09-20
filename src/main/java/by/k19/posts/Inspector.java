package by.k19.posts;

public class Inspector implements MailService{
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            String content = mailPackage.getContent().getContent();
            if ("weapons".equals(content) ||
                "banned substance".equals(content))
                throw new IllegalPackageException();
            if (content.contains("stolen"))
                throw new StolenPackageException();
        }
        return mail;
    }
}
