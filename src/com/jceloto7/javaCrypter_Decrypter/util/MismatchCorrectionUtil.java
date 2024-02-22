package com.jceloto7.javaCrypter_Decrypter.util;

import com.jceloto7.javaCrypter_Decrypter.Bootstrap;

public class MismatchCorrectionUtil {

    public String retype1or2(boolean validation, String input){
        InputUtil inputUtil = Bootstrap.inputUtil;
        ValidationUtil validationUtil = Bootstrap.validationUtil;

        while(!validation){
            System.out.println("Invalid input. Please just type '1' or '2'.");
            input = inputUtil.getInput();
            validation = validationUtil.validation1or2(input);
        }

        return input;

    }

}
