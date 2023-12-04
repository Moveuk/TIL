fun main() {
    // Lv1 : 계산기 클래스를 만들어 더하기, 빼기, 나누기, 곱하기 연산하기
    var int1 = 4
    var int2 = 2
    var calculator = Calculator()

    println("${int1}과 ${int2}의 덧셈은 ${calculator.add(int1, int2)} 입니다.")   // 6
    println("${int1}과 ${int2}의 뺄셈은 ${calculator.subtract(int1, int2)} 입니다.")  // 2
    println("${int1}과 ${int2}의 곱셈은 ${calculator.multiply(int1, int2)} 입니다.")  // 8
    println("${int1}과 ${int2}의 나눗셈은 ${calculator.divide(int1, int2)} 입니다.")   // 2
    println("${int1}을 ${int2}로 나눈 나머지는 ${calculator.remain(int1, int2)} 입니다.")   // 0
}

// Lv1 : 더하기, 빼기, 나누기, 곱하기 연산을 수행할 수 있는 Calculator 클래스를 만들고, 클래스를 이용하여 연산을 진행하고 출력하기
class Calculator {
    fun add(int1: Int, int2: Int): Int {
        return int1 + int2;
    }
    fun subtract(int1: Int, int2: Int): Int {
        return int1 - int2;
    }
    fun multiply(int1: Int, int2: Int): Int {
        return int1 * int2;
    }
    fun divide(int1: Int, int2: Int): Int {
        return int1 / int2;
    }
    fun remain(int1: Int, int2: Int): Int {
        return int1 % int2;
    }
}