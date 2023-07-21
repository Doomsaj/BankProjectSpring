package com.doomsaj.bank_project_spring.utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class SecurityUtils {
    public static class RSA {
        public static KeyPair getPair() {
            KeyPairGenerator generator = null;
            try {
                generator = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            generator.initialize(2048);
            return generator.generateKeyPair();
        }

        public static String encrypt(String message, PublicKey publicKey) {
            String encryptedMessage = "";
            try {
                Cipher encrypter = Cipher.getInstance("RSA");
                encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
                byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
                byte[] encryptedMessageBytes = encrypter.doFinal(messageBytes);
                encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return encryptedMessage;
        }

        public static String decrypt(String encrypted, PrivateKey privateKey) {
            String decryptedMessage = "";
            try {
                Cipher decryptCipher = Cipher.getInstance("RSA");
                decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
                byte[] encryptedMessageBytes = Base64.getDecoder().decode(encrypted);
                byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
                decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return decryptedMessage;
        }
    }
}

