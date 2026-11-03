package zadanie4;

import zadanie1.Size;
import zadanie2.Locker;

import java.util.List;

public class FirstAvailableStrategy implements LockerSelectionStrategy {

    @Override
    public Locker selectLocker(List<Locker> lockers, Size rozmiarPaczki) {
        for (Locker locker : lockers) {
            if (locker.isEmpty() && canFit(rozmiarPaczki, locker.getRozmiar())) {
                return locker;
            }
        }
        return null;
    }
}