package net.fasilsmp.ratcage.block.redstone.entities;

import net.fasilsmp.ratcage.block.entity.RatCageBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleLatchBlockEntity extends BlockEntity {
    public SimpleLatchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RatCageBlockEntities.REDSTONE_SIMPLE_LATCH.get(), blockPos, blockState);
    }
}
