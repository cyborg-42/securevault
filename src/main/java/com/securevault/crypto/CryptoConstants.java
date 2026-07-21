package com.securevault.crypto;

public final class CryptoConstants {

    // Prevent instantiation
    private CryptoConstants() {
    }

    // AES Configuration
    public static final String AES_ALGORITHM = "AES";
    public static final String AES_TRANSFORMATION = "AES/GCM/NoPadding";

    // AES Key Size
    public static final int AES_KEY_SIZE = 256;

    // GCM Configuration
    public static final int GCM_IV_LENGTH = 12;      // 12 bytes (96 bits)
    public static final int GCM_TAG_LENGTH = 128;    // 128-bit authentication tag

}