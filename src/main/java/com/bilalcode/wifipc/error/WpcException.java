package com.bilalcode.wifipc.error;

public class WpcException extends RuntimeException {
    public WpcException(String msg) {
        super("WpcException: " + msg);
    }
}