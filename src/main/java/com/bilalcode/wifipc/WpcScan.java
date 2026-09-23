package com.bilalcode.wifipc;
import com.bilalcode.wifipc.api.external.Scan;
import com.bilalcode.wifipc.error.WpcException;
import com.bilalcode.wifipc.error.WpcExceptionCode;

public class WpcScan {
    private final String[] networkNames;
    private final WpcWifiNetwork[] networks;

    public WpcScan() {
        WpcScan scan = Scan.newScan();
        this.networkNames = scan.networkNames;
        this.networks = scan.networks;
    }
    public WpcScan(WpcWifiNetwork[] networks) {
        String[] networkNames;
        this.networks = networks;

        networkNames = new String[networks.length];
        for (int i = 0; i < networks.length; i++) {
            networkNames[i] = networks[i].getName();
        }

        this.networkNames = networkNames;
    }

    public WpcScan(WpcWifiNetwork[] networks, WpcExceptionCode exception) {
        this(networks);

        if (exception.getCode() == WpcExceptionCode.NOT_PRESENT) return;

        if (exception.getCode() == WpcExceptionCode.WIFI_OFF) {
            throw new WpcException("System wifi might be turned off");
        }
        else {
            throw new WpcException("General error");
        }
    }

    public final String[] getNetworkNames() {
        return networkNames;
    }

    public WpcWifiNetwork[] getNetworks() {
        return networks;
    }
}
