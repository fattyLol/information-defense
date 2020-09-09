package com.codes;

import java.security.Key;

public interface Code {

    String code(String line, Key key);

    String decode(String line, Key key);
}
