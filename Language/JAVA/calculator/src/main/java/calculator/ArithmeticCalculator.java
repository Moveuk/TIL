package calculator;

import java.util.Deque;
import java.util.StringJoiner;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    public ArithmeticCalculator(Deque<Double> results) {
        super(results);
    }

    // IllegalArgumentException은 RuntimeException 하위 클래스이므로 throws를 명시하지 않아도 된다.(unchecked이므로)
    public T calculate(T num1, T num2, char operator) {
        T result = operatorFactory(operator).operate(num1, num2);
        super.getResults().addLast((Double) result);
        return result;
    }

    /*
     operator를 생성하는 책임을 분리하며 Calculator 사용시 operator가 어떻게 생성되는지, 연산되는지에 대한 것은 외부에서 알 필요가 없기 때문에 접근제어자를 private로 설정.
    */
    private Operator<T> operatorFactory(char operator) {
        OperatorType operatorType = OperatorType.valueOf(operator);
        return switch (operatorType) {
            case ADDITION -> new AddOperator<T>();
            case SUBTRACTION -> new SubtractOperator<T>();
            case MULTIPLICATION -> new MultiplyOperator<T>();
            case DIVISION -> new DivideOperator<T>();
            case MODULO -> new ModOperator<T>();
        };
    }

    @Override
    public void inquiryResults() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (Double d : super.getResults()) {
            stringJoiner.add(String.valueOf(d));
        }
        System.out.println("기본 연산 결과 : " + stringJoiner);
    }
}
