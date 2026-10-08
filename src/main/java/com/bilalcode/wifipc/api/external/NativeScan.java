package com.bilalcode.wifipc.api.external;

import com.bilalcode.wifipc.api.NativeLibraryLoader;
import com.bilalcode.wifipc.api.NativeLibraryName;
import com.bilalcode.wifipc.api.external.record.NativeScanResult;

public class NativeScan {
    static {
        NativeLibraryLoader.load(NativeLibraryName.WIFI_PC);
    }
    public static native NativeScanResult newScan();
}