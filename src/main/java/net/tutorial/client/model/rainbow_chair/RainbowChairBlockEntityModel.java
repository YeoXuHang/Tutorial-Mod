package net.tutorial.client.model.rainbow_chair;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.tutorial.TutorialMod;
import net.tutorial.block.RainbowChairBlockEntity;

public class RainbowChairBlockEntityModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TutorialMod.MODID, "rainbowchairblockentity"), "main");
	public final ModelPart rainbow_chair;

	public RainbowChairBlockEntityModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.rainbow_chair = root.getChild("rainbow_chair");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rainbow_chair = partdefinition.addOrReplaceChild("rainbow_chair", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -12.0F, 6.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -12.0F, -8.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, -12.0F, 6.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, -12.0F, -8.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -14.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-8.0F, -26.0F, 6.0F, 16.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}



	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

		//rainbow_chair.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}