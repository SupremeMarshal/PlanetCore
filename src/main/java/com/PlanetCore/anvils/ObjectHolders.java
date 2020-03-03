package com.PlanetCore.anvils;


import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ObjectHolders {
    @ObjectHolder("planetcore:stone_anvil")
    public static BlockGenericAnvil blockStoneAnvil;
    @ObjectHolder("planetcore:stone_anvil_chipped")
    public static BlockGenericAnvil blockStoneAnvilChipped;
    @ObjectHolder("planetcore:stone_anvil_damaged")
    public static BlockGenericAnvil blockStoneAnvilDamaged;
    @ObjectHolder("planetcore:gold_anvil")
    public static BlockGenericAnvil blockGoldAnvil;
    @ObjectHolder("planetcore:gold_anvil_chipped")
    public static BlockGenericAnvil blockGoldAnvilChipped;
    @ObjectHolder("planetcore:gold_anvil_damaged")
    public static BlockGenericAnvil blockGoldAnvilDamaged;
    @ObjectHolder("planetcore:diamond_anvil")
    public static BlockGenericAnvil blockDiamondAnvil;
    @ObjectHolder("planetcore::diamond_anvil_chipped")
    public static BlockGenericAnvil blockDiamondAnvilChipped;
    @ObjectHolder("planetcore:diamond_anvil_damaged")
    public static BlockGenericAnvil blockDiamondAnvilDamaged;
    @ObjectHolder("planetcore:lead_anvil")
    public static BlockGenericAnvil blockLeadAnvil;
    @ObjectHolder("planetcore:lead_anvil_chipped")
    public static BlockGenericAnvil blockLeadAnvilChipped;
    @ObjectHolder("planetcore:diamond_anvil_damaged")
    public static BlockGenericAnvil blockLeadAnvilDamaged;

    public ObjectHolders() {
    }
}
