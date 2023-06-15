package com.example.calculate.controller.service.impl;

import com.example.calculate.controller.service.IConvertMoneyService;
import org.springframework.stereotype.Service;

public class ConvertMoneyService implements IConvertMoneyService  {

    @Override
    public float changeMoney(float money) {
        float result = money * 23000;
        return result;
    }
}
