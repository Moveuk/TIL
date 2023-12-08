import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val clientList = arrayListOf<Client>()
    val bookHistoryList = arrayListOf<BookHistory>()
    while (true) {
        println("호텔예약 프로그램 입니다.")
        println("[메뉴]")
        println("1. 방예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
        val selectedMenuNum = readln()

        //validation 1 - 문자 체크
        if (!selectedMenuNum.isNumeric()) {
            println("숫자를 입력해 주세요.")
            continue
        }
        //validation 2 - 메뉴 번호 체크 : 1~6번 사이인가?
        if (!selectedMenuNum.isMenuNumber()) {
            println("해당 번호가 없습니다. 올바른 번호를 입력해 주세요.")
            continue
        }

        when (selectedMenuNum) {
            //방예약
            "1" -> {
                println("예약자 분의 성함을 입력해주세요.")
                val clientName = readln()

                //예약 방 선택하기
                val roomNumber = checkRoomNumber()

                //예약 방의 예약 일정 리스트
                //예약하고 싶은 방의 checkIn-checkOut Data를 Pair로 꺼내옴.
                val alreadyBookedDate =
                    bookHistoryList.filter { it.reserveRoomNumber == roomNumber }.map { Pair(it.checkIn, it.checkOut) }

                //체크인
                val checkIn = selectBookDate(true, alreadyBookedDate, LocalDate.now())
                //체크아웃
                val checkOut = selectBookDate(false, alreadyBookedDate, checkIn)

                //고객 생성 후 고객 리스트 추가
                //기존 고객 확인 로직
                //기존 고객이 아니면 새로 고객 명단에 추가
                var find = clientList.find { it.name == clientName }
                val isNewUser = (find == null)
                if (isNewUser) {
                    find = Client(clientName)
                    clientList.add(find)
                }
                //예약리스트에 추가
                val randomBookMoney = (Math.floor(Math.random() * 100) * 1000).toInt()
                val bookHistory = BookHistory(find!!, roomNumber, randomBookMoney, checkIn, checkOut)
                bookHistoryList.add(bookHistory)

                //잔고 확인
                if (isNewUser) {
                    println("1. 초기 금액으로 ${find.money.initBalance} 원 입금되었습니다.")
                    val isWithdrawSuccess = find.money.withdraw(Reason.DEPOSIT, bookHistory.deposit)
                    if (!isWithdrawSuccess) {
                        continue
                    }
                } else {
                    println("1. 기존에 가지고 계신 잔금은 ${find.money.balance} 원 입니다.")
                    val isWithdrawSuccess = find.money.withdraw(Reason.DEPOSIT, bookHistory.deposit)
                    if (!isWithdrawSuccess) {
                        continue
                    }
                }
                println("2. 예약금으로 ${bookHistory.deposit} 원 출금되었습니다.")

                println("호텔 예약이 완료되었습니다.")
            }

            //예약 목록 출력
            "2" -> {
                println("호텔 예약자 목록입니다.")
                bookHistoryList.forEachIndexed { index, it ->
                    println("${index + 1}. 사용자: ${it.client.name}, 방번호: ${it.reserveRoomNumber}호, 체크인: ${it.checkIn}, 체크아웃: ${it.checkOut}")
                }
            }

            //예약목록 (정렬) 출력
            "3" -> {
                bookHistoryList.sortBy { it.checkIn }
                println("호텔 예약자 목록입니다. (정렬완료)")
                bookHistoryList.forEachIndexed { index, it ->
                    println("${index + 1}. 사용자: ${it.client.name}, 방번호: ${it.reserveRoomNumber}호, 체크인: ${it.checkIn}, 체크아웃: ${it.checkOut}")
                }
            }

            //시스템 종료
            "4" -> {
                println("시스템을 종료합니다.")
                break
            }

            //금액 입금-출금 내역 목록 출력
            "5" -> {
                while (true) {
                    println("조회하실 사용자 이름을 입력하세요.")
                    val searchName = readln()
                    val findBookHistory = bookHistoryList.find { it.client.name == searchName }
                    if (findBookHistory != null) {
                        findBookHistory.client.money.printTransactionHistory()
                        break
                    } else {
                        println("예약된 사용자를 찾을 수 없습니다.")
                        break
                    }
                }
            }


            //예약 변경/취소
            "6" -> {
                while (true) {
                    println("예약을 변경할 사용자 이름을 입력하세요.")
                    val searchName = readln()
//                    val filteredClient = hotelBookList.filter { client -> client.name == searchName }
                    val findBookInfo = bookHistoryList.filter { it.client.name == searchName }

                    if (findBookInfo.isEmpty()) {
                        println("사용자 이름으로 예약된 목록을 찾을 수 없습니다.")
                        break
                    }

                    while (true) {
//                        var count = 0
                        println("$searchName 님이 예약한 목록입니다. 변경하실 예약번호를 입력해주세요. (탈출은 exit 입력)")
                        findBookInfo.forEachIndexed { index, it ->
                            println("${index + 1}. 사용자: ${it.client.name}, 방번호: ${it.reserveRoomNumber}호, 체크인: ${it.checkIn}, 체크아웃: ${it.checkOut}")
                        }

                        val selectRow = readln()
                        // exit시 6번 탈출
                        if (selectRow == "exit") break
                        // validation 1 - 숫자 아닐시 처음으로
                        if (!selectRow.isNumeric()) {
                            println("숫자를 입력해 주세요")
                            continue
                        }
                        // validation 2 - 목록의 숫자가 아닐시 처음으로
                        if (selectRow.toInt() > findBookInfo.size) {
                            println("목록에 들어있는 숫자를 눌러주세요.")
                            continue
                        }
                        //예약 변경 질문
                        println("해당 예약을 어떻게 하시겠어요? 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기")
                        val selectChangeOrCancel = readln()
                        val targetBookHistory = findBookInfo[selectRow.toInt() - 1]
                        if (selectChangeOrCancel == "1") {
                            println("$searchName 님의 예약을 변경하겠습니다.")
                            println("방을 변경하시겠습니까? 1. 변경 / 2. 방 유지 / 이외 번호. 메뉴로 돌아가기")
                            val changeRoom = readln()
                            // 방 변경 선택
                            if (changeRoom == "1") {
                                targetBookHistory.reserveRoomNumber = checkRoomNumber()
                            } else if (changeRoom == "2") {
                                println("방을 유지하겠습니다.")
                            } else break

                            //예약 방의 예약 일정 리스트
                            val alreadyBookedDate =
                                bookHistoryList.filter { it.reserveRoomNumber == changeRoom.toInt() }
                                    .filter { it != targetBookHistory }   //변경하려는 예약건은 제외
                                    .map { Pair(it.checkIn, it.checkOut) }
                            val changedCheckIn = selectBookDate(true, alreadyBookedDate, LocalDate.now())
                            val changedCheckOut = selectBookDate(false, alreadyBookedDate, changedCheckIn)

                            val clientWhoWantChangeReserv = bookHistoryList.find { it == targetBookHistory }!!
                            clientWhoWantChangeReserv.checkIn = changedCheckIn
                            clientWhoWantChangeReserv.checkOut = changedCheckOut
                            println("예약 변경이 다음과 같이 완료 되었습니다.")
                            println("사용자: ${clientWhoWantChangeReserv.client.name}, 방번호: ${clientWhoWantChangeReserv.reserveRoomNumber}호, 체크인: ${clientWhoWantChangeReserv.checkIn}, 체크아웃: ${clientWhoWantChangeReserv.checkOut}")
                        } else if (selectChangeOrCancel == "2") {
                            val cancellationNotice =
                                "[취소 유의사항]\n체크인 3일 이전 취소 예약금 환불 불가\n체크인 5일 이전 취소 예약금의 30% 환불\n체크인 7일 이전 취소 예약금의 50% 환불\n체크인 14일 이전 취소 예약금의 80% 환불\n체크인 30일 이전 취소 예약금의 100% 환불"
                            println(cancellationNotice)
                            //취소 예약건 찾기
                            val clientWhoWantCancelBooking = bookHistoryList.find { it == targetBookHistory }!!

                            //체크인까지 남은 날짜
                            val remainDays = clientWhoWantCancelBooking.checkIn.compareTo(LocalDate.now())
                            val discountPercentage: Int = if (remainDays <= 3) 0
                            else if (remainDays <= 5) 30
                            else if (remainDays <= 7) 50
                            else if (remainDays <= 14) 80
                            else 100

                            println("고객님께서는 체크인 날짜까지 ${remainDays}일 남으셨으므로 취소 예약금의 ${discountPercentage}%가 환불 가능하십니다.")

                            //환불처리
                            val refundMoney = clientWhoWantCancelBooking.deposit * discountPercentage / 100
                            clientWhoWantCancelBooking.client.money.transfer(Reason.REFUND, refundMoney)
                            println("고객님의 예약금 ${clientWhoWantCancelBooking.deposit} 원 중 ${refundMoney}원이 환불되었습니다.")

                            println("고객님의 현재 잔고는 ${clientWhoWantCancelBooking.client.money.balance}원 입니다.")

                            bookHistoryList.removeIf { it == clientWhoWantCancelBooking }

                            println("취소가 완료되었습니다.")
                            break
                        } else {
                            break
                        }
                    }
                    break
                }
            }

        }


    }
}

