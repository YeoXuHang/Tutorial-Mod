package net.tutorial;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tutorial.block.RainbowChairBlockEntity;

public class TutorialBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MODID);
    public static final RegistryObject<BlockEntityType<RainbowChairBlockEntity>> RAINBOW_CHAIR_BLOCK_ENTITY =
            REGISTER.register("rainbow_chair_entity", () ->
                    BlockEntityType.Builder.of(RainbowChairBlockEntity::new,
                            TutorialBlocks.CHAIR.get()).build(null));
}
