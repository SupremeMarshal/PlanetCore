package com.PlanetCore.init;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class CoreLavaFluid extends BlockFluidClassic {

	public CoreLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);

		setLightLevel(1);
		setDensity(400);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}





	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityPlayerMP)
		{
			//EntityPlayerMP player = (EntityPlayerMP) entityIn;
			//no protection = 10 damage each second (without the normal lava damage)
			//Full Amazonite protect 100%

			//no protection


				entityIn.attackEntityFrom(DamageSource.GENERIC, 8.0F);
		}		
	}


	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}
