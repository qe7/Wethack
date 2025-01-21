package wethack.events.impl;

import net.minecraft.src.ScaledResolution;
import wethack.events.Event;

public final class RenderScreenEvent extends Event {

    private final ScaledResolution scaledResolution;

    public RenderScreenEvent(ScaledResolution scaledResolution) {
        this.scaledResolution = scaledResolution;
    }

    public ScaledResolution getScaledResolution() {
        return scaledResolution;
    }
}
