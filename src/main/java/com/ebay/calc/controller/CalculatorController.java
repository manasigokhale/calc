package com.ebay.calc.controller;

import com.ebay.calc.Calculator;
import com.ebay.calc.dto.CalculationRequest;
import com.ebay.calc.dto.CalculationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private Calculator calculator;

    /**
     * Endpoint for performing a single calculation.
     *
     * @param request the calculation request containing the operation and operands
     * @return the result of the calculation
     */
    @PostMapping("/calculate")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        Number result = calculator.calculate(
            request.getOperation(),
            request.getNum1(),
            request.getNum2()
        );
        return new CalculationResponse(result);
    }

    /**
     * Endpoint for performing chained calculations.
     *
     * @param request the chained calculation request containing initial value, operations, and operands
     * @return the final result after all operations
     */
    @PostMapping("/calculate-sequential")
    public CalculationResponse calculateSequential(@RequestBody CalculationRequest request) {
        Number result = calculator.calculateSequential(
            request.getInitialValue(),
            request.getOperations(),
            request.getOperands()
        );
        return new CalculationResponse(result);
    }
}