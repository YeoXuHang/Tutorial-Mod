package net.tutorial.client.renderer.rainbow;


import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tutorial.TutorialMod;
import net.tutorial.entity.RainbowEntity;

@OnlyIn(Dist.CLIENT)
public class RainbowEntityRenderer extends MobRenderer<RainbowEntity, ZombieModel<RainbowEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID,"textures/entity/rainbow_entity/rainbow_zombie.png");

    public RainbowEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieModel<>(context.bakeLayer(ModelLayers.ZOMBIE)), 0.14F);
        this.addLayer(new RainbowLayerRenderer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(RainbowEntity p_114482_) {
        return TEXTURE;
    }


}
