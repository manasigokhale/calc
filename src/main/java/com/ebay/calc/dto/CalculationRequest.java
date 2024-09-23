package com.ebay.calc.dto;


import java.util.List;

import com.ebay.calc.enums.OperationType;

public class CalculationRequest {

    // For single calculation
    private OperationType operation;
    private Number num1;
    private Number num2;

    // For sequential calculation
    private Number initialValue;
    private List<OperationType> operations;
    private List<Number> operands;

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Number getNum1() {
        return num1;
    }

    public void setNum1(Number num1) {
        this.num1 = num1;
    }

    public Number getNum2() {
        return num2;
    }

    public void setNum2(Number num2) {
        this.num2 = num2;
    }

    // Sequential calculation getters and setters
    public Number getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Number initialValue) {
        this.initialValue = initialValue;
    }

    public List<OperationType> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationType> operations) {
        this.operations = operations;
    }

    public List<Number> getOperands() {
        return operands;
    }

    public void setOperands(List<Number> operands) {
        this.operands = operands;
    }
}
