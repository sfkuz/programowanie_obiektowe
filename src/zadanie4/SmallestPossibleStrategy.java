package zadanie4;

import zadanie1.Size;
import zadanie2.Locker;

import java.util.List;

public class SmallestPossibleStrategy implements LockerSelectionStrategy {

    @Override
    public Locker selectLocker(List<Locker> lockers, Size rozmiarPaczki) {
        Locker bestLocker = null;

        for (Locker locker : lockers) {
            if (locker.isEmpty() && canFit(rozmiarPaczki, locker.getRozmiar())) {
                if (bestLocker == null) {
                    bestLocker = locker;
                } else {
                    if (isSmaller(locker.getRozmiar(), bestLocker.getRozmiar())) {
                        bestLocker = locker;
                    }
                }
            }
        }
        return bestLocker;
    }

    private boolean isSmaller(Size size1, Size size2) {
        if (size1 == Size.SMALL && (size2 == Size.MEDIUM || size2 == Size.LARGE)) return true;
        if (size1 == Size.MEDIUM && size2 == Size.LARGE) return true;
        return false;
    }
}