package zadanie1;

public abstract class Parcel {
    protected String id;
    protected Person nadawca;
    protected Person odbiorca;
    protected double waga;
    protected Size rozmiar;
    protected Status status;

    public Parcel(String id, Person nadawca, Person odbiorca, double waga, Size rozmiar) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        
        if (nadawca == null) {
            throw new IllegalArgumentException("nadawca cannot be empty");
        }

        if (odbiorca == null) {
            throw new IllegalArgumentException("odbiorca cannot be empty");
        }

        if (waga <= 0) {
            throw new IllegalArgumentException("waga cannot be less then 0");
        }

        this.id = id;
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.waga = waga;
        this.rozmiar = rozmiar;
        this.status =  Status.CREATED;
    }

    public Status getStatus() {
        return this.status;
    }

    public Person getNadawca() {
        return this.nadawca;
    }

    public Person getOdbiorca() {
        return this.odbiorca;
    }

    public Size getRozmiar() {
        return this.rozmiar;
    }

    public void changeStatus(Status nowyStatus) {
        this.status = nowyStatus;
    }

    public void printInfo() {
        System.out.println("id: " + id + ", Nadawca: " + nadawca.GetInfoPerson() + ", Odbiorca: " + odbiorca.GetInfoPerson() + ", Waga: " + waga + ", Rozmiar: " + rozmiar + ", Status: " + status);
    }

    public abstract double calculatePrice();

    public abstract String getDeliveryTime();
    
}