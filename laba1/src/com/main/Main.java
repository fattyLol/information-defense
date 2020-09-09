package com.main;


import com.codes.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        CodeFactory factory = new CodeFactory();
        Code coder = factory.getCoder("Caesars");
        CaesarsKey caesarsKey = new CaesarsKey(3);

        Code rsaCoder = factory.getCoder("RSA");

        RSAkey rsaKey = new RSAkey();
        Key publicKey = rsaKey.getPublicKey();
        Key privateKey = rsaKey.getPrivateKey();

//        byte [] codedCaesar = coder.code("Hello", caesarsKey);
//        String decodedCaesar = coder.decode(codedCaesar, caesarsKey);
//        System.out.println(decodedCaesar);

        byte[] rsaCodedString = rsaCoder.code("Hello World!", publicKey);
        String rsaDecodedString = rsaCoder.decode(rsaCodedString, privateKey);
        System.out.println(rsaDecodedString);


    }
}
