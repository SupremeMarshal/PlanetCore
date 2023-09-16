package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityOnyxDemon;
import com.PlanetCore.entity.model.ModelOnyxDemon;
import com.PlanetCore.entity.render.layers.LayerOnyxDemonEyes;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RenderOnyxDemon extends GeoEntityRenderer<EntityOnyxDemon> {
	public RenderOnyxDemon(RenderManager renderManager) {
		super(renderManager, new ModelOnyxDemon());
		this.addLayer(new LayerOnyxDemonEyes(this));
	}

	@Override
	public void render(GeoModel model, EntityOnyxDemon animatable, float partialTicks, float red, float green, float blue, float alpha) {
		GlStateManager.scale(1.0F, 1.0F, 1.0F);
		super.render(model, animatable, partialTicks, red, green, blue, alpha);
	}
}