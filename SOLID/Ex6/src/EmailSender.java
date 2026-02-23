public class EmailSender implements NotificationSender {

    private final AuditLog audit;

    public EmailSender(AuditLog audit) {
        this.audit = audit;
    }

    @Override
    public void send(Notification n) {

        if (n.body != null && n.body.length() > 40) {
            System.out.println("EMAIL ERROR: body exceeds 40 characters");
            audit.add("email failed");
            return;
        }

        System.out.println(
            "EMAIL -> to=" + n.email +
            " subject=" + n.subject +
            " body=" + n.body
        );

        audit.add("email sent");
    }
}