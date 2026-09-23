package com.bilalcode.wifipc.error;

public class WpcExceptionCode {
    private final long code;
    public static final long NOT_PRESENT = 0;
    public static final long GENERAL_ERROR = 1;
    public static final long WIFI_OFF = 2;
    WpcExceptionCode(long code) {
        this.code = code;
    }
    public long getCode() {
        return code;
    }
}
