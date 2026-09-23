package com.bilalcode.wifipc.api;

import com.bilalcode.wifipc.api.handle.ScanHandle;
import com.bilalcode.wifipc.api.handle.WifiNetworkListHandle;

public class Scan {
    public static native ScanHandle newScan();
    public static native WifiNetworkListHandle networkList(ScanHandle handle);
    public static native void destroy(ScanHandle handle);
}