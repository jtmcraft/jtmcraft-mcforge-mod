package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.NandGate;

public class NandGateBlock extends BaseLogicGateBlock {
    public NandGateBlock() {
        super(new NandGate());
    }
}
