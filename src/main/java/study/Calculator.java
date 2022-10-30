package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for(String s:values) {
            setNumbers(numbers, s);
            setOperators(operators, s);
        }

        int index = 0;
        int result = numbers.get(index);
        for(String operator:operators) {
            index++;
            result = calculate(operator, result, numbers.get(index));
        }

        System.out.println("결과: " + result);
    }

    public static int calculate(String operator, int firstNumber, int secondNumber) {
        switch (operator) {
            case "+":
                return plus(firstNumber, secondNumber);
            case "-":
                return minus(firstNumber, secondNumber);
            case "*":
                return multiply(firstNumber, secondNumber);
            case "/":
                return devide(firstNumber, secondNumber);
            default:
                System.out.println("잘못된 연산자입니다.");
                return -1;
        }
    }

    public static void setNumbers(List<Integer> numbers, String s) {
        if(isNumber(s))
            numbers.add(Integer.parseInt(s));
    }

    public static void setOperators(List<String> operators, String s) {
        if(!isNumber(s))
            operators.add(s);
    }

    public static int plus(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int devide(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    public static boolean isNumber(String s) {
        if(null == s)
            return false;

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
