package com.bilalcode.wifipc.api;

import com.bilalcode.wifipc.api.handle.WifiNetworkHandle;

public class WifiNetwork {
    public static native String getName(WifiNetworkHandle handle);
    public static native boolean isSecured(WifiNetworkHandle handle);
    public static native short getSignalQuality(WifiNetworkHandle handle);
}