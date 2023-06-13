package net.tutorial.entity;

import com.google.common.collect.Maps;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RainbowEntity extends Zombie {

    private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR = Maps.<DyeColor, float[]>newEnumMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((p_29868_) -> p_29868_, RainbowEntity::createColor)));public RainbowEntity(EntityType<? extends Zombie> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    private static float[] createColor(DyeColor color) {
        if (color == DyeColor.WHITE) {
            return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
        } else {
            float[] afloat = color.getTextureDiffuseColors();
            float f = 0.75F;
            return new float[]{afloat[0] * f, afloat[1] * f, afloat[2] * f};
        }
    }

    public static float[] getColorArray(DyeColor dyeColor) {
        return COLORARRAY_BY_COLOR.get(dyeColor);
    }
}
