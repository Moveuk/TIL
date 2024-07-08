package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        Integer int1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        Integer int2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
        char operator = sc.next().charAt(0);
//        char operator = sc.nextLine().charAt(0);  // nextLine()은 개행문자(\n)을 포함하여 가져오기 때문에 charAt 메소드에서 StringIndexOutOfBoundsException이 터짐
    }
}
