package com.bilalcode.wifipc.api.external.record;

import com.bilalcode.wifipc.api.external.error.WpcExceptionCode;

public class NativeScanResult {
    private final WpcWifiNetwork[] networks;
    private final WpcExceptionCode exceptionCode;

    public NativeScanResult(WpcWifiNetwork[] networks, WpcExceptionCode exceptionCode) {
        this.networks = networks;
        this.exceptionCode = exceptionCode;
    }

    public WpcWifiNetwork[] getNetworks() {
        return networks;
    }

    public WpcExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
