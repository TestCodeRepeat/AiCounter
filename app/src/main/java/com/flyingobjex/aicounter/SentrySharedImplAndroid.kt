package com.flyingobjex.aicounter

import com.flyingobjex.shared.data.api.SentryShared
import io.sentry.Sentry

class SentrySharedImplAndroid : SentryShared {

    override fun captureException(e: Exception) {
        Sentry.captureException(e)
    }
}