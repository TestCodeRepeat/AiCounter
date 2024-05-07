package com.flyingobjex.shared.domain.event

import com.flyingobjex.shared.presentation.event.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class EventBusImpl : EventBus {
    private val events = MutableSharedFlow<Event>()
    override fun getEvents(): Flow<Event> = events.asSharedFlow()
    override suspend fun sendEvent(event: Event) {
        events.emit(event)
    }
}
