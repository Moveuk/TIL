package calculator;

public class ModOperator<T extends Number> implements Operator<T> {
    @Override
    public T operate(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // Exception 설명에 예시로 "divide by zero"이 설명되어있음.}
        }
        return (T) Double.valueOf(num1.doubleValue() % num2.doubleValue());
    }
}
