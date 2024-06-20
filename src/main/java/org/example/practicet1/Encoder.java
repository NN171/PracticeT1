package org.example.practicet1;

import java.util.Base64;

public class Encoder {

    public static String encode(String email, String code) {
        String concat = email + ":" + code;
        return Base64.getEncoder().encodeToString(concat.getBytes());
    }
}
