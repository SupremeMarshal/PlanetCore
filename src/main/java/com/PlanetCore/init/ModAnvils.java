package com.PlanetCore.init;

import com.PlanetCore.anvils.Gold.BlockGoldAnvil;
import com.PlanetCore.anvils.Silver.BlockSilverAnvil;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.PlanetCore.anvils.AnvilsHolder.*;

public class ModAnvils {
    @ObjectHolder("planetcore:silver_anvil")
    public static BlockSilverAnvil blockSilverAnvil;
    @ObjectHolder("planetcore:silver_anvil_chipped")
    public static BlockSilverAnvil blockSilverAnvilChipped;
    @ObjectHolder("planetcore:silver_anvil_damaged")
    public static BlockSilverAnvil blockSilverAnvilDamaged;
    @ObjectHolder("planetcore:gold_anvil")
    public static BlockGoldAnvil blockGoldAnvil;
    @ObjectHolder("planetcore:gold_anvil_chipped")
    public static BlockGoldAnvil blockGoldAnvilChipped;
    @ObjectHolder("planetcore:gold_anvil_damaged")
    public static BlockGoldAnvil blockGoldAnvilDamaged;

    public ModAnvils() {
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockDiamondAnvil.registerModel();
        blockDiamondAnvilChipped.registerModel();
        blockDiamondAnvilDamaged.registerModel();
        blockSilverAnvil.registerModel();
        blockSilverAnvilChipped.registerModel();
        blockSilverAnvilDamaged.registerModel();
        blockGoldAnvil.registerModel();
        blockGoldAnvilChipped.registerModel();
        blockGoldAnvilDamaged.registerModel();
    }

}
