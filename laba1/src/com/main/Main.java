package com.main;


import com.codes.CaesarsKey;
import com.codes.Code;
import com.codes.CodeFactory;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        CodeFactory factory = new CodeFactory();
        Code coder =factory.getCoder("Caesars");
        CaesarsKey caesarsKey = new CaesarsKey(3);

        System.out.println(coder.code("ABCD", caesarsKey));


//        System.out.println(coder.code("Petr", 3));
//        System.out.println(coder.decode("shwu",3));
    }
}
