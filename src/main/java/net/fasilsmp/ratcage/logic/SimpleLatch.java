package net.fasilsmp.ratcage.logic;

public class SimpleLatch implements Latch {
    @Override
    public Boolean apply(Boolean isPowered, Boolean hasInputSignal) {
        if (hasInputSignal) {
            return !isPowered;
        }

        return null;
    }
}
