package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todo.model.Todo
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.User
import com.moveuk.todoapp.domain.user.model.UserRole
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockKExtension::class)
class TodoServiceTest(
//    private val todoRepository: TodoRepository
) : BehaviorSpec({
    extension(SpringExtension)

    afterContainer {
        clearAllMocks()
    }

    val todoRepository = mockk<TodoRepository>()
    val userRepository = mockk<UserRepository>()

    val todoService =
        TodoService(todoRepository, userRepository)

    Given("todo 목록이 존재하지 않을 때") {
        When("특정 todo를 요청하면") {
            Then("ModelNotFoundException이 발생해야한다.") {

                // given
//                todoRepository.deleteAll()
                val todoId = 1L
                every { todoRepository.findByIdOrNull(any()) } returns null

                shouldThrow<ModelNotFoundException> {
                    println(todoService.getTodoByID(todoId))
                }

            }
        }

        When("todo 작성을 요청하면") {
            Then("todo 등록이 되고 TodoResponse를 반환해야한다.") {
                // given
                val todo = Todo(
                    title = "test_title",
                    description = "test_description",
                    user = User(
                        email = "test@test.com",
                        password = "1234",
                        profile = Profile(nickname = "nickname"),
                        role = UserRole.ADMIN
                    )
                )
                every { todoRepository.save(todo) } returns mockk {
                    every { id } returns 1L
                    every { title } returns "test_title"
                    every { description } returns "test_description"
                    every { user } returns User(
                        email = "test@test.com",
                        password = "1234",
                        profile = Profile(nickname = "nickname"),
                        role = UserRole.ADMIN
                    )
                    every { completion } returns false
                    every { createdDate } returns todo.createdDate
                    every { replies } returns mutableListOf()
                }


                //When
                val savedTodo = todoRepository.save(todo)

                //Then
                savedTodo.title shouldBe todo.title
                savedTodo.description shouldBe todo.description
                savedTodo.user shouldBe todo.user
                savedTodo.completion shouldBe todo.completion
                savedTodo.replies shouldBe todo.replies

                //이렇게 하는 거 맞나요? 흠.. 그냥 mock도 결국 만든 정보라 그냥 내가 나를 비교하는 기분이라..
                //결국 stub도 내가 만든거라 데이터가 로직을 탄 건 아닌거 같아서.. 테스트가 아니지 않나..
                //주말동안 역직렬화 포함한 controller 테스트 만들어보려고 합니다.
            }
        }
    }
})