package com.jceloto7.javaCrypter_Decrypter.util;

import com.jceloto7.javaCrypter_Decrypter.Bootstrap;

public class MismatchCorrectionUtil {

    private static final InputUtil inputUtil = Bootstrap.inputUtil;
    private static final ValidationUtil validationUtil = Bootstrap.validationUtil;

    public String retype1or2(boolean validation, String input){
        while(!validation){
            System.out.println("Invalid input. Please just type '1' or '2'.");
            input = inputUtil.getInput();
            validation = validationUtil.validation1or2(input);
        }
        return input;

    }

    public String retypeFolder(boolean validation, String input){
        while(!validation){
            System.out.println("Invalid directory. Please try again.");
            input = inputUtil.getInput();
            validation = validationUtil.validationFolder(input);
        }

        return input;
    }

}
