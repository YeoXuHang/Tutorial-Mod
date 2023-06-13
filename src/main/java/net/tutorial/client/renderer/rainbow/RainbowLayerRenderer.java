package net.tutorial.client.renderer.rainbow;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SheepFurModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tutorial.TutorialMod;
import net.tutorial.entity.RainbowEntity;

@OnlyIn(Dist.CLIENT)
public class RainbowLayerRenderer extends RenderLayer<RainbowEntity, ZombieModel<RainbowEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID,"textures/entity/rainbow_entity/rainbow_zombie.png");
    private final SheepFurModel<Sheep> model;

    public RainbowLayerRenderer(RenderLayerParent<RainbowEntity, ZombieModel<RainbowEntity>> p_174533_, EntityModelSet p_174534_) {
        super(p_174533_);
        this.model = new SheepFurModel<>(p_174534_.bakeLayer(ModelLayers.SHEEP_FUR));
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117423_, RainbowEntity entity, float p_117425_, float p_117426_, float p_117427_, float p_117428_, float p_117429_, float p_117430_) {
        float f;
        float f1;
        float f2;
        int i = entity.tickCount / 25 + entity.getId();
        int j = DyeColor.values().length;
        int k = i % j;
        int l = (i + 1) % j;
        float f3 = ((float)(entity.tickCount % 25) + p_117427_) / 25.0F;
        float[] afloat1 = RainbowEntity.getColorArray(DyeColor.byId(k));
        float[] afloat2 = RainbowEntity.getColorArray(DyeColor.byId(l));
        f = afloat1[0] * (1.0F - f3) + afloat2[0] * f3;
        f1 = afloat1[1] * (1.0F - f3) + afloat2[1] * f3;
        f2 = afloat1[2] * (1.0F - f3) + afloat2[2] * f3;
        renderColoredCutoutModel(this.getParentModel(), TEXTURE, poseStack, bufferSource, p_117423_, entity, f, f1, f2);
    }
}