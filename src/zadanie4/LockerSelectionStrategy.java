package zadanie4;

import zadanie1.Size;
import zadanie2.Locker;

import java.util.List;

public interface LockerSelectionStrategy {
    Locker selectLocker(List<Locker> lockers, Size rozmiarPaczki);

    default boolean canFit(Size rozmiarPaczki, Size rozmiarSkrytki) {
        if (rozmiarPaczki == Size.SMALL) {
            return true;
        } else if (rozmiarPaczki == Size.MEDIUM) {
            return rozmiarSkrytki == Size.MEDIUM || rozmiarSkrytki == Size.LARGE;
        } else if (rozmiarPaczki == Size.LARGE) {
            return rozmiarSkrytki == Size.LARGE;
        }
        return false;
    }
}