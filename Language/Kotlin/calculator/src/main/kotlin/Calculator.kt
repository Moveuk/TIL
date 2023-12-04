class Calculator(var operation: AbstractOperation) {
    fun operate(int1: Int, int2: Int): Double {
        return operation.operate(int1, int2);
    }
    fun remain(int1: Int, int2: Int): Int {
        return int1 % int2;
    }
}
