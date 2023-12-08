class Bank {
    val initBalance: Int = (Math.floor(Math.random() * 100) * 100000).toInt()
    var balance: Int = initBalance
    val transactionHistory: ArrayList<Pair<Reason, Int>> = arrayListOf()

    fun withdraw(reason: Reason, money: Int): Boolean {
        if (balance < money) {
            println("잔고가 부족합니다.")
            return false
        } else {
            balance -= money
            transactionHistory.add(Pair(reason, -(money)))
            return true
        }
    }

    fun transfer(reason: Reason, money: Int) {
        balance += money
        transactionHistory.add(Pair(reason, money))
    }

    fun printTransactionHistory() {
        println("1. 초기 금액으로 $initBalance 원 입금되었습니다.")
        transactionHistory.forEachIndexed { index, pair ->
            if (pair.first == Reason.DEPOSIT) println("${index + 2}. 예약금으로 ${pair.second} 원 출금되었습니다.")
            if (pair.first == Reason.REFUND) println("${index + 2}. 환불금으로 ${pair.second} 원 입금되었습니다.")
        }
    }
}

enum class Reason {
    DEPOSIT, REFUND
}
