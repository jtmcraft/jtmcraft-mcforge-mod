package net.fasilsmp.ratcage.event;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.entity.RatCageEntityTypes;
import net.fasilsmp.ratcage.entity.client.RaccoonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RatCageMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventHandler {
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(RatCageEntityTypes.RACCOON.get(), RaccoonRenderer::new);
    }
}
