package com.example.impl;

import com.example.qualifies.Digits;
import com.example.qualifies.NumberOfDigits;
import com.example.interfaces.NumberGenerator;
import org.apache.commons.lang3.RandomStringUtils;

import javax.enterprise.context.ApplicationScoped;

@NumberOfDigits(Digits.EIGHT)
@ApplicationScoped
public class FirstGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return RandomStringUtils.random(8, false, true);
    }
}
