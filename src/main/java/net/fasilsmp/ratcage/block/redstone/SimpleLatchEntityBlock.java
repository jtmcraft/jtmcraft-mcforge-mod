package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.RatCageBlocks;
import net.fasilsmp.ratcage.block.entity.RatCageBlockEntities;
import net.fasilsmp.ratcage.block.entity.RatCageBlockEntityHavingOutputSignal;
import net.fasilsmp.ratcage.block.entity.RatCageEntityBlock;
import net.fasilsmp.ratcage.block.redstone.base.BaseDiodeBlock;
import net.fasilsmp.ratcage.logic.Latch;
import net.fasilsmp.ratcage.logic.SimpleLatch;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.ticks.TickPriority;
import org.jetbrains.annotations.NotNull;

public class SimpleLatchEntityBlock extends BaseDiodeBlock implements EntityBlock, RatCageEntityBlock {
    private final Latch simpleLatch;

    public SimpleLatchEntityBlock() {
        this.simpleLatch = new SimpleLatch();
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new RatCageBlockEntityHavingOutputSignal(getBlockEntityType(), blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getBlockEntityType() {
        return RatCageBlockEntities.REDSTONE_SIMPLE_LATCH.get();
    }

    @Override
    protected boolean shouldTurnOn(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        int i = getInputSignal(level, blockPos, blockState);

        if (i == 0) {
            return false;
        } else {
            return !blockState.getValue(POWERED);
        }
    }

    @Override
    public void tick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        refreshOutputState(serverLevel, blockPos, blockState);
    }

    @Override
    public boolean getWeakChanges(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return blockState.is(RatCageBlocks.REDSTONE_SIMPLE_LATCH_BLOCK.get());
    }

    private void refreshOutputState(Level level, BlockPos blockPos, BlockState blockState) {
        int i = getInputSignal(level, blockPos, blockState);
        int j = 0;

        if (level.getBlockEntity(blockPos) instanceof RatCageBlockEntityHavingOutputSignal ratCageBlockEntityHavingOutputSignal) {
            j = ratCageBlockEntityHavingOutputSignal.getOutputSignal();
            ratCageBlockEntityHavingOutputSignal.setOutputSignal(i);
        }

        if (j != i) {
            Boolean newPoweredState = simpleLatch.apply(blockState.getValue(POWERED), i > 0);
            if (newPoweredState != null) {
                level.setBlock(blockPos, blockState.setValue(POWERED, newPoweredState), 2);
                updateNeighborsInFront(level, blockPos, blockState);
            }
        }
    }

    @Override
    protected void checkTickOnNeighbor(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (!level.getBlockTicks().willTickThisTick(blockPos, this)) {
            int i = this.calculateOutputSignal(level, blockPos);
            if (i != 0 || blockState.getValue(POWERED) != this.shouldTurnOn(level, blockPos, blockState)) {
                TickPriority tickpriority = this.shouldPrioritize(level, blockPos, blockState) ? TickPriority.HIGH : TickPriority.NORMAL;
                level.scheduleTick(blockPos, this, 2, tickpriority);
            }
        }
    }

    @Override
    public boolean triggerEvent(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, int id, int param) {
        super.triggerEvent(blockState, level, blockPos, id, param);
        BlockEntity blockentity = level.getBlockEntity(blockPos);
        return blockentity != null && blockentity.triggerEvent(id, param);
    }

    private int calculateOutputSignal(Level level, BlockPos blockPos) {
        int outputSignal = 0;

        if (level.getBlockEntity(blockPos) instanceof RatCageBlockEntityHavingOutputSignal ratCageBlockEntityHavingOutputSignal) {
            outputSignal = ratCageBlockEntityHavingOutputSignal.getOutputSignal();
        }

        return outputSignal;
    }
}
