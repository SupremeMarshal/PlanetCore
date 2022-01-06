package com.PlanetCore.items;

import com.PlanetCore.blocks.GemsGravel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemSpadeX extends ItemSpade {

    public ItemSpadeX(ToolMaterial material) {
        super(material);
        this.efficiency = toolMaterial.getEfficiency();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
                return efficiency;
        }
        return state.getBlock() instanceof GemsGravel ? efficiency : 1.0F;
    }
}
