package zadanie4;

public class SmsNotificationService implements NotificationService {

    @Override 
    public void sendNotification(String receiver, String message) {
        System.out.println("SMS do: " + receiver + "  Wiadomość: " + message );
    }
}