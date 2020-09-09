package com.codes;

import java.security.Key;

public class CaesarsKey implements Key {

    private int offset;

    public CaesarsKey(int offset) {
        this.offset = offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public String getAlgorithm() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }

}
