package com.jceloto7.javaCrypter_Decrypter.service;

import com.IC2379.Crypter.controller.Crypter;
import com.jceloto7.javaCrypter_Decrypter.Bootstrap;

import java.io.File;

public class Crypt_DecryptService {
    private final Crypter crypter = Bootstrap.crypter;

    public void crypt(String key, String inputFile,String outputFile){
        crypter.cryptFile(key, inputFile, outputFile);
        File encryptedFolder = new File(outputFile + File.separator + "Encrypted");
        encryptedFolder.mkdirs();
    }

    public void decrypt(String key, String inputFile,String outputFile){
        crypter.decryptFile(key, inputFile, outputFile);
        File decryptedFolder = new File(inputFile + File.separator + "Decrypted");
        decryptedFolder.mkdirs();
    }
}
