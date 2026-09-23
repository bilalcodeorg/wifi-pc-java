package com.bilalcode.wifipc.test;

import com.bilalcode.wifipc.api.LastError;

public class Test {
    public static void main(String[] args) {
        System.out.println(LastError.code());
    }
//    public static void main(String[] args) {
//        // 1. Where does the classloader think the resource is?
//        java.net.URL url = Test.class.getResource("/dir/.gitkeep");
//        System.out.println("getResource() -> " + url);
//
//        // 2. Try converting to a URI/path (works if NOT inside a jar)
//        if (url != null) {
//            try {
//                System.out.println("toURI() -> " + url.toURI());
//            } catch (Exception e) {
//                System.out.println("toURI() failed: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Resource not found on classpath!");
//        }
//
//        // 3. Where is the classpath root itself?
//        java.net.URL classLoc = Test.class.getProtectionDomain()
//                .getCodeSource().getLocation();
//        System.out.println("Classpath root -> " + classLoc);
//
//        // 4. Full classpath being used
//        System.out.println("java.class.path -> " + System.getProperty("java.class.path"));
//    }
}
