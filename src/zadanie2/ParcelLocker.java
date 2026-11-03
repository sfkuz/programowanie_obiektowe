package zadanie2;

import zadanie1.Parcel;
import zadanie1.Status;

import zadanie4.NotificationService;
import zadanie4.LockerSelectionStrategy;

import java.util.List;
import java.util.ArrayList;

public class ParcelLocker {
    private String id;
    private String adress;
    private List<Locker> lockers;
    private NotificationService notificationService;
    private LockerSelectionStrategy lockerSelectionStrategy;

    public ParcelLocker(String id, String adress, NotificationService notificationService, LockerSelectionStrategy lockerSelectionStrategy) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        if (adress == null || adress.isEmpty()) {
            throw new IllegalArgumentException("adress cannot be empty");
        }

        this.id = id;
        this.adress = adress;
        this.lockers = new ArrayList<>();
        this.notificationService = notificationService;
        this.lockerSelectionStrategy = lockerSelectionStrategy;
    }

    public void addLocker(Locker locker) {
        if (locker == null) {
            throw new IllegalArgumentException("locker cannot be empty");
        }
        this.lockers.add(locker);
    }


    public void placeParcel(Parcel parcel) {
        Locker selectedLocker = lockerSelectionStrategy.selectLocker(this.lockers, parcel.getRozmiar());

        if (selectedLocker != null) {
            selectedLocker.putParcel(parcel);
            parcel.changeStatus(Status.IN_LOCKER);
            System.out.println("Paczka (" + parcel.getRozmiar() + ") umieszczona w skrytce (" + selectedLocker.getRozmiar() + ")");
            
            notificationService.sendNotification(parcel.getOdbiorca(), "Twoja paczka właśnie dotarła! Skrytka: " + selectedLocker.getRozmiar() + ", Paczkomat: " + this.adress);
        } else {
            System.out.println("Brak dostępnego miejsca dla paczki (" + parcel.getRozmiar() + ")");
        }
    }

    public void printLockerInfo() {
        System.out.println("=== Paczkomat " + id + " (" + adress + ") ===");
        for (Locker s : lockers) {
            s.printInfo();
        }
        System.out.println("=====================================");
    }
}