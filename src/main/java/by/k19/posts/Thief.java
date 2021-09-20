package by.k19.posts;

public class Thief implements MailService{
    private int minValue;
    private int stolenValue;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            if (mailPackage.getContent().getPrice() >= minValue) {
                stolenValue += mailPackage.getContent().getPrice();
                Package emptyPackage = new Package("stones instead of " + mailPackage.getContent().getContent(), 0);
                return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), emptyPackage);
            }
        }
        return mail;
    }
}
