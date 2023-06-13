package net.tutorial.client.renderer.rainbow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tutorial.TutorialMod;
import net.tutorial.block.RainbowChairBlockEntity;
import net.tutorial.client.model.rainbow_chair.RainbowChairBlockEntityModel;
import net.tutorial.entity.RainbowEntity;
public class RainbowChairRenderer <T extends RainbowChairBlockEntity> implements BlockEntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID,"textures/entity/rainbow_entity/rainbow_chair.png");

    RainbowChairBlockEntityModel rainbowChairBlockEntity;

    public RainbowChairRenderer(BlockEntityRendererProvider.Context context) {
        rainbowChairBlockEntity = new RainbowChairBlockEntityModel(context.bakeLayer(RainbowChairBlockEntityModel.LAYER_LOCATION));
    }
    @Override
    public void render(T p_112307_, float p_112308_, PoseStack poseStack, MultiBufferSource p_112310_, int p_112311_, int p_112312_) {
        float f;
        float f1;
        float f2;
        int i = p_112307_.tick() / 25 + p_112307_.tick();
        int j = DyeColor.values().length;
        int k = i % j;
        int l = (i + 1) % j;
        float f3 = ((float)(p_112307_.tick() % 25) + i) / 25.0F;
        float[] afloat1 = RainbowChairBlockEntity.getColorArray(DyeColor.byId(k));
        float[] afloat2 = RainbowChairBlockEntity.getColorArray(DyeColor.byId(l));
        f = afloat1[0] * (1.0F - f3) + afloat2[0] * f3;
        f1 = afloat1[1] * (1.0F - f3) + afloat2[1] * f3;
        f2 = afloat1[2] * (1.0F - f3) + afloat2[2] * f3;
        VertexConsumer vertexconsumer = p_112310_.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
        rainbowChairBlockEntity.rainbow_chair.setPos(-1F, -3F, -1F);
        this.rainbowChairBlockEntity.rainbow_chair.render(poseStack, vertexconsumer, p_112311_, p_112312_, p_112308_, f, f1, f3);
        //renderColoredCutoutModel(rainbowChairBlockEntity, TEXTURE, poseStack, p_112310_, p_112311_, p_112307_, f, f1, f2);
    }


    protected static <T extends BlockEntity> void renderColoredCutoutModel(Model model, ResourceLocation resourceLocation, PoseStack poseStack, MultiBufferSource multiBufferSource, int p_117381_, T p_117382_, float p_117383_, float p_117384_, float p_117385_) {
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        model.renderToBuffer(poseStack, vertexconsumer, p_117381_, 0, p_117383_, p_117384_, p_117385_, 1.0F);
    }
}
