package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.QTodo
import com.moveuk.todoapp.domain.todo.model.Todo
import com.moveuk.todoapp.domain.user.model.QUser
import com.moveuk.todoapp.infra.querydsl.QueryDslSupport
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.EntityPath
import com.querydsl.core.types.Expression
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.PathBuilder
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class CustomTodoRepositoryImpl : CustomTodoRepository, QueryDslSupport() {
    private val todo = QTodo.todo
    private val user = QUser.user

    override fun findAllByPageableAndNickname(pageable: Pageable, nickname: String?): Page<Todo>? {
        val whereClause = BooleanBuilder()

        nickname?.let { whereClause.and(todo.user.profile.nickname.likeIgnoreCase(nickname)) }
        val contents: MutableList<Todo>
        val totalCount:
                Long
        try {
            contents = queryFactory
                .selectFrom(todo)
                .where(whereClause)
                .leftJoin(todo.user, user)
                .fetchJoin()
                .orderBy(*getOrderSpecifier(pageable, todo))
                .fetch()

            totalCount = queryFactory
                .select(todo.count())
                .from(todo)
                .where(whereClause)
                .fetchOne() ?: 0L
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(
                "잘못된 sort 인자 ${
                    pageable.sort.toList().map { it.property }.joinToString(",")
                }를 넣으셨습니다."
            )
        } catch (e: Exception) {
            throw IllegalArgumentException("exception")
        }
        return PageImpl(contents, pageable, totalCount)
    }

    private fun getOrderSpecifier(pageable: Pageable, path: EntityPath<*>): Array<OrderSpecifier<*>> {
        val pathBuilder = PathBuilder(path.type, path.metadata)

        return pageable.sort.toList().map { order ->
            OrderSpecifier(
                if (order.isAscending) Order.ASC else Order.DESC,
                pathBuilder.get(order.property) as Expression<Comparable<*>>
            )
        }.toTypedArray()
    }
}
