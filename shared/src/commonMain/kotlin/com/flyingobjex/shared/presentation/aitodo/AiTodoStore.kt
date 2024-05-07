package com.flyingobjex.shared.presentation.aitodo

import com.flyingobjex.shared.domain.event.EventBus
import com.flyingobjex.shared.domain.event.getFilteredEvents
import com.flyingobjex.shared.presentation.State
import com.flyingobjex.shared.presentation.Store
import com.flyingobjex.shared.presentation.event.Event
import kotlinx.coroutines.launch

data class AiTodo(
    val todoId: String,
    val description: String,
    val completed: Boolean,
)

data class AiTodoState(
    val todos: List<AiTodo> = emptyList()
) : State


class AiTodoStore(eventBus: EventBus) : Store<AiTodoState, AiTodoAction, AiTodoEffect>() {

    init {
        launch {
            eventBus.getFilteredEvents<Event.StoreAction>().collect { event ->
                when (event.action) {
                    is AiTodoAction -> dispatch(event.action)
                }
            }
        }
    }

    override fun initState(): AiTodoState {
        return AiTodoState(todos = listOf())
    }

    override fun dispatch(action: AiTodoAction) {
        when (action) {
            is AiTodoAction.AddTodo -> addToDo(action.todo)
            is AiTodoAction.ToggleTodo -> toggleToDo(action.todoId)
            AiTodoAction.ClearTodos -> TODO()
        }
    }

    private fun toggleToDo(todoId: String) {
        updateState(state.copy(todos = state.todos.map { todo ->
            if (todo.todoId == todoId) {
                todo.copy(completed = !todo.completed)
            } else {
                todo
            }
        }))
    }

    private fun addToDo(todo: AiTodo) {
        updateState(state.copy(todos = state.todos + todo))
    }


}