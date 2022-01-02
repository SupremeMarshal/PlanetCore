package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityCoreDemon;
import com.PlanetCore.entity.EntityDemon;
import com.PlanetCore.entity.EntityHotBlaze;
import com.PlanetCore.entity.model.ModelCoreDemon;
import com.PlanetCore.entity.model.ModelDemon;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGiantZombie;
import org.lwjgl.opengl.GL11;
import software.bernie.geckolib3.geo.render.built.GeoCube;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RenderCoreDemon extends GeoEntityRenderer<EntityCoreDemon>{
	public RenderCoreDemon(RenderManager renderManager) {
		super(renderManager, new ModelCoreDemon());
	}

	@Override
	public void render(GeoModel model, EntityCoreDemon animatable, float partialTicks, float red, float green, float blue, float alpha) {
		GlStateManager.scale(2.0F, 2.0F, 2.0F);
		super.render(model, animatable, partialTicks, red,green,blue,alpha);
	}
}