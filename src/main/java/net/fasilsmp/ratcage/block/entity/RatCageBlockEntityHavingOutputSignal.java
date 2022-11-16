package net.fasilsmp.ratcage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RatCageBlockEntityHavingOutputSignal extends BlockEntity {
    private int outputSignal;

    public RatCageBlockEntityHavingOutputSignal(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("OutputSignal", this.outputSignal);
    }

    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.outputSignal = tag.getInt("OutputSignal");
    }

    public int getOutputSignal() {
        return this.outputSignal;
    }

    public void setOutputSignal(int outputSignal) {
        this.outputSignal = outputSignal;
    }
}
