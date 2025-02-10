package practice.calculator.calculate;

public interface OperatorCalculate {
    boolean isSupports(String operator);
    double calculate(double num1, double num2);
}
