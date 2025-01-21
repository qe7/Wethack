package wethack.events.impl;

import wethack.events.Event;

public final class KeyBindEvent extends Event {

    private final int keyBind;

    public KeyBindEvent(int keyBind) {
        this.keyBind = keyBind;
    }

    public int getKeyBind() {
        return keyBind;
    }
}
