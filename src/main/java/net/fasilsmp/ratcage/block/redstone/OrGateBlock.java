package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseLogicGateBlock;
import net.fasilsmp.ratcage.logic.OrGate;

public class OrGateBlock extends BaseLogicGateBlock {
    public OrGateBlock() {
        super(new OrGate());
    }
}
