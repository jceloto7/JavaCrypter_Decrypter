package com.jceloto7.javaCrypter_Decrypter;

import com.IC2379.Crypter.controller.Crypter;
import com.jceloto7.javaCrypter_Decrypter.service.Crypt_DecryptService;
import com.jceloto7.javaCrypter_Decrypter.util.InputUtil;
import com.jceloto7.javaCrypter_Decrypter.util.MismatchCorrectionUtil;
import com.jceloto7.javaCrypter_Decrypter.util.ValidationUtil;

public class Bootstrap {
    public static InputUtil inputUtil;
    public static ValidationUtil validationUtil;
    public static MismatchCorrectionUtil mismatchCorrectionUtil;
    public static Crypter crypter;

    public static Crypt_DecryptService cryptDecryptService;

    public static void start(){
        inputUtil = new InputUtil();
        validationUtil = new ValidationUtil();
        mismatchCorrectionUtil = new MismatchCorrectionUtil();
        crypter = new Crypter();
        cryptDecryptService = new Crypt_DecryptService();
    }
}
