import java.time.LocalDate

data class BookHistory(
    val client: Client,
    var reserveRoomNumber: Int,
    val deposit: Int,
    var checkIn: LocalDate,
    var checkOut: LocalDate,
) {

}