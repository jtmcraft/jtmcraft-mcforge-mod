package net.fasilsmp.ratcage.logic;

public class NandGate implements LogicGate {
    @Override
    public Boolean apply(Integer a, Integer b) {
        return !((a > 0) & (b > 0));
    }
}
