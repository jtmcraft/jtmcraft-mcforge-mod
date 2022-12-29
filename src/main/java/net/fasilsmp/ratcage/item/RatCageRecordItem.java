package net.fasilsmp.ratcage.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class RatCageRecordItem extends RecordItem {
    public RatCageRecordItem(int comparatorValue, Supplier<SoundEvent> soundSupplier, int lengthInTicks) {
        super(
                comparatorValue,
                soundSupplier,
                new Item.Properties().tab(RatCageCreativeTab.RATCAGE_CREATIVE_TAB).stacksTo(1),
                lengthInTicks
        );
    }
}
