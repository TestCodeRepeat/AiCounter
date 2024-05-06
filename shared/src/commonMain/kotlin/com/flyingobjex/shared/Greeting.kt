package com.flyingobjex.shared

import com.flyingobjex.shared.Platform
import com.flyingobjex.shared.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}