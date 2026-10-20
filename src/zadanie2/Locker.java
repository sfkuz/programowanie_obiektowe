package zadanie2;

import zadanie1.Size;
import zadanie1.Parcel;
import zadanie2.Occupancy;

public class Locker {
    private String number;
    private Size rozmiar;
    private Occupancy zajetosc;
    private Parcel przesylka;

    public Locker(String number, Size rozmiar) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
        if (rozmiar == null) {
            throw new IllegalArgumentException("rozmiar cannot be empty");
        }

        this.number = number;
        this.rozmiar = rozmiar;
        this.zajetosc = Occupancy.FREE;
        this.przesylka = null;
    }

    public void putParcel(Parcel przesylka) {
        if (przesylka == null) {
            throw new IllegalArgumentException("przesylka cannot be empty");
        }
        if (this.zajetosc == Occupancy.OCCUPIED) {
            throw new IllegalStateException("Locker is already occupied");
        }
        this.przesylka = przesylka;
        this.zajetosc = Occupancy.OCCUPIED;
    }

    public void removeParcel() {
        if (this.zajetosc == Occupancy.FREE) {
            throw new IllegalStateException("Locker is already free");
        }
        this.przesylka = null;
        this.zajetosc = Occupancy.FREE;
    }

    public boolean isEmpty() {
        return this.zajetosc == Occupancy.FREE;
    }

    public Size getRozmiar() {
        return this.rozmiar;
    }

    public void printInfo() {
        System.out.println("Locker number: " + number + ", Rozmiar: " + rozmiar + ", Zajetosc: " + zajetosc);
        if (przesylka != null) {
            System.out.println("Przesylka info:");
            przesylka.printInfo();
        } else {
            System.out.println("No parcel in this locker.");
        }
    }
} 