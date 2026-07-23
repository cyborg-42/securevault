package com.securevault.app;

import com.securevault.crypto.*;

import javax.crypto.SecretKey;

public class Main {

    public static void main(String[] args) {

        try {

            SecretKey key = KeyGeneratorUtil.generateAESKey();

            byte[] iv = IVGenerator.generateIV();

            AESService aes = new AESService();

            String message = "Hello SecureVault!";

            System.out.println("Original:");
            System.out.println(message);

            String encrypted =
                    aes.encrypt(message, key, iv);

            System.out.println("\nEncrypted:");
            System.out.println(encrypted);

            String decrypted =
                    aes.decrypt(encrypted, key, iv);

            System.out.println("\nDecrypted:");
            System.out.println(decrypted);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}