package net.fasilsmp.ratcage.block.redstone;

import net.fasilsmp.ratcage.block.redstone.base.BaseDiodeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ResistorBlock extends BaseDiodeBlock {
    public static final IntegerProperty RESISTANCE = IntegerProperty.create("resistance", 1, 4);

    public ResistorBlock() {
        super();
        this.registerDefaultState(this.stateDefinition.any().setValue(RESISTANCE, 1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> blockStateBuilder) {
        super.createBlockStateDefinition(blockStateBuilder);
        blockStateBuilder.add(RESISTANCE);
    }

    @Override
    protected int getOutputSignal(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        int baseOutputSignal = super.getInputSignal((Level) blockGetter, blockPos, blockState);
        int resistance = 3 * blockState.getValue(RESISTANCE);
        int outputSignal = baseOutputSignal - resistance;

        if (outputSignal < 0) {
            outputSignal = 0;
        }

        return outputSignal;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        } else {
            level.setBlock(blockPos, blockState.cycle(RESISTANCE), 3);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }
}
