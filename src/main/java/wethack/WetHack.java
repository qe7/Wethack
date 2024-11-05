package wethack;

public final class WetHack {

    public static final WetHack INSTANCE = new WetHack();

    private final String name, version;

    private WetHack() {
        this.name = "WetHack";
        this.version = "1.0";
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
