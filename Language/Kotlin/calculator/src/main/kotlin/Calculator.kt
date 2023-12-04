class Calculator {
    fun add(addOperation: AddOperation, int1: Int, int2: Int): Double {
        return addOperation.operate(int1, int2);
    }
    fun subtract(subtractOperation : SubtractOperation, int1: Int, int2: Int): Double {
        return subtractOperation.operate(int1, int2);
    }
    fun multiply(multiplyOperation: MultiplyOperation, int1: Int, int2: Int): Double {
        return multiplyOperation.operate(int1, int2);
    }
    fun divide(divideOperation: DivideOperation, int1: Int, int2: Int): Double {
        return divideOperation.operate(int1, int2);
    }
    fun remain(int1: Int, int2: Int): Int {
        return int1 % int2;
    }
}
