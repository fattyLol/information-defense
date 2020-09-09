package com.codes;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSAcode implements Code {

    private Key publicKey;
    private Key privateKey;

    public RSAcode() throws NoSuchAlgorithmException {
        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = pairGenerator.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    @Override
    public String code(String line, Key key) {
        return null;
    }

    @Override
    public String decode(String line, Key key) {
        return null;
    }
}
