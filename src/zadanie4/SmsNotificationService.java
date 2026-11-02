package zadanie4;

import zadanie1.Person;

public class SmsNotificationService implements NotificationService {

    @Override 
    public void sendNotification(Person receiver, String message) {
        System.out.println("SMS do: " + receiver + "  Wiadomość: " + message );
    }
}