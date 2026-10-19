package mypackage;

public class Person {
    private String name;
    private String lastname;
    private String phone;
    private String adress;

    public Person (String name, String lastname, String phone, String adress) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }

        if (lastname == null || lastname.isEmpty()) {
            throw new IllegalArgumentException("lastname cannot be empty");
        }

        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("phone cannot be empty");
        }

        if (adress == null || adress.isEmpty()) {
            throw new IllegalArgumentException("adress cannot be empty");
        }

        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.adress = adress;
    }

    public String GetInfoPerson() {
        return "person: " + this.name + " " + this.lastname + " | address: " + this.adress + " | phone: " + this.phone;
    }
}