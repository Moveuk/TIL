package calculator;

import java.util.Deque;
import java.util.StringJoiner;

public class CircleCalculator extends Calculator {
    public static final double PI = 3.14159265358979323846; // 원주율은 여러 인스턴스에서 공용으로 참조하며 상수임.

    public CircleCalculator(Deque<Double> results) {
        super(results);
    }

    public Double calculate(int radius) throws IllegalArgumentException {
        double result = radius * radius * PI;
        super.getResults().addLast(result);
        return result;
    }

    @Override
    public void inquiryResults() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (double d : super.getResults()) {
            stringJoiner.add(Double.toString(d));
        }
        System.out.println("원의 넓이 : " + stringJoiner);
    }
}
