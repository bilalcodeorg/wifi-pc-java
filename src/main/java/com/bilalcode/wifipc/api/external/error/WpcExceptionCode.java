package com.bilalcode.wifipc.api.external.error;

public class WpcExceptionCode {
    public static final long NOT_PRESENT = 0;
    public static final long GENERAL_ERROR = 1;
    public static final long WIFI_OFF = 2;
    private final long code;
    public WpcExceptionCode(long code) {
        this.code = code;
    }
    public long getCode() {
        return code;
    }
}
