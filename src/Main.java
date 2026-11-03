import zadanie1.*;
import zadanie2.*;
import zadanie3.*;
import zadanie4.*; 

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("======== ZADANIE 3 ========");

        Person nadawca = new Person("Ala", "Kowalska", "+48672365908", "Warszawa");
        Person odbiorca = new Person("Boleslaw", "Odwazny", "+48561289456", "Lodz");

        Parcel paczka1 = new StandardParcel("001", nadawca, odbiorca, 2.5, Size.SMALL);
        Parcel paczka2 = new ExpressParcel("002", nadawca, odbiorca, 5.0, Size.MEDIUM);
        Parcel paczka3 = new FragileParcel("003", nadawca, odbiorca, 10.0, Size.LARGE);
        Parcel paczka4 = new StandardParcel("004", nadawca, odbiorca, 1.0, Size.MEDIUM);

        List<Parcel> listaPrzesylek = new ArrayList<>();
        listaPrzesylek.add(paczka1);
        listaPrzesylek.add(paczka2);
        listaPrzesylek.add(paczka3);
        listaPrzesylek.add(paczka4);

        System.out.println("\n--- Informacje o paczkach ---");
        
        for (Parcel paczka : listaPrzesylek) {
            paczka.printInfo();
            System.out.println("Cena: " + paczka.calculatePrice() + ", Czas dostawy: " + paczka.getDeliveryTime() + "\n");
        }

        System.out.println("======== ZADANIE 4 ========");

        NotificationService notificationService = new EmailNotificationService();
        LockerSelectionStrategy firstAvailableStrategy = new FirstAvailableStrategy();

        ParcelLocker paczkomat1 = new ParcelLocker("SOP14M", "ul. Monte Cassinno 14, Sopot", notificationService, firstAvailableStrategy);

        paczkomat1.addLocker(new Locker("L1", Size.LARGE));
        paczkomat1.addLocker(new Locker("L2", Size.SMALL));
        paczkomat1.addLocker(new Locker("L3", Size.MEDIUM));
        paczkomat1.addLocker(new Locker("L4", Size.LARGE));

        System.out.println("\n--- Informacje o paczkomacie ---");
        paczkomat1.printLockerInfo();

        paczkomat1.placeParcel(paczka1);
        paczkomat1.placeParcel(paczka2);
        paczkomat1.placeParcel(paczka3);

        System.out.println("\n--- Informacje o paczkomacie po umieszczeniu przesyłek ---");
        paczkomat1.printLockerInfo();
    }
}