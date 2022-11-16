package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.NxorGate;

public class NxorGateBlock extends BaseLogicGateBlock {
    public NxorGateBlock() {
        super(new NxorGate());
    }
}
