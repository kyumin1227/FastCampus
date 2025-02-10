package practice.calculator.calculate;

public class DivisionOperator implements OperatorCalculate {
    @Override
    public boolean isSupports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public double calculate(double num1, double num2) {
        checkNum(num2);
        return num1 / num2;
    }

    private void checkNum(double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
    }
}
