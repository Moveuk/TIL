package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    Deque<Integer> results = new ArrayDeque<>();

    public Integer calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        int result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("연산자 기호는 +, -, *, / 중에만 사용이 가능합니다.");
        };

        results.addLast(result);
        return result;
    }
}
