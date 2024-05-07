package com.flyingobjex.shared.presentation.event

import com.flyingobjex.shared.presentation.Action

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
}