package calculator;

public class AddOperator<T extends Number> implements Operator<T> {
    @Override
    public T operate(T num1, T num2) {
        return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
    }
}
