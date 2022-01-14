package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityDemon;
import com.PlanetCore.entity.model.ModelDemon;
import com.PlanetCore.entity.render.layers.LayerDemonEyes;
import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RenderDemon extends GeoEntityRenderer<EntityDemon>{
	public RenderDemon(RenderManager renderManager) {
		super(renderManager, new ModelDemon());
		this.addLayer(new LayerDemonEyes(this));
	}
}