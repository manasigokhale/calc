package com.ebay.calc;

import java.util.List;

import com.ebay.calc.controller.CalculatorController;
import com.ebay.calc.dto.CalculationRequest;
import com.ebay.calc.dto.CalculationResponse;
import com.ebay.calc.enums.OperationType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class CalculatorTest {

    @Autowired
    private CalculatorController calculatorController;

    @Test
    void testSingleCalculation() {
        CalculationRequest request = new CalculationRequest();
        request.setOperation(OperationType.ADD);
        request.setNum1(2);
        request.setNum2(3);

        CalculationResponse response = calculatorController.calculate(request);
        assertEquals(5.0, response.getResult());
    }

    @Test
    void testChainedCalculations() {
        CalculationRequest request = new CalculationRequest();
        request.setInitialValue(5);
        request.setOperations(List.of(OperationType.ADD, OperationType.MULTIPLY));
        request.setOperands(List.of(3, 2));

        CalculationResponse response = calculatorController.calculateSequential(request);
        assertEquals(16.0, response.getResult());
    }

    @Test
    void testUnsupportedOperationException() {

        CalculationRequest request = new CalculationRequest();
        request.setOperation(OperationType.MODULO);
        request.setNum1(10);
        request.setNum2(3);

        // Execute and assert that an UnsupportedOperationException is thrown
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculatorController.calculate(request);
        });

        String expectedMessage = "Operation MODULO is not supported.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUnsupportedOperationExceptionWithMock() {
        // Create a mock OperationType
        OperationType unsupportedOperation = Mockito.mock(OperationType.class);
        Mockito.when(unsupportedOperation.name()).thenReturn("FAKE_OPERATION");

        // Prepare the calculation request
        CalculationRequest request = new CalculationRequest();
        request.setOperation(unsupportedOperation);
        request.setNum1(10);
        request.setNum2(3);

        // Execute and assert that an UnsupportedOperationException is thrown
        assertThrows(UnsupportedOperationException.class, () -> {
            calculatorController.calculate(request);
        });

    }

}
