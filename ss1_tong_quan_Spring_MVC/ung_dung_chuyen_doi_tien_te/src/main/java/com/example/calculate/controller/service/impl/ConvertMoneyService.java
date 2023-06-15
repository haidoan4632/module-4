package com.example.calculate.controller.service.impl;

import com.example.calculate.controller.service.IConvertMoneyService;

public class ConvertMoneyService implements IConvertMoneyService {


    @Override
    public float changeMoney(float money) {
        float result = money * 23000;
        return result;
    }
}
