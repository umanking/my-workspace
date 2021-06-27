package com.example.springdatajpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class CryptoConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String raw) {
        return CryptoHelper.encrypt(raw);
    }

    @Override
    public String convertToEntityAttribute(String encrypted) {
        return CryptoHelper.decrpyt(encrypted);
    }
}
