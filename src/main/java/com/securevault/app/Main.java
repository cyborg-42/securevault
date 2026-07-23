package com.securevault.app;

import com.securevault.crypto.IVGenerator;

import java.util.Base64;

public class Main {

    public static void main(String[] args) {

        byte[] iv = IVGenerator.generateIV();

        System.out.println("==================================");
        System.out.println(" SecureVault");
        System.out.println("==================================");

        System.out.println("Generated IV:");

        System.out.println(Base64.getEncoder().encodeToString(iv));

    }
}