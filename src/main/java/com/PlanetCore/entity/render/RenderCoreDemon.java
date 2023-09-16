package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityCoreDemon;
import com.PlanetCore.entity.model.ModelCoreDemon;
import com.PlanetCore.entity.render.layers.LayerCoreDemonEyes;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RenderCoreDemon extends GeoEntityRenderer<EntityCoreDemon>{
	public RenderCoreDemon(RenderManager renderManager) {
		super(renderManager, new ModelCoreDemon());
		this.addLayer(new LayerCoreDemonEyes(this));
	}

	@Override
	public void render(GeoModel model, EntityCoreDemon animatable, float partialTicks, float red, float green, float blue, float alpha) {
		GlStateManager.scale(1.0F, 1.0F, 1.0F);
		super.render(model, animatable, partialTicks, red,green,blue,alpha);
	}
}