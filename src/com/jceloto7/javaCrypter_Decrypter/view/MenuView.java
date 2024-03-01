// catch by input (screen) the folder and the key and create the output folder based in input folder

package com.jceloto7.javaCrypter_Decrypter.view;

import com.jceloto7.javaCrypter_Decrypter.Bootstrap;
import com.jceloto7.javaCrypter_Decrypter.util.InputUtil;
import com.jceloto7.javaCrypter_Decrypter.util.MismatchCorrectionUtil;
import com.jceloto7.javaCrypter_Decrypter.util.ValidationUtil;

public class MenuView {

    public void menu(){
        String option;
        InputUtil inputUtil = Bootstrap.inputUtil;
        ValidationUtil validationUtil = Bootstrap.validationUtil;
        MismatchCorrectionUtil mismatchCorrectionUtil = Bootstrap.mismatchCorrectionUtil;
        boolean validation;
        String optionFinal;

        System.out.println("""
                Welcome to the crypt/decrypt tool.
                What do you wanna do?
                Please, type '1' to crypt or '2' to decrypt.
                """);
        option = inputUtil.getInput();
        validation = validationUtil.validation1or2(option);
        optionFinal = mismatchCorrectionUtil.retype1or2(validation,option);







    }
}
