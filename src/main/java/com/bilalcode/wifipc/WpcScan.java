package com.bilalcode.wifipc;
import com.bilalcode.wifipc.api.Scan;
import com.bilalcode.wifipc.api.WifiNetwork;
import com.bilalcode.wifipc.api.handle.ScanHandle;
import com.bilalcode.wifipc.api.handle.WifiNetworkHandle;
import com.bilalcode.wifipc.api.handle.WifiNetworkListHandle;
import com.bilalcode.wifipc.api.list.WifiNetworkList;

public class WpcScan {
    private final ScanHandle scanHandle;
    private final String[] networkNames;
    private final WpcWifiNetwork[] networks;

    public WpcScan() {
        String[] names;
        WpcWifiNetwork[] networks;
        WifiNetworkListHandle wifiNetworkListHandle;
        int wpcWifiNetworkListSize;
        this.scanHandle = Scan.newScan();

        // Preparing network list
        wifiNetworkListHandle = Scan.networkList(this.scanHandle);
        wpcWifiNetworkListSize = WifiNetworkList.size(wifiNetworkListHandle);
        networks = new WpcWifiNetwork[wpcWifiNetworkListSize];
        for (int i = 0; i < wpcWifiNetworkListSize; i++) {
            WifiNetworkHandle wifiNetworkHandle = WifiNetworkList.at(wifiNetworkListHandle);

            String ssid = WifiNetwork.getName(wifiNetworkHandle);
            short signalQuality = WifiNetwork.getSignalQuality(wifiNetworkHandle);
            boolean isSecured = WifiNetwork.isSecured(wifiNetworkHandle);

            networks[i] = new WpcWifiNetwork(ssid, signalQuality, isSecured);
        }

        // Preparing name list
        names = new String[networks.length];
        for (int i = 0; i < networks.length; i++) {
            names[i] = networks[i].getName();
        }

        this.networkNames = names;
        this.networks = networks;
    }

    public final String[] getNetworkNames() {
        return networkNames;
    }

    public WpcWifiNetwork[] getNetworks() {
        return networks;
    }

    public void closeHandle() {
        Scan.destroy(this.scanHandle);
    }
}
