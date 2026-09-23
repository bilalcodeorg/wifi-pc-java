package com.bilalcode.wifipc.api;

public class LastError {
    static {
        NativeLibraryLoader.load("wifi_pc_java");
    }
    public static native long code();
    public static native String reason();
}