private fun String.isMenuNumber(): Boolean {
    return try {
        this.toInt() in 1..6
    } catch (e: Exception) {
        false
    }
}

private fun String.isNumeric(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: Exception) {
        false
    }
}

private fun checkRoomNumber(): Int {
    while (true) {
        println("예약할 방번호를 입력해 주세요.")
        val roomNumber = readln()
        //validation 1 - 문자 체크
        if (!roomNumber.isNumeric()) {
            println("숫자를 입력해 주세요.")
            continue
        }
        //validation 2 - 방번호 체크 100~999번
        if (roomNumber.toInt() !in 100..999) {
            System.err.println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
            continue
        }
        return roomNumber.toInt()
    }
}

private fun selectBookDate(
    isCheckIn: Boolean,
    alreadyBookedDate: List<Pair<LocalDate, LocalDate>>,
    since: LocalDate
): LocalDate {
    while (true) {
        try {
            val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
            val todayFormatted = since.format(formatter)

            if (isCheckIn) println("체크인 날짜를 입력해 주세요. \u001B[33m표기형식 : ${todayFormatted}\u001B[0m")
            else println("체크아웃 날짜를 입력해 주세요. \u001B[33m표기형식 : ${todayFormatted}\u001B[0m")
            val checkInput = readln()

            // 숫자인지 검사
            if (!checkInput.isNumeric()) {
                println("숫자 형식의 날짜를 입력해 주세요.")
                continue
            }

            // 8자리 format 체크
            if (checkInput.length != 8) {
                println("형식에 맞는 날짜를 입력해 주세요.")
                continue
            }
//            while (true)
            //년, 월, 일 분리
            val checkYear = checkInput.substring(0..3).toInt()
            val checkMonth = checkInput.substring(4..5).toInt()
            val checkDay = checkInput.substring(6..7).toInt()

            val checkDate = LocalDate.of(checkYear, checkMonth, checkDay)

            if (isCheckIn && checkDate < since) {
                println("체크인은 지난 날은 선택할 수 없습니다.")
                continue
            }
            if (!isCheckIn && checkDate <= since) {
                println("체크인 날짜보다 이전이거나 같을 수는 없습니다.")
                continue
            }

            //예약가능 여부 로직 사이이면
            val isPossibleToBook = alreadyBookedDate.none { it.first <= checkDate && checkDate <= it.second }

            if (!isPossibleToBook) {
                println("해당 날짜에 이미 방을 사용중입니다. 다른날짜를 입력해주세요.")
                continue
            }
            return checkDate

        } catch (e: RuntimeException) {
            //LocalDate 자체 메세지 활용
            if (e.message?.contains("MonthOfYear") == true) println("1월부터 12월 사이의 값을 넣어주세요.")
            if (e.message?.contains("DayOfMonth") == true) println("1일부터 28~31일 사이의 값을 넣어주세요.")
            continue
        }
    }
}
