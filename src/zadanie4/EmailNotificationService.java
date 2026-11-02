package zadanie4;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String receiver, String message) {
        System.out.println("Email do: " + receiver + "  Wiadomość: " + message );
    }

}