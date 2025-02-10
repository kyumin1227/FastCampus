package practice.calculator.calculate;

public class AdditionOperator implements OperatorCalculate {
    @Override
    public boolean isSupports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}
