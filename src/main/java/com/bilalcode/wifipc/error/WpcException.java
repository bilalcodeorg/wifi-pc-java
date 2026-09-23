package com.bilalcode.wifipc.error;

public class WpcException extends RuntimeException {
    public WpcException() {
        super("some error occurred");
    }
    public WpcException(String msg) {
        super(msg);
    }
}