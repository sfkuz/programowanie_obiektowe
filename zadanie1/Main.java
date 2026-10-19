import mypackage.Size;
import mypackage.Status;
import mypackage.Person;
import mypackage.Parcel;

public class Main {
    public static void main(String[] args) {
        Person nadawca = new Person("Ala", "Kowalska", "+48672365908", "Warszawa");
        Person odbiorca = new Person("Bolesław", "Odważny", "+48561289456", "Łodź");

        System.out.println("==== START ====\n");

        testParcelGood(nadawca, odbiorca);
        testParcelWithOutId(nadawca, odbiorca);
        testParcelLowWeight(nadawca, odbiorca);
        testParcelWithOutPerson(nadawca);
    }

    private static void testParcelGood(Person nadawca, Person odbiorca) {
        System.out.println("==== TEST 1: Good Parcel ====");
        try {
            Parcel paczka = new Parcel("100", nadawca, odbiorca, 2.1, Size.MEDIUM);
            paczka.printInfo();

            paczka.changeStatus(Status.IN_LOCKER);
            System.out.println("Po zmianie statusu:");
            paczka.printInfo();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testParcelWithOutId(Person nadawca, Person odbiorca) {
        System.out.println("==== TEST 2: Parcel with out id ====");
        try {
            Parcel paczka = new Parcel("", nadawca, odbiorca, 1.5, Size.SMALL);
        
            System.out.println("Error. This shouldn't have happend");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testParcelLowWeight(Person nadawca, Person odbiorca) {
        System.out.println("==== TEST 3: Parcel with low weight ====");
        try {
            Parcel paczka = new Parcel("101", nadawca, odbiorca, -5.5, Size.LARGE);

            System.out.println("Error. This shouldn't have happend");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testParcelWithOutPerson(Person nadawca) {
        System.out.println("==== TEST 4: Parcel with out person ====");
        try {
            Parcel paczka = new Parcel("102", nadawca, null, 1.5, Size.SMALL);

            System.out.println("Error. This shouldn't have happend");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        System.out.println();
    }
}