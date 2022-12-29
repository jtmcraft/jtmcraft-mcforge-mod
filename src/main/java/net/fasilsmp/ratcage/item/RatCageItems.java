package net.fasilsmp.ratcage.item;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.sound.RatCageSounds;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.logging.Logger;

public class RatCageItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RatCageMod.MOD_ID);
    public static final RegistryObject<Item> MUSIC_DISC_ODE_TO_JOY = ITEMS
            .register(
                    "music_disc_ode_to_joy",
                    new RatCageRecordItemSupplier(15, RatCageSounds.ODE_TO_JOY, 30)
            );
    private static final Logger LOGGER = Logger.getLogger(RatCageItems.class.getName());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
