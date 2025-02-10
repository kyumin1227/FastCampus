package practice.calculator;

import practice.calculator.calculate.*;

import java.util.List;

public class Calculator {

    final static List<OperatorCalculate> operatorCalculates = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static Number calculate(double num1, String operator, double num2) {

        OperatorCalculate operatorCalculator = operatorCalculates.stream()
                .filter(operatorCalculate -> operatorCalculate.isSupports(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));

        double result = operatorCalculator.calculate(num1, num2);

        if (result % 1 == 0) {
            return (int) result;
        }

        return result;
    }
}
