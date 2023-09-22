package com.PlanetCore.items.Drills;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IronDrillRender extends GeoItemRenderer<IronDrillItem> {
    public IronDrillRender() {
        super(new IronDrillModel());
    }
}
