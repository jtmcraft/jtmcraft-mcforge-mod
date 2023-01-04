package net.fasilsmp.ratcage.item;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.entity.RatCageEntityTypes;
import net.fasilsmp.ratcage.sound.RatCageSounds;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RatCageItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RatCageMod.MOD_ID);
    public static final RegistryObject<Item> MUSIC_DISC_ODE_TO_JOY = ITEMS
            .register(
                    "music_disc_ode_to_joy",
                    new RatCageRecordItemSupplier(15, RatCageSounds.ODE_TO_JOY, 30)
            );
    public static final RegistryObject<ForgeSpawnEggItem> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(RatCageEntityTypes.RACCOON, 0x948e8d, 0x3b3635,
                    new Item.Properties().tab(RatCageCreativeTab.RATCAGE_CREATIVE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
