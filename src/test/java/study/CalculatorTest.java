package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.Calculator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private String[] values;
    private List<Integer> numbers;
    private List<String> operators;

    @BeforeEach
    void setValue() {
        values = new String[] {"1","+","4"};
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    @Test
    @DisplayName("숫자 체크")
    void isNumber() {
        assertThat(Calculator.isNumber("123")).isTrue();
        assertThat(Calculator.isNumber("test")).isFalse();
    }

    @Test
    @DisplayName("숫자만 분류")
    void setNumbers() {
        for(String s:values) {
            Calculator.setNumbers(numbers, s);
        }
        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers).containsExactly(1, 4);
    }

    @Test
    @DisplayName("연산자만 분류")
    void setOperators() {
        for(String s:values) {
            Calculator.setOperators(operators, s);
        }
        assertThat(operators.size()).isEqualTo(1);
        assertThat(operators).containsExactly("+");
    }

    @Test
    @DisplayName("덧셈")
    void plusTest() {
        int firstNumber = 1, secondNumber = 4;
        assertThat(Calculator.plus(firstNumber, secondNumber)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈")
    void minusTest() {
        int firstNumber = 1, secondNumber = 4;
        assertThat(Calculator.minus(firstNumber, secondNumber)).isEqualTo(-3);
    }

    @Test
    @DisplayName("곱셈")
    void muliplyTest() {
        int firstNumber = 1, secondNumber = 4;
        assertThat(Calculator.multiply(firstNumber, secondNumber)).isEqualTo(4);
    }

    @Test
    @DisplayName("나눗셈")
    void devideTest() {
        int firstNumber = 6, secondNumber = 3;
        assertThat(Calculator.devide(firstNumber, secondNumber)).isEqualTo(2);
    }
}
