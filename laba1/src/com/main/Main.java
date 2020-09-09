package com.main;


import com.codes.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Main {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IOException {
        CodeFactory factory = new CodeFactory();

        while (true) {

            System.out.println("1. Caesars code/decode" +
                    "\n2. RSA code/decode" +
                    "\n0. Exit");
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {

                break;
            }
            switch (num) {
                case 1: {
                    Code coder = factory.getCoder("Caesars");
                    caesarsCode(coder);
                    break;
                }
                case 2: {
                    Code rsaCoder = factory.getCoder("RSA");
                    rsaCode(rsaCoder);
                    break;
                }
                default: {
                    System.out.println("Команда не найдена :(");
                }

            }
            System.out.println("Press any key...");
            reader.read();
            for (int i = 0; i < 10; i++) {
                System.out.println("");
            }
        }


    }

    private static void caesarsCode(Code coder) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        System.out.println("What is a word you are going to encode and then decode?");
        System.out.print("Word: ");
        String message = reader.readLine();

        System.out.println("What is the offset?");
        System.out.print("Offset: ");
        int offset = Integer.parseInt(reader.readLine());
        CaesarsKey caesarsKey = new CaesarsKey(offset);

        System.out.println("Encoded message");
        byte[] codedCaesar = coder.code(message, caesarsKey);
        for (byte b : codedCaesar) {
            System.out.print((char) b);
        }
        System.out.println("\nDecoded message: ");
        String decodedCaesar = coder.decode(codedCaesar, caesarsKey);
        System.out.println(decodedCaesar);
    }

    private static void rsaCode(Code rsaCoder) throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        System.out.println("What is a word you are going to encode and then decode?");
        System.out.print("Word: ");
        String message = reader.readLine();


        RSAkey rsaKey = new RSAkey();
        Key publicKey = rsaKey.getPublicKey();
        Key privateKey = rsaKey.getPrivateKey();

        System.out.println("Encoded message");
        byte[] rsaCodedString = rsaCoder.code(message, publicKey);
        for (byte b : rsaCodedString) {
            System.out.print(b);
        }

        System.out.println("\nDecoded message: ");
        String rsaDecodedString = rsaCoder.decode(rsaCodedString, privateKey);
        System.out.println(rsaDecodedString);

    }
}
