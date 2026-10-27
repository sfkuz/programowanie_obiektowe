import zadanie1.*;
import zadanie2.*;
import zadanie3.*;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

    }
}