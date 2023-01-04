package net.fasilsmp.ratcage.event;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.entity.RatCageEntityTypes;
import net.fasilsmp.ratcage.entity.custom.RaccoonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RatCageMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeCreationEventHandler {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(RatCageEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
    }
}
