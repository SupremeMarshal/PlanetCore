package com.PlanetCore.items.Drills;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DrillRender extends GeoItemRenderer<DrillItem> {
    public DrillRender(String prefix) {
        super(new DrillModel(prefix));
    }
}
