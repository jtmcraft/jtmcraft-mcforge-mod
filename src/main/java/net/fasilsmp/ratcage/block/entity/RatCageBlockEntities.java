package net.fasilsmp.ratcage.block.entity;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.block.RatCageBlocks;
import net.fasilsmp.ratcage.block.redstone.entities.SimpleLatchBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RatCageBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RatCageMod.MODID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<SimpleLatchBlockEntity>> REDSTONE_SIMPLE_LATCH = BLOCK_ENTITIES.register(
            "redstone_simple_latch",
            () -> BlockEntityType.Builder.of(SimpleLatchBlockEntity::new, RatCageBlocks.REDSTONE_SIMPLE_LATCH_BLOCK.get()).build(null)
    );
}
