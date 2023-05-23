package com.example.mallcommon.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encrypt(String password) {
        return encoder.encode(password);
    }

    public static boolean match(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }

    public static void main(String[] args) {
        String encrypt = BcryptUtil.encrypt("123123");
        System.out.println(encrypt);
    }
}
