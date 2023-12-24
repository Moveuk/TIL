package com.moveuk.todoapp.domain.reply.model

import com.moveuk.todoapp.domain.reply.dto.ReplyResponse
import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import jakarta.persistence.*

@Entity
@Table(name = "reply")
class Reply(
    @ManyToOne
    @JoinColumn(name = "to_do_card_id", nullable = false)
    var toDoCard: ToDoCard,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "author", nullable = false)
    var author: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Reply.toResponse(): ReplyResponse {
    return ReplyResponse(
        id = id!!,
        content = content,
        author = author,
    )
}