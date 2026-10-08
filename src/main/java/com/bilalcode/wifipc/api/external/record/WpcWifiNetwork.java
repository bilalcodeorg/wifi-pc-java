package com.bilalcode.wifipc.api.external.record;

public final class WpcWifiNetwork {
    private final String name;
    private final short signalQuality;
    private final boolean isSecured;

    public WpcWifiNetwork(String name, short signalQuality, boolean isSecured) {
        this.name = name;
        this.signalQuality = signalQuality;
        this.isSecured = isSecured;
    }

    public String getName() {
        return name;
    }

    public short getSignalQuality() {
        return signalQuality;
    }

    public boolean isSecured() {
        return isSecured;
    }
}
