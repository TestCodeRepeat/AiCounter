package com.flyingobjex.shared.data.api

interface SentryShared {
    fun captureException(e: Exception)
}