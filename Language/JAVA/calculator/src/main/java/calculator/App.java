package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Integer[] resultArray = new Integer[10];
        int lastElementIndex = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Integer int1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            Integer int2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
            char operator = sc.next().charAt(0);
//        char operator = sc.nextLine().charAt(0);  // nextLine()은 개행문자(\n)을 포함하여 가져오기 때문에 charAt 메소드에서 StringIndexOutOfBoundsException이 터짐

            int result = 0;
            boolean errorFlag = false;
            String message = "에러 메세지";

            switch (operator) {
                case '+':
                    result = int1 + int2;
                    break;
                case '-':
                    result = int1 - int2;
                    break;
                case '*':
                    result = int1 * int2;
                    break;
                case '/':
                    if (int2 == 0) {
                        message = "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                        errorFlag = true;
                        break;
                    }
                    result = int1 / int2;
                    break;
                default:
                    break;
            }

            if (errorFlag) {
                System.out.println(message);
            } else {
                System.out.println("결과: " + result);
                resultArray[lastElementIndex++] = result;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!sc.next().equals("exit"));
    }
}
