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

        System.out.println("Stan poczatkowy:");
        paczkomat.printLockerInfo();

        Parcel paczkaMala = new Parcel("001", nadawca, odbiorca, 1.0, Size.SMALL);
        Parcel paczkaDuza = new Parcel("002", nadawca, odbiorca, 5.0, Size.LARGE);
        Parcel paczkaSrednia = new Parcel("003", nadawca, odbiorca, 3.0, Size.MEDIUM);

        System.out.println("\n--- Umieszczamy paczki ---");
        
        paczkomat.placeParcel(paczkaMala); 
        
        paczkomat.placeParcel(paczkaDuza); 
        
        paczkomat.placeParcel(paczkaSrednia); 

        System.out.println("\nStan koncowy:");
        paczkomat.printLockerInfo();

        System.out.println("\nStatus paczki P-001 po umieszczeniu: " + paczkaMala.getStatus());
    }
}