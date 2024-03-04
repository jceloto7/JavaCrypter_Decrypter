package com.jceloto7.javaCrypter_Decrypter.util;

import java.io.File;
public class ValidationUtil {
    public boolean validation1or2(String input) {
        char[] option = input.toCharArray();
        boolean validation;

        validation = option.length <= 1 && (option[0] == '1' || option[0] == '2'); // If these options confirm the validation will be 'true'
        return validation;

    }

    public boolean validationFolder(String input){
        File folder = new File(input);
        return folder.exists() && folder.isDirectory();
    }
}
