package com.securevault.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;

public class AESService {

    public String encrypt(String plainText, SecretKey key, byte[] iv)
            throws CryptoException {

        try {

            Cipher cipher =
                    Cipher.getInstance(CryptoConstants.AES_TRANSFORMATION);

            GCMParameterSpec spec =
                    new GCMParameterSpec(
                            CryptoConstants.GCM_TAG_LENGTH,
                            iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, spec);

            byte[] encrypted =
                    cipher.doFinal(plainText.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {

            throw new CryptoException("Encryption failed", e);

        }

    }

    public String decrypt(String encryptedText,
                          SecretKey key,
                          byte[] iv)
            throws CryptoException {

        try {

            Cipher cipher =
                    Cipher.getInstance(CryptoConstants.AES_TRANSFORMATION);

            GCMParameterSpec spec =
                    new GCMParameterSpec(
                            CryptoConstants.GCM_TAG_LENGTH,
                            iv);

            cipher.init(Cipher.DECRYPT_MODE, key, spec);

            byte[] decoded =
                    Base64.getDecoder().decode(encryptedText);

            byte[] decrypted =
                    cipher.doFinal(decoded);

            return new String(decrypted);

        } catch (Exception e) {

            throw new CryptoException("Decryption failed", e);

        }

    }

}