package com.moveuk.todoapp.domain.todocard.model

import com.moveuk.todoapp.domain.todocard.dto.ToDoCardResponse
import jakarta.persistence.*

@Entity
@Table(name = "to_do_card")
class ToDoCard(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "completion", nullable = false)
    var completion: Boolean = false,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "app_user_id")
//    var user: User,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun ToDoCard.toResponse(): ToDoCardResponse {
    return ToDoCardResponse(
        id = id!!,
        title = title,
        description = description,
//        user = user,
        completion = completion
    )
}