package com.example.springdatajpa.converter;

public class CryptoHelper {

    public static String encrypt(String raw) {
        return "encrpyted(" + raw + ")";
    }

    public static String decrpyt(String encrpyted) {
        return "decrpyted(" + encrpyted + ")";
    }
}
