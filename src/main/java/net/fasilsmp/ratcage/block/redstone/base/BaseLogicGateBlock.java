package net.fasilsmp.ratcage.block.redstone.base;

import net.fasilsmp.ratcage.logic.LogicGate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BaseLogicGateBlock extends BaseDiodeBlock {
    private final LogicGate logicGate;

    public BaseLogicGateBlock(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    @Override
    protected boolean shouldTurnOn(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        int cw = getClockwiseSignal(level, blockPos, blockState);
        int ccw = getCounterClockwiseSignal(level, blockPos, blockState);

        return logicGate.apply(cw, ccw);
    }
}
