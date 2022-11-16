package net.fasilsmp.ratcage.logic;

public class XorGate implements LogicGate {
    @Override
    public Boolean apply(Integer a, Integer b) {
        return (a > 0) ^ (b > 0);
    }
}
