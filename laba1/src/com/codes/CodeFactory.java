package com.codes;

import java.security.NoSuchAlgorithmException;

public class CodeFactory{
    public Code getCoder(String name) throws NoSuchAlgorithmException {
        Code code = null;

        if (name.equals("Caesars")){
            code = new CaesarsCode();
        } else if (name.equals("RSA")){
            code = new RSAcode();
        }

        return code;
    }
}
