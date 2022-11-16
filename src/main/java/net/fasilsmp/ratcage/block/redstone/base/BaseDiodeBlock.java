package net.fasilsmp.ratcage.block.redstone.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.NotNull;

import static net.fasilsmp.ratcage.block.RatCageBlocks.DEFAULT_DELAY;

public class BaseDiodeBlock extends DiodeBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public BaseDiodeBlock() {
        super(BlockBehaviour.Properties.of((new Material.Builder(MaterialColor.NONE).build())));
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, Boolean.FALSE)
        );
    }

    @Override
    protected int getDelay(@NotNull BlockState blockState) {
        return DEFAULT_DELAY;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING, POWERED);
    }

    protected int getClockwiseSignal(LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        Direction direction = blockState.getValue(FACING).getClockWise();

        return getAlternateSignalAt(levelReader, blockPos.relative(direction), direction);
    }

    protected int getCounterClockwiseSignal(LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        Direction direction = blockState.getValue(FACING).getCounterClockWise();

        return getAlternateSignalAt(levelReader, blockPos.relative(direction), direction);
    }
}
