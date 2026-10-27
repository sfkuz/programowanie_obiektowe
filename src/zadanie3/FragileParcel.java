package zadanie3;

import zadanie1.*;

public class FragileParcel extends Parcel {

    public FragileParcel(String id, Person nadawca, Person odbiorca, double waga,Size rozmiar) {
        super(id, nadawca, odbiorca, waga,rozmiar);
    }
    
    @Override 
    public double calculatePrice() {
        double basePrice = 10.0;
        double sizeMultiplier = 1.0;
        double fragilePrice = 5.0;

        switch (rozmiar) {
            case SMALL:
                sizeMultiplier = 1.0;
                break;
            case MEDIUM:
                sizeMultiplier = 1.5;
                break;
            case LARGE:
                sizeMultiplier = 2.0;
                break;
        }

        return basePrice * sizeMultiplier + fragilePrice;
    }

    @Override
    public String getDeliveryTime() {
        return "5-7 business days";
    }
}