package com.bilalcode.wifipc;
import com.bilalcode.wifipc.api.external.NativeScan;
import com.bilalcode.wifipc.api.external.record.NativeScanResult;
import com.bilalcode.wifipc.error.WpcException;
import com.bilalcode.wifipc.api.external.record.WpcWifiNetwork;

public class WpcScan {
    private final String[] networkNames;
    private final WpcWifiNetwork[] networks;

    /**
     * Start scanning for Wi-Fi.
     * <p> Create an object which contains the result of the scanned networks.</p>
     * @throws WpcException when and why it is thrown
     */
    public WpcScan() {
        String[] networkNames;
        NativeScanResult scanResult = NativeScan.newScan();
        this.networks = scanResult.getNetworks();

        networkNames = new String[this.getNetworks().length];
        for (int i = 0; i < networkNames.length; i++) {
            networkNames[i] = this.getNetworks()[i].getName();
        }
        this.networkNames = networkNames;
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
