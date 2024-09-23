package com.ebay.calc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ebay.calc.enums.OperationType;
import com.ebay.calc.operations.CalculatorOperation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private Map<OperationType, CalculatorOperation> operationMap = new HashMap<>();

    @Autowired
    private List<CalculatorOperation> operations;

    @PostConstruct
    public void init() {
        for (CalculatorOperation operation : operations) {
            operationMap.put(operation.getOperationType(), operation);
        }
    }

    /**
     * Performs a single operation between two numbers.
     *
     * @param op   the operation to perform
     * @param num1 the first number
     * @param num2 the second number
     * @return the result of the operation
     */
    public Number calculate(OperationType op, Number num1, Number num2) {
        CalculatorOperation operation = operationMap.get(op);
        if (operation != null) {
            return operation.calculate(num1, num2);
        } else {
            throw new UnsupportedOperationException("Operation " + op + " is not supported.");
        }
    }

    /**
     * Allows chaining multiple operations starting from an initial value.
     *
     * @param initialValue the starting value
     * @param ops          a list of operations to perform
     * @param operands     a list of operands corresponding to each operation
     * @return the final result after all operations
     */
    public Number calculateSequential(Number initialValue, List<OperationType> ops, List<Number> operands) {
        if (ops.size() != operands.size()) {
            throw new IllegalArgumentException("Operations and operands lists must be of the same size.");
        }

        Number result = initialValue;
        for (int i = 0; i < ops.size(); i++) {
            result = calculate(ops.get(i), result, operands.get(i));
        }
        return result;
    }
}
