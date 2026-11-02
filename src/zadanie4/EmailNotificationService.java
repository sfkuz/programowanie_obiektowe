package zadanie4;

import zadanie1.Person;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(Person receiver, String message) {
        System.out.println("Email do: " + receiver + "  Wiadomość: " + message );
    }

}