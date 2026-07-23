package com.securevault.crypto;

import java.security.SecureRandom;

public final class IVGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    private IVGenerator() {
    }

    public static byte[] generateIV() {

        byte[] iv = new byte[CryptoConstants.GCM_IV_LENGTH];

        secureRandom.nextBytes(iv);

        return iv;
    }
}