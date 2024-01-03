package com.moveuk.todoapp.domain.todo.model

import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import jakarta.persistence.*

@Entity
@Table(name = "reply")
class Reply(
    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    var todo: Todo,

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