package com.PlanetCore.items;

import com.PlanetCore.init.ArmorMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
* needed because PickaxeItem's constructor is protected
 */
public class ItemPickaxeX extends ItemPickaxe {
    public ItemPickaxeX(ToolMaterial material) {
        super(material);
        this.attackDamage = material.getAttackDamage() * 0.7F;
        this.attackSpeed = -1F;
    }
}
