package com.securevault.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public final class KeyGeneratorUtil {

    private KeyGeneratorUtil() {
    }

    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {

        KeyGenerator keyGenerator =
                KeyGenerator.getInstance(CryptoConstants.AES_ALGORITHM);

        keyGenerator.init(CryptoConstants.AES_KEY_SIZE);

        return keyGenerator.generateKey();
    }
}