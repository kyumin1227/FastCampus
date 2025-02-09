package org.example.calculator;

import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    };

//    interface 이용
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(int operand1, String operator, int operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(new PositiveNumber(operand1), new PositiveNumber(operand2)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
