package calculator;

import java.util.StringJoiner;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULO('%');

    private char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public static String inquirySymbols() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        for (OperatorType ot : values()) {
            stringJoiner.add(String.valueOf(ot.getSymbol()));
        }
        return stringJoiner.toString();
    }

    public static OperatorType valueOf(char operator) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.symbol == operator) return operatorType;
        }
        throw new IllegalArgumentException("연산자 기호는 " + inquirySymbols() + " 중에만 사용이 가능합니다.");
    }
}