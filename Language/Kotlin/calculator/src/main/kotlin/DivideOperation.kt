class DivideOperation : AbstractOperation() {
    override fun operate(int1: Int, int2: Int): Double {
        return int1.toDouble() / int2.toDouble();
    }
}