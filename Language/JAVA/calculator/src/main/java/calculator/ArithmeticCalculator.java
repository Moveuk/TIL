package calculator;

import java.util.Deque;
import java.util.StringJoiner;

public class ArithmeticCalculator extends Calculator {
    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    public ArithmeticCalculator(Deque<Double> results, AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator) {
        super(results);
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }

    public Double calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        double result = switch (operator) {
            case '+' -> addOperator.operate(num1, num2);
            case '-' -> subtractOperator.operate(num1, num2);
            case '*' -> multiplyOperator.operate(num1, num2);
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                yield (double) divideOperator.operate(num1, num2);
            }
            default -> throw new IllegalArgumentException("연산자 기호는 +, -, *, / 중에만 사용이 가능합니다.");
        };

        super.getResults().addLast(result);
        return result;
    }

    @Override
    public void inquiryResults() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (double d : super.getResults()) {
            stringJoiner.add(Double.toString(d));
        }
        System.out.println("기본 연산 결과 : " + stringJoiner);
    }
}
