package com.bilalcode.wifipc.api.list;

import com.bilalcode.wifipc.api.handle.WifiNetworkHandle;
import com.bilalcode.wifipc.api.handle.WifiNetworkListHandle;

public class WifiNetworkList {
    public static native WifiNetworkHandle at(WifiNetworkListHandle handle);
    public static native int size(WifiNetworkListHandle handle);
}