package com.example.impl;

import com.example.interfaces.NumberGenerator;
import com.example.qualifies.Digits;
import com.example.qualifies.NumberOfDigits;
import org.apache.commons.lang3.RandomStringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@Default
@ApplicationScoped
public class SecondGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return RandomStringUtils.random(5, false, true);
    }
}
