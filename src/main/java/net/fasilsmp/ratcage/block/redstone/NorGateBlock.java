package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.NorGate;

public class NorGateBlock extends BaseLogicGateBlock {
    public NorGateBlock() {
        super(new NorGate());
    }
}
