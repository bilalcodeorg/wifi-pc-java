package com.bilalcode.wifipc.api.external;

import com.bilalcode.wifipc.WpcScan;
import com.bilalcode.wifipc.api.NativeLibraryLoader;
import com.bilalcode.wifipc.api.NativeLibraryName;

public class Scan {
    static {
        NativeLibraryLoader.load(NativeLibraryName.WIFI_PC);
    }
    public static native WpcScan newScan();
}