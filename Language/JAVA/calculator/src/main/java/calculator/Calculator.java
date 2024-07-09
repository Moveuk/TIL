package calculator;

import java.util.Deque;
import java.util.StringJoiner;

public class Calculator {
    public static final double PI = 3.14159265358979323846; // 원주율은 여러 인스턴스에서 공용으로 참조하며 상수임.
    private Deque<Double> basicResults;
    private Deque<Double> circleAreaResults;

    public Calculator(Deque<Double> basicResults, Deque<Double> circleAreaResults) {
        this.basicResults = basicResults;
        this.circleAreaResults = circleAreaResults;
    }

    public Double calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        double result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                yield (double) num1 / num2;
            }
            default -> throw new IllegalArgumentException("연산자 기호는 +, -, *, / 중에만 사용이 가능합니다.");
        };

        basicResults.addLast(result);
        return result;
    }

    public Deque<Double> getBasicResults() {
        return basicResults;
    }

    public void setBasicResults(Deque<Double> basicResults) {
        this.basicResults = basicResults;
    }

    public void removeBasicResult() {
        this.basicResults.pop();
    }

    public void inquiryBasicResults() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (double d : basicResults) {
            stringJoiner.add(Double.toString(d));
        }
        System.out.println(stringJoiner);
    }

    public Double calculateCircleArea(int radius) {
        double result = radius * radius * PI;
        circleAreaResults.addLast(result);
        return result;
    }

    public Deque<Double> getCircleAreaResults() {
        return circleAreaResults;
    }

    public void setCircleAreaResults(Deque<Double> circleAreaResults) {
        this.circleAreaResults = circleAreaResults;
    }

    public void removeCircleAreaResult() {
        this.circleAreaResults.pop();
    }

    public void inquiryCircleAreaResults() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (Double d : circleAreaResults) {
            stringJoiner.add(Double.toString(d));
        }
        System.out.println(stringJoiner);
    }
}
