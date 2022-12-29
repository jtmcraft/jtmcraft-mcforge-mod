package net.fasilsmp.ratcage.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RatCageCreativeTab {
    public static final CreativeModeTab RATCAGE_CREATIVE_TAB = new CreativeModeTab("ratcagetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RatCageItems.MUSIC_DISC_ODE_TO_JOY.get());
        }
    };
}
