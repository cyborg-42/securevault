package com.securevault.app;

import com.securevault.crypto.KeyGeneratorUtil;

import javax.crypto.SecretKey;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {

        try {

            SecretKey key = KeyGeneratorUtil.generateAESKey();

            System.out.println("=================================");
            System.out.println(" SecureVault");
            System.out.println("=================================");
            System.out.println("AES Key Generated Successfully!");
            System.out.println();
            System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}