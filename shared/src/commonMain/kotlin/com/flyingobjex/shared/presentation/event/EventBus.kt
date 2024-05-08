package com.flyingobjex.shared.domain.event

import com.flyingobjex.shared.presentation.event.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance

interface EventBus {
    fun getEvents(): Flow<Event>
    suspend fun sendEvent(event: Event)
}

@Throws(exceptionClasses = [Exception::class])
inline fun <reified T> EventBus.getFilteredEvents(): Flow<T> {
    return getEvents().filterIsInstance()
}

@Throws(exceptionClasses = [Exception::class])
fun EventBus.getToastEvents(): Flow<Event.ToastEvent> {
    return getEvents().filterIsInstance<Event.ToastEvent>()
}

@Throws(exceptionClasses = [Exception::class])
fun EventBus.getStoreActionEvents(): Flow<Event.StoreAction> {
    return getEvents().filterIsInstance<Event.StoreAction>()
}

@Throws(exceptionClasses = [Exception::class])
fun EventBus.getStoreSideEffectEvents(): Flow<Event.StoreSideEffect> {
    return getEvents().filterIsInstance<Event.StoreSideEffect>()
}