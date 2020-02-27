package com.SupremeMarshal.ToTheEarthCore.entity.render;


import com.SupremeMarshal.ToTheEarthCore.entity.EntityDeathEnderman;
import com.SupremeMarshal.ToTheEarthCore.entity.render.layers.LayerDeathEndermanEyes;
import com.SupremeMarshal.ToTheEarthCore.entity.render.layers.LayerHeldBlock;
import com.SupremeMarshal.ToTheEarthCore.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class RenderDeathEnderman extends RenderLiving<EntityDeathEnderman> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/death_enderman.png");
	private final Random rnd = new Random();


	public RenderDeathEnderman(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelEnderman(0.0F), 0.5F);
		this.addLayer(new LayerDeathEndermanEyes(this));
		this.addLayer(new LayerHeldBlock(this));
	}

	public ModelEnderman getMainModel()
	{
		return (ModelEnderman)super.getMainModel();
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	public void doRender(EntityEnderman entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		IBlockState iblockstate = entity.getHeldBlockState();
		ModelEnderman modelenderman = this.getMainModel();
		modelenderman.isCarrying = iblockstate != null;
		modelenderman.isAttacking = entity.isScreaming();

		if (entity.isScreaming())
		{
			double d0 = 0.02D;
			x += this.rnd.nextGaussian() * 0.02D;
			z += this.rnd.nextGaussian() * 0.02D;
		}

		super.doRender((EntityDeathEnderman) entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDeathEnderman entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityDeathEnderman entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
