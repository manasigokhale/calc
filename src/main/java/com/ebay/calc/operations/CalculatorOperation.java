package com.ebay.calc.operations;

import com.ebay.calc.enums.OperationType;

public interface CalculatorOperation {
    Number calculate(Number num1, Number num2);
    OperationType getOperationType();
}
