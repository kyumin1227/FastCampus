package practice.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CalculatorTest {

    @DisplayName("덧셈 연산 수행")
    @Test
    void calculateAddition() {
        Number result = Calculator.calculate(1, "+", 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("연산 수행")
    @ParameterizedTest
    @MethodSource("provideCalculate")
    void calculate(double num1, String operator, double num2, Number result) {
        Number calculateResult = Calculator.calculate(num1, operator, num2);

        assertThat(calculateResult).isEqualTo(result);
    }

    static Stream<Arguments> provideCalculate() {
        return Stream.of(
                Arguments.of(1, "+", 2, 3),
                Arguments.of(2, "-", 1, 1),
                Arguments.of(4, "*", 5, 20),
                Arguments.of(8, "/", 2, 4)
        );
    }

    @DisplayName("존재하지 않는 연산자")
    @Test
    void operatorError() {
        assertThatCode(() -> Calculator.calculate(1, "3", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자입니다.");
    }

    @DisplayName("0으로 나눗셈 수행")
    @Test
    void divisionError() {
        assertThatCode(() -> Calculator.calculate(3, "/", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌수 없습니다.");
    }
}
