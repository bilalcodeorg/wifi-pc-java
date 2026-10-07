package com.bilalcode.wifipc;
import com.bilalcode.wifipc.api.external.Scan;
import com.bilalcode.wifipc.error.WpcException;
import com.bilalcode.wifipc.error.WpcExceptionCode;
import com.bilalcode.wifipc.record.WpcWifiNetwork;

public class WpcScan {
    private final String[] networkNames;
    private final WpcWifiNetwork[] networks;

    /**
     * Start scanning for Wi-Fi.
     * <p> Create an object which contains the result of the scanned networks.</p>
     * @throws WpcException when and why it is thrown
     */
    public WpcScan() {
        WpcScan scan = Scan.newScan();
        this.networkNames = scan.networkNames;
        this.networks = scan.networks;
    }
    private WpcScan(WpcWifiNetwork[] networks) {
        String[] networkNames;
        this.networks = networks;

        networkNames = new String[networks.length];
        for (int i = 0; i < networks.length; i++) {
            networkNames[i] = networks[i].getName();
        }

        this.networkNames = networkNames;
    }

    private WpcScan(WpcWifiNetwork[] networks, WpcExceptionCode exception) {
        this(networks);

        if (exception.getCode() == WpcExceptionCode.NOT_PRESENT) return;

        if (exception.getCode() == WpcExceptionCode.WIFI_OFF) {
            throw new WpcException("System wifi might be turned off");
        }
        else {
            throw new WpcException("General error");
        }
    }

    /**
     * Get a list of Wi-Fi names.
     * @return array of string
     */
    public final String[] getNetworkNames() {
        return networkNames;
    }

    /**
     * Get a list of Wi-Fi networks.
     * <p> From WpcWifiNetwork object you get multiple properties of wireless network including its name. </p>
     * @return object of WifiNetwork
     */
    public WpcWifiNetwork[] getNetworks() {
        return networks;
    }
}
