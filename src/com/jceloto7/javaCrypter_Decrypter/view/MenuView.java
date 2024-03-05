package com.jceloto7.javaCrypter_Decrypter.view;

import com.jceloto7.javaCrypter_Decrypter.Bootstrap;
import com.jceloto7.javaCrypter_Decrypter.service.Crypt_DecryptService;
import com.jceloto7.javaCrypter_Decrypter.util.InputUtil;
import com.jceloto7.javaCrypter_Decrypter.util.MismatchCorrectionUtil;
import com.jceloto7.javaCrypter_Decrypter.util.ValidationUtil;

import java.util.Objects;

public class MenuView {

    public void menu(){
        String option;
        InputUtil inputUtil = Bootstrap.inputUtil;
        ValidationUtil validationUtil = Bootstrap.validationUtil;
        MismatchCorrectionUtil mismatchCorrectionUtil = Bootstrap.mismatchCorrectionUtil;
        boolean validation;
        String optionFinal;
        Crypt_DecryptService cryptDecryptService = Bootstrap.cryptDecryptService;
        String folderPath;
        String inputFinal;
        String outputFinal;
        String key;

        System.out.println("""
                Welcome to the crypt/decrypt tool.
                What do you wanna do?
                Please, type '1' to crypt or '2' to decrypt.
                """);
        option = inputUtil.getInput();
        validation = validationUtil.validation1or2(option);
        optionFinal = mismatchCorrectionUtil.retype1or2(validation,option);
        if(Objects.equals(optionFinal, "1")){
            System.out.println("What folder do you want to crypt?");
            folderPath = inputUtil.getInput();
            validation = validationUtil.validationFolder(folderPath);
            inputFinal = mismatchCorrectionUtil.retypeFolder(validation,folderPath);
            outputFinal = inputFinal + "/Encrypted";
            System.out.println("Great! Now, create a key/password");
            key = inputUtil.getInput();
            cryptDecryptService.crypt(key,inputFinal,outputFinal);
        }else{
            System.out.println("What folder do you want to decrypt?");
            folderPath = inputUtil.getInput();
            validation = validationUtil.validationFolder(folderPath);
            inputFinal = mismatchCorrectionUtil.retypeFolder(validation,folderPath);
            outputFinal = inputFinal + "/Decrypted";
            System.out.println("Now,type the crypt key.");
            key = inputUtil.getInput();


        }







    }
}
