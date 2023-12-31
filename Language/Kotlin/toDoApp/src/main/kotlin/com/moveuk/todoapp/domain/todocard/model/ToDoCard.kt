package com.moveuk.todoapp.domain.todocard.model

import com.moveuk.todoapp.domain.reply.model.Reply
import com.moveuk.todoapp.domain.reply.model.toResponse
import com.moveuk.todoapp.domain.todocard.dto.ToDoCardResponse
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDateTime

@Entity
@Table(name = "to_do_card")
class ToDoCard(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "completion", nullable = false)
    var completion: Boolean = false,

    @Column(name = "author", nullable = false)
    var author: String,

    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime,

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "toDoCard", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var replies: MutableList<Reply> = mutableListOf(),

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
        author = author,
        completion = completion,
        createdDate = createdDate,
        replies = replies.map { reply: Reply -> reply.toResponse() },
    )
}