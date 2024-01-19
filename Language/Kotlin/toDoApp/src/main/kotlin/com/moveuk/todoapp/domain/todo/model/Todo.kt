package com.moveuk.todoapp.domain.todo.model

import com.moveuk.todoapp.domain.todo.dto.todo.TodoResponse
import com.moveuk.todoapp.domain.user.model.User
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
class Todo(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "completion", nullable = false)
    var completion: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @Column(name = "created_date", nullable = false)
    var createdDate: LocalDateTime = LocalDateTime.now(),

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "todo", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var replies: MutableList<Reply> = mutableListOf(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toggleCompletion(status: Boolean): Boolean {
        completion = status
        return completion
    }
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        description = description,
        author = user.profile,
        completion = completion,
        createdDate = createdDate,
        replies = replies.map { reply: Reply -> reply.toResponse() },
    )
}