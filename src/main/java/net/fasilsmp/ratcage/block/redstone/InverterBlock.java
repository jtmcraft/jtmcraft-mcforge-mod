package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseDiodeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class InverterBlock extends BaseDiodeBlock {
    public InverterBlock() {
        super();
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, true));
    }

    @Override
    protected boolean shouldTurnOn(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return !super.shouldTurnOn(level, blockPos, blockState);
    }
}
