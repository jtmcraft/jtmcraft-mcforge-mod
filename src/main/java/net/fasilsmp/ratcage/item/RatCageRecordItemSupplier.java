package net.fasilsmp.ratcage.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RatCageRecordItemSupplier implements Supplier<RecordItem> {
    private final int comparatorOutput;
    private final RegistryObject<SoundEvent> soundEventRegistryObject;
    private final int lengthInSeconds;

    public RatCageRecordItemSupplier(int comparatorOutput, RegistryObject<SoundEvent> soundEventRegistryObject, int lengthInSeconds) {
        this.comparatorOutput = comparatorOutput;
        this.soundEventRegistryObject = soundEventRegistryObject;
        this.lengthInSeconds = lengthInSeconds;
    }

    @Override
    public RecordItem get() {
        return new RatCageRecordItem(comparatorOutput, soundEventRegistryObject, lengthInSeconds * 20);
    }
}
