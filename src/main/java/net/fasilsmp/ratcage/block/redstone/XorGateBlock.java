package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.XorGate;

public class XorGateBlock extends BaseLogicGateBlock {
    public XorGateBlock() {
        super(new XorGate());
    }
}
