package com.bilalcode.wifipc.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class NativeLibraryLoader {

    private static volatile boolean loaded = false;

    public static synchronized void load(String libName) {
        if (loaded) return;

        final String PLATFORM_DIR = detectPlatformDir();
        final String LIB_FILE_NAME = detectLibFileName(libName);
        final String RESOURCE_PATH = "/bin/" + PLATFORM_DIR + "/" + LIB_FILE_NAME;

        loadFromResources(RESOURCE_PATH);
    }

    private static void loadFromResources(String resourcePath) {
        try (InputStream in = NativeLibraryLoader.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new RuntimeException("Native library not found in resources: " + resourcePath);
            }

            String suffix = resourcePath.substring(resourcePath.lastIndexOf('.'));
            File temp = File.createTempFile("mylib", suffix);
            temp.deleteOnExit();

            Files.copy(in, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.load(temp.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native library", e);
        }
    }

    private static String detectPlatformDir() {
        String os = System.getProperty("os.name").toLowerCase();
        String arch = normalizeArch(System.getProperty("os.arch"));

        String osPart;
        if (os.contains("win")) {
            osPart = "windows";
        } else if (os.contains("mac") || os.contains("darwin")) {
            osPart = "macos";
        } else if (os.contains("nux") || os.contains("nix")) {
            osPart = "linux";
        } else {
            throw new UnsatisfiedLinkError("Unsupported OS: " + os);
        }

        return osPart + "-" + arch;
    }

    private static String normalizeArch(String rawArch) {
        String arch = rawArch.toLowerCase();
        if (arch.equals("x86_64") || arch.equals("amd64")) {
            return "x64";
        } else if (arch.equals("aarch64") || arch.equals("arm64")) {
            return "arm64";
        }
        throw new UnsatisfiedLinkError("Unsupported architecture: " + rawArch);
    }

    private static String detectLibFileName(String libName) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return libName + ".dll";
        } else if (os.contains("mac") || os.contains("darwin")) {
            return "lib" + libName + ".dylib";
        } else {
            return "lib" + libName + ".so";
        }
    }
}