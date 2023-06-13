package net.tutorial;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tutorial.client.model.rainbow_chair.RainbowChairBlockEntityModel;
import net.tutorial.client.renderer.rainbow.RainbowChairRenderer;
import net.tutorial.client.renderer.rainbow.RainbowEntityRenderer;
import net.tutorial.entity.RainbowEntity;

// The mod id should match with META-INF/mods.toml file
@Mod(TutorialMod.MODID)
public class TutorialMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "tutorial_mod";
    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the entityAttributeEvent method for modloading
        modEventBus.addListener(this::entityAttributeEvent);
        // Register the Deferred Register to the mod event bus so entities get registered
        TutorialItems.REGISTER.register(modEventBus);
        TutorialBlocks.REGISTER.register(modEventBus);
        TutorialBlockEntities.REGISTER.register(modEventBus);
        TutorialEntities.REGISTER.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(TutorialEntities.RAINBOW_ENTITY.get(), RainbowEntity.createAttributes().build());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(TutorialEntities.RAINBOW_ENTITY.get(), RainbowEntityRenderer::new);
            BlockEntityRenderers.register(TutorialBlockEntities.RAINBOW_CHAIR_BLOCK_ENTITY.get(), RainbowChairRenderer::new);

        }
        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(RainbowChairBlockEntityModel.LAYER_LOCATION, RainbowChairBlockEntityModel::createBodyLayer);
        }
    }
}
