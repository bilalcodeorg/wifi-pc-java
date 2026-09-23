package com.bilalcode.wifipc.error;

public class WpcWifiOffException extends RuntimeException {
    public WpcWifiOffException() {
        super("device wifi might be turned off");
    }
    public WpcWifiOffException(String msg) {
        super(msg);
    }
}