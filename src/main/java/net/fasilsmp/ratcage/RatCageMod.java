package net.fasilsmp.ratcage;

import net.fasilsmp.ratcage.block.RatCageBlocks;
import net.fasilsmp.ratcage.block.entity.RatCageBlockEntities;
import net.fasilsmp.ratcage.item.RatCageItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RatCageMod.MODID)
public class RatCageMod {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "ratcage";

    public RatCageMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RatCageBlocks.register(modEventBus);
        RatCageItems.register(modEventBus);
        RatCageBlockEntities.register(modEventBus);
    }
}
