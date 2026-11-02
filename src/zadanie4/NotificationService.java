package zadanie4;

import zadanie1.Person;

public interface NotificationService {
    void sendNotification(Person receiver, String message);
}