package net.tutorial;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tutorial.entity.RainbowEntity;

public class TutorialEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MODID);


    //Rainbow zombie
    public static final RegistryObject<EntityType<RainbowEntity>> RAINBOW_ENTITY = register("rainbow_zombie", EntityType.Builder.of(RainbowEntity::new, MobCategory.CREATURE).sized(0.9F, 1.3F));

    public static <E extends Entity> RegistryObject<EntityType<E>> register(String id, EntityType.Builder<E> entityType) {
        return REGISTER.register(id, () -> entityType.build(TutorialMod.MODID + ":" + id));
    }
}
