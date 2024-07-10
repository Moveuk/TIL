package calculator;

import java.util.Deque;
import java.util.StringJoiner;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(Deque<Double> results) {
        super(results);
    }

    // IllegalArgumentException은 RuntimeException 하위 클래스이므로 throws를 명시하지 않아도 된다.(unchecked이므로)
    public Double calculate(int num1, int num2, char operator) {
        double result = operatorFactory(operator).operate(num1, num2);
        super.getResults().addLast(result);
        return result;
    }

    /*
     operator를 생성하는 책임을 분리하며 Calculator 사용시 operator가 어떻게 생성되는지, 연산되는지에 대한 것은 외부에서 알 필요가 없기 때문에 접근제어자를 private로 설정.
    */
    private Operator operatorFactory(char operator) {
        return switch (operator) {
            case '+' -> new AddOperator();
            case '-' -> new SubtractOperator();
            case '*' -> new MultiplyOperator();
            case '/' -> new DivideOperator();
            case '%' -> new ModOperator();
            default -> throw new IllegalArgumentException("연산자 기호는 +, -, *, /, % 중에만 사용이 가능합니다.");
        };
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
