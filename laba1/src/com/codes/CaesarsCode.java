package com.codes;


import java.security.Key;

class CaesarsCode implements Code {


    @Override
    public String code(String line, Key key) {

        CaesarsKey code = (CaesarsKey) key;
        int offset = code.getOffset();

        if (line.isEmpty() || offset > 26) {
            throw new IllegalArgumentException();
        }

        char[] symbols = line.toLowerCase().toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] + offset > 122) {
                symbols[i] = (char) ((symbols[i] + offset) - 26);
            } else {
                symbols[i] = (char) (symbols[i] + offset);
            }

        }

        return new String(symbols);
    }

    @Override
    public String decode(String line, Key key) {

        CaesarsKey code = (CaesarsKey) key;
        int offset = code.getOffset();

        if (line.isEmpty() || offset > 26) {
            throw new IllegalArgumentException();
        }

        char[] symbols = line.toLowerCase().toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] - offset < 97) {
                symbols[i] = (char) ((symbols[i] - offset) + 26);
            } else {
                symbols[i] = (char) (symbols[i] - offset);
            }

        }

        return new String(symbols);
    }
}
