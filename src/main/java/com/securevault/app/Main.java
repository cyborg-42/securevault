package com.securevault.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AESService {

    public byte[] encrypt(byte[] data,
                          SecretKey key,
                          byte[] iv) throws CryptoException {

        try {

            Cipher cipher =
                    Cipher.getInstance(CryptoConstants.AES_TRANSFORMATION);

            GCMParameterSpec spec =
                    new GCMParameterSpec(
                            CryptoConstants.GCM_TAG_LENGTH,
                            iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, spec);

            return cipher.doFinal(data);

        } catch (Exception e) {

            throw new CryptoException("Encryption failed.", e);

        }

    }

    public byte[] decrypt(byte[] encryptedData,
                          SecretKey key,
                          byte[] iv) throws CryptoException {

        try {

            Cipher cipher =
                    Cipher.getInstance(CryptoConstants.AES_TRANSFORMATION);

            GCMParameterSpec spec =
                    new GCMParameterSpec(
                            CryptoConstants.GCM_TAG_LENGTH,
                            iv);

            cipher.init(Cipher.DECRYPT_MODE, key, spec);

            return cipher.doFinal(encryptedData);

        } catch (Exception e) {

            throw new CryptoException("Decryption failed.", e);

        }

    }

}