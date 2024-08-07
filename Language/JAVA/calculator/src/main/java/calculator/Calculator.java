package calculator;

import java.util.Deque;

public abstract class Calculator {
    private final Deque<Double> results;

    public Calculator(Deque<Double> results) {
        this.results = results;
    }

    public void removeResult() {
        this.results.pop();
    }

    public abstract void inquiryResults();

    public Deque<Double> getResults() {
        return results;
    }
}
