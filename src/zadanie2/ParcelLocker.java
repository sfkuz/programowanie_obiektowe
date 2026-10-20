package zadanie2;

import zadanie1.Parcel;
import zadanie1.Size;
import zadanie1.Status;
import zadanie2.Locker;

import java.util.List;
import java.util.ArrayList;

public class ParcelLocker {
    private String id;
    private String adress;
    private List<Locker> lockers;

    public ParcelLocker(String id, String adress) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        if (adress == null || adress.isEmpty()) {
            throw new IllegalArgumentException("adress cannot be empty");
        }

        this.id = id;
        this.adress = adress;
        this.lockers = new ArrayList<>();
    }

    public void addLocker(Locker locker) {
        if (locker == null) {
            throw new IllegalArgumentException("locker cannot be empty");
        }
        this.lockers.add(locker);
    }

    public boolean canFit(Size rozmiarPaczki, Size rozmiarSkrytki) {
        if (rozmiarPaczki == Size.SMALL) {
            return true;
        } else if (rozmiarPaczki == Size.MEDIUM) {
            return rozmiarSkrytki == Size.MEDIUM || rozmiarSkrytki == Size.LARGE;
        } else if (rozmiarPaczki == Size.LARGE) {
            return rozmiarSkrytki == Size.LARGE;
        }
        return false;
    }

    public void placeParcel(Parcel parcel) {
        for (Locker locker : lockers) {
            if (locker.isEmpty()) {
                if (canFit(parcel.getRozmiar(), locker.getRozmiar())) {
                    locker.putParcel(parcel);
                    parcel.changeStatus(Status.IN_LOCKER);
                    System.out.println("Paczka (" + parcel.getRozmiar() + ") umieszczona w skrytce (" + locker.getRozmiar() + ")");
                    return;
                }
            }
        }
        System.out.println("Brak dostępnego miejsca dla paczki (" + parcel.getRozmiar() + ")");
    }

    public void printLockerInfo() {
        System.out.println("=== Paczkomat " + id + " (" + adress + ") ===");
        for (Locker s : lockers) {
            s.printInfo();
        }
        System.out.println("=====================================");
    }
}