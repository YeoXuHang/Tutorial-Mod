package net.tutorial.block;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tutorial.TutorialBlockEntities;
import net.tutorial.entity.RainbowEntity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RainbowChairBlockEntity extends BlockEntity {
    public static float[] getColorArray(DyeColor dyeColor) {
        return COLORARRAY_BY_COLOR.get(dyeColor);
    }

    private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR = Maps.<DyeColor, float[]>newEnumMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((p_29868_) -> p_29868_, RainbowChairBlockEntity::createColor)));
    private static float[] createColor(DyeColor color) {
        if (color == DyeColor.WHITE) {
            return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
        } else {
            float[] afloat = color.getTextureDiffuseColors();
            float f = 0.75F;
            return new float[]{afloat[0] * f, afloat[1] * f, afloat[2] * f};
        }
    }
    public int age;

    public int tick() {
        age++;
        int i = age / 30;
        return i;
    }
    public RainbowChairBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(TutorialBlockEntities.RAINBOW_CHAIR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }
}
