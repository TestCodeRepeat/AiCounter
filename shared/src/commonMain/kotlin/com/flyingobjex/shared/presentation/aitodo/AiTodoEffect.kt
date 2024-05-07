package com.flyingobjex.shared.presentation.aitodo

import com.flyingobjex.shared.presentation.Effect

sealed class AiTodoEffect : Effect {
    data class ShowToast(val message: String) : AiTodoEffect()
}