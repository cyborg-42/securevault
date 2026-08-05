package com.securevault.app;

import com.securevault.crypto.AESService;
import com.securevault.crypto.IVGenerator;
import com.securevault.crypto.KeyGeneratorUtil;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try {

            SecretKey key = KeyGeneratorUtil.generateAESKey();

            byte[] iv = IVGenerator.generateIV();

            AESService aes = new AESService();

            String message = "Welcome to SecureVault!";

            byte[] encrypted =
                    aes.encrypt(
                            message.getBytes(StandardCharsets.UTF_8),
                            key,
                            iv);

            byte[] decrypted =
                    aes.decrypt(
                            encrypted,
                            key,
                            iv);

            System.out.println("Original : " + message);
            System.out.println("Encrypted Length : " + encrypted.length);
            System.out.println("Recovered : "
                    + new String(decrypted, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}