import zadanie1.*;
import zadanie2.*;

public class Main {
    public static void main(String[] args) {
        Person nadawca = new Person("Ala", "Kowalska", "+48672365908", "Warszawa");
        Person odbiorca = new Person("Boleslaw", "Odwazny", "+48561289456", "Lodz");

        ParcelLocker paczkomat = new ParcelLocker("SOP-01", "Monte Cassino 14");
        paczkomat.addLocker(new Locker("L-01", Size.SMALL));
        paczkomat.addLocker(new Locker("L-02", Size.MEDIUM));
        paczkomat.addLocker(new Locker("L-03", Size.LARGE));
        paczkomat.addLocker(new Locker("L-04", Size.MEDIUM));

        System.out.println("Stan poczatkowy:");
        paczkomat.printLockerInfo();

        Parcel paczka1 = new Parcel("001", nadawca, odbiorca, 1.0, Size.SMALL);
        Parcel paczka2 = new Parcel("002", nadawca, odbiorca, 5.0, Size.LARGE);
        Parcel paczka3 = new Parcel("003", nadawca, odbiorca, 3.0, Size.MEDIUM);
        Parcel paczka4 = new Parcel("004", nadawca, odbiorca, 2.0, Size.SMALL);

        System.out.println("\n--- Umieszczamy paczki ---");
        
        paczkomat.placeParcel(paczka1); 
        
        paczkomat.placeParcel(paczka2); 
        
        paczkomat.placeParcel(paczka3);

        paczkomat.placeParcel(paczka4);

        System.out.println("\nStan koncowy:");
        paczkomat.printLockerInfo();

    }
}