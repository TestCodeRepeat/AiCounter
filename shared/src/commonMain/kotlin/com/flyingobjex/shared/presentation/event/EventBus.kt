package com.flyingobjex.shared.domain.event

import com.flyingobjex.shared.presentation.event.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance

interface EventBus {
    fun getEvents(): Flow<Event>
    suspend fun sendEvent(event: Event)
}

inline fun <reified T> EventBus.getFilteredEvents(): Flow<T> {
    return getEvents().filterIsInstance()
}
