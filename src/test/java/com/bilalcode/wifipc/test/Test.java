package com.bilalcode.wifipc.test;

import com.bilalcode.wifipc.WpcScan;
import com.bilalcode.wifipc.WpcWifiNetwork;

public class Test {
    public static void main(String[] args) {
        WpcScan scan = new WpcScan();

        for(final WpcWifiNetwork network : scan.getNetworks()) {
            System.out.println(network.getName() + " | Signal: " + network.getSignalQuality() + " | Is secured ?: " + network.isSecured());
        }
    }
}
