package com.jceloto7.javaCrypter_Decrypter.controller;

import com.jceloto7.javaCrypter_Decrypter.service.Crypt_DecryptService;

public class Crypt_DecryptController {
    private final Crypt_DecryptService cryptDecryptService;

    public Crypt_DecryptController(Crypt_DecryptService cryptDecryptService){
        this.cryptDecryptService = cryptDecryptService;
    }

    public void crypt(String key, String inputFile,String outputFile){
        try{
            cryptDecryptService.crypt(key,inputFile,outputFile);
        }catch (Exception ex){
            System.out.println("An unexpected error has occurred. Please try again.");
        }
    }

    public void decrypt(String key, String inputFile,String outputFile){
        try{
            cryptDecryptService.decrypt(key,inputFile,outputFile);
        }catch (Exception ex){
            System.out.println("An unexpected error has occurred. Please try again.");
        }
    }
}
