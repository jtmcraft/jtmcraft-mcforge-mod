package net.fasilsmp.ratcage.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegisterBlockItemSupplier implements Supplier<BlockItem> {
    private final RegistryObject<? extends Block> block;
    private final CreativeModeTab creativeModeTab;

    public RegisterBlockItemSupplier(RegistryObject<? extends Block> block, CreativeModeTab creativeModeTab) {
        this.block = block;
        this.creativeModeTab = creativeModeTab;
    }

    @Override
    public BlockItem get() {
        return new BlockItem(block.get(), new Item.Properties().tab(creativeModeTab));
    }
}
