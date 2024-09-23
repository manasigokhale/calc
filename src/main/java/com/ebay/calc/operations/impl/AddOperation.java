package com.ebay.calc.operations.impl;

import com.ebay.calc.enums.OperationType;
import com.ebay.calc.operations.CalculatorOperation;
import org.springframework.stereotype.Component;

@Component
public class AddOperation implements CalculatorOperation {

    @Override
    public Number calculate(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.ADD;
    }
}