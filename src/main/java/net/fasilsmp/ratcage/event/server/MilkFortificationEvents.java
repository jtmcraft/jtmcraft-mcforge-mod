package net.fasilsmp.ratcage.event.server;

import net.fasilsmp.ratcage.RatCageMod;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RatCageMod.MOD_ID)
public class MilkFortificationEvents {
    private static final long OFFSET = 60000; // 30 minutes = 1800000

    private static final String RATCAGE_MILK_FORTIFICATION_KEY = "ratcage_milk_fortification";

    @SubscribeEvent
    public static void OnPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!player.level.isClientSide()) {
            long milkFortification = player.getPersistentData().getLong(RATCAGE_MILK_FORTIFICATION_KEY);
            if (milkFortification > 0) {
                player.getPersistentData().putLong(RATCAGE_MILK_FORTIFICATION_KEY, milkFortification + System.currentTimeMillis());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedOutEvent(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();
        if (!player.level.isClientSide()) {
            long timeRemaining = getMilkFortification(player);

            if (timeRemaining < 1) {
                player.getPersistentData().remove(RATCAGE_MILK_FORTIFICATION_KEY);
            } else {
                player.getPersistentData().putLong(RATCAGE_MILK_FORTIFICATION_KEY, timeRemaining);
            }
        }
    }

    private static long getMilkFortification(Player player) {
        return player.getPersistentData().getLong(RATCAGE_MILK_FORTIFICATION_KEY) - System.currentTimeMillis();
    }

    @SubscribeEvent
    public static void onLivingEntityUseItemFinishEvent(LivingEntityUseItemEvent.Finish event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getEntity() instanceof Player player) {
                if (event.getItem().getItem() == Items.MILK_BUCKET) {
                    long milkFortification = System.currentTimeMillis() + OFFSET;
                    player.getPersistentData().putLong(RATCAGE_MILK_FORTIFICATION_KEY, milkFortification);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMobEffectEventApplicableEvent(MobEffectEvent.Applicable event) {
        if (!event.getEntity().level.isClientSide()
                && event.getEntity() instanceof Player player
                && event.getEffectInstance().getEffect().getCategory() == MobEffectCategory.HARMFUL
                && getMilkFortification(player) > 0
        ) {
            event.setResult(Event.Result.DENY);
        }
    }
}
