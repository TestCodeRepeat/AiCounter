package com.flyingobjex.shared.presentation.aitodo

import com.flyingobjex.shared.domain.model.AiTodo
import com.flyingobjex.shared.presentation.Action

sealed class AiTodoAction : Action {
    data class AddTodo(val todo: AiTodo) : AiTodoAction()
    data class ToggleTodo(val todoId: String) : AiTodoAction()
    object ClearTodos : AiTodoAction()
}