import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    while (true) {
        val hotelBookList = arrayListOf<Client>()
        println("[메뉴]")
        println("1. 방예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
        val selectedMenuNum = readLine()!!

        when (selectedMenuNum) {
            //방예약
            "1" -> {
                println("예약자 분의 성함을 입력해주세요.")
                val clientName = readLine()!!

                //예약 방 선택하기
                checkRoomNumber()

                //체크아웃
                val checkIn = selectBookDate(true, LocalDate.now())
                //체크아웃
                val checkOut = selectBookDate(false, LocalDate.now())

                //고객 명단 등록
                val client = Client(clientName, checkIn, checkOut)
                hotelBookList.add(client)

                println("1. 초기 금액으로 ${client.balance} 원 입금되었습니다.")

                println("2. 예약금으로 ${client.deposit} 원 출금되었습니다.")
                client.balance -= client.deposit

                println("호텔 예약이 완료되었습니다.")
            }

            //예약 목록 출력
            "2" -> {}

            //예약목록 (정렬) 출력
            "3" -> {}

            //시스템 종료
            "4" -> {
                println("시스템을 종료합니다.")
                break
            }

            //금액 입금-출금 내역 목록 출력
            "5" -> {}

            //예약 변경/취소
            "6" -> {}
            else -> {
                println("해당 번호가 없습니다. 올바른 번호를 입력해 주세요.")
            }
        }


    }
}

private fun checkRoomNumber() {
    var roomNumber: String
    while (true) {
        println("예약할 방번호를 입력해 주세요.")
        roomNumber = readLine()!!
        if (roomNumber.toInt() in 100..999) {
            break
        }
        println("\u001B[31m올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.\u001B[0m")
    }
}

private fun selectBookDate(isCheckIn: Boolean, since: LocalDate): LocalDate {
    while (true) {
        try {
            val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
            val todayFormatted = since.format(formatter)

            if (isCheckIn) println("체크인 날짜를 입력해 주세요. \u001B[33m표기형식 : ${todayFormatted}\u001B[0m")
            else println("체크아웃 날짜를 입력해 주세요. \u001B[33m표기형식 : ${todayFormatted}\u001B[0m")
            val checkInput = readLine()!!

            // 숫자인지 검사
            checkInput.toInt()

            if (checkInput.length == 8) {
                val checkYear = checkInput.substring(0..3).toInt()
                val checkMonth = checkInput.substring(4..5).toInt()
                val checkDay = checkInput.substring(6..7).toInt()

                val checkDate = LocalDate.of(checkYear, checkMonth, checkDay)

                if (isCheckIn && checkDate < since) throw RuntimeException("Past Date than CheckIn")
                if (!isCheckIn && checkDate <= since) throw RuntimeException("Past CheckOut Date than CheckIn")

                return checkDate
            } else throw RuntimeException("Wrong Format")

        } catch (e: NumberFormatException) {
            println("숫자 형식의 날짜를 입력해 주세요.")
        } catch (e: RuntimeException) {
            if (e.message?.contains("MonthOfYear") == true) println("1월부터 12월 사이의 값을 넣어주세요.")
            if (e.message?.contains("DayOfMonth") == true) println("1일부터 28~31일 사이의 값을 넣어주세요.")
            if (e.message?.contains("Past Date than CheckIn") == true) println("체크인은 지난 날은 선택할 수 없습니다.")
            if (e.message?.contains("Past CheckOut Date than CheckIn") == true) println("체크인 날짜보다 이전이거나 같을 수는 없습니다.")
            if (e.message?.contains("Wrong Format") == true) println("형식에 맞는 날짜를 입력해 주세요.")
        }
    }
}

class Client(name: String, checkIn: LocalDate, checkOut: LocalDate) {
    lateinit var name: String
    lateinit var checkIn: LocalDate
    lateinit var checkOut: LocalDate
    var balance: Double = Math.floor(Math.random() * 100) * 100000
    var deposit: Double = Math.floor(Math.random() * 100) * 1000
}