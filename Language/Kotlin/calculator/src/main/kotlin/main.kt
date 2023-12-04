fun main() {
    var int1 = 4
    var int2 = 3
    var calculator = Calculator(AddOperation())

    println("${int1}과 ${int2}의 덧셈은 ${calculator.operate(int1, int2)} 입니다.")   // 6
    calculator.operation = SubtractOperation()
    println("${int1}과 ${int2}의 뺄셈은 ${calculator.operate(int1, int2)} 입니다.")  // 2
    calculator.operation = MultiplyOperation()
    println("${int1}과 ${int2}의 곱셈은 ${calculator.operate(int1, int2)} 입니다.")  // 8
    calculator.operation = DivideOperation()
    println("${int1}과 ${int2}의 나눗셈은 ${calculator.operate(int1, int2)} 입니다.")   // 2
    println("${int1}을 ${int2}로 나눈 나머지는 ${calculator.remain(int1, int2)} 입니다.")   // 0
}