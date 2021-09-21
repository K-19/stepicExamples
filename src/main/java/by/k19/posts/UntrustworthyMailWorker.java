package by.k19.posts;

public class UntrustworthyMailWorker implements MailService{
    private MailService[] mailServices;
    private RealMailService realMailService;


    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable checkedMail = mail;
        for (MailService service : mailServices) {
            checkedMail = service.processMail(checkedMail);
        }
        return getRealMailService().processMail(checkedMail);
    }
}
