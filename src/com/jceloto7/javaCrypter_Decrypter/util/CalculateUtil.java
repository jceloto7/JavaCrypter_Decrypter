package com.jceloto7.javaCrypter_Decrypter.util;

import java.security.MessageDigest;

public class CalculateUtil {

    public  String calculateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            System.out.println("An unexpected error has occurred. Please try again.");
            return null;
        }
    }
}
