package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.AndGate;

public class AndGateBlock extends BaseLogicGateBlock {
    public AndGateBlock() {
        super(new AndGate());
    }
}
