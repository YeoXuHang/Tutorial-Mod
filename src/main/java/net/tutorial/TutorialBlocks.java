package net.tutorial;

import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tutorial.block.RainbowChairBlock;

public class TutorialBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MODID);
    public static final RegistryObject<Block> CHAIR = registerBlock("rainbow_chair",
            () -> new RainbowChairBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO).noOcclusion().lightLevel((p_60929_) -> {
                return 8;
            })), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = REGISTER.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return TutorialItems.REGISTER.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
}
