package calculator;

import java.util.ArrayDeque;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(new ArrayDeque<>());
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayDeque<>());

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("사칙연산을 진행한다면 1을, 원의 너비를 구한다면 2를 입력해주세요: ");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();

                    System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
                    char operator = sc.next().charAt(0);

                    try {
                        double result = arithmeticCalculator.calculate(num1, num2, operator);
                        System.out.println("결과: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    if (sc.next().equals("remove")) {
                        arithmeticCalculator.removeResult();
                    }

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    if (sc.next().equals("inquiry")) {
                        arithmeticCalculator.inquiryResults();
                    }
                }
                case 2 -> {
                    System.out.print("반지름 숫자를 입력하세요: ");
                    int radius = sc.nextInt();

                    double result = circleCalculator.calculate(radius);
                    System.out.println("결과: " + result);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    if (sc.next().equals("remove")) {
                        circleCalculator.removeResult();
                    }

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    if (sc.next().equals("inquiry")) {
                        circleCalculator.inquiryResults();
                    }
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!sc.next().equals("exit"));
    }
}
