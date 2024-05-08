package com.flyingobjex.shared.presentation.event

import com.flyingobjex.shared.presentation.Action
import com.flyingobjex.shared.presentation.Effect

sealed class Event {
    abstract val trigger: String?

    data class ToastEvent(
        override val trigger: String? = null,
        val message: String,
    ) : Event()

    data class StoreAction(
        override val trigger: String? = null,
        val action: Action,
    ) : Event()

    data class StoreSideEffect(
        override val trigger: String? = null,
        val action: Effect,
    ) : Event()
}