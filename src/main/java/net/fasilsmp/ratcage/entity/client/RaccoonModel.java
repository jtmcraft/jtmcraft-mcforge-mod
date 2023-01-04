package net.fasilsmp.ratcage.entity.client;

import net.fasilsmp.ratcage.RatCageMod;
import net.fasilsmp.ratcage.entity.custom.RaccoonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaccoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public ResourceLocation getModelResource(RaccoonEntity object) {
        return new ResourceLocation(RatCageMod.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaccoonEntity object) {
        return RaccoonRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(RaccoonEntity animatable) {
        return new ResourceLocation(RatCageMod.MOD_ID, "animations/raccoon.animation.json");
    }
}
