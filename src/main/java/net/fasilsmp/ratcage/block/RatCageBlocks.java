package net.fasilsmp.ratcage.block;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.block.redstone.*;
import net.fasilsmp.ratcage.item.RatCageItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RatCageBlocks {
    public static final int DEFAULT_DELAY = 2;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RatCageMod.MOD_ID);

    public static final RegistryObject<Block> REDSTONE_SIMPLE_LATCH_BLOCK = registerRedstoneBlock(
            "redstone_simple_latch",
            SimpleLatchEntityBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_AND_GATE_BLOCK = registerRedstoneBlock(
            "redstone_and_gate",
            AndGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_NAND_GATE_BLOCK = registerRedstoneBlock(
            "redstone_nand_gate",
            NandGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_OR_GATE_BLOCK = registerRedstoneBlock(
            "redstone_or_gate",
            OrGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_NOR_GATE_BLOCK = registerRedstoneBlock(
            "redstone_nor_gate",
            NorGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_XOR_GATE_BLOCK = registerRedstoneBlock(
            "redstone_xor_gate",
            XorGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_NXOR_GATE_BLOCK = registerRedstoneBlock(
            "redstone_nxor_gate",
            NxorGateBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_RESISTOR_BLOCK = registerRedstoneBlock(
            "redstone_resistor",
            ResistorBlock::new
    );

    public static final RegistryObject<Block> REDSTONE_INVERTER_BLOCK = registerRedstoneBlock(
            "redstone_inverter",
            InverterBlock::new
    );

    private static <T extends Block> RegistryObject<T> registerRedstoneBlock(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerRedstoneBlockItem(name, registeredBlock);
        return registeredBlock;
    }

    private static <T extends Block> void registerRedstoneBlockItem(String name, RegistryObject<T> block) {
        RatCageItems.ITEMS.register(name, new RegisterBlockItemSupplier(block, CreativeModeTab.TAB_REDSTONE));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
