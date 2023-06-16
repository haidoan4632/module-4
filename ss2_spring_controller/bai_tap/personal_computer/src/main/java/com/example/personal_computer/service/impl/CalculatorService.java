package com.example.personal_computer.service.impl;

import com.example.personal_computer.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(Double number1, Double number2, String string) {
        double result = 0;
        String operator = string;
        try {
            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":

                    if (number2 == 0) {
                        throw new ArithmeticException("Không thể chia cho 0");
                    }
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Phép tính không hợp lệ");
            }
        } catch (ArithmeticException e) {

            return "Lỗi: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Lỗi: " + e.getMessage();
        }
        return String.valueOf(result);
    }
}
