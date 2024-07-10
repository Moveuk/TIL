package calculator;

public class DivideOperator implements Operator {
    @Override
    public int operate(int num1, int num2) {
        if (num2 == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // Exception 설명에 예시로 "divide by zero"이 설명되어있음.
        return num1 / num2;
    }
}
