package com.flyingobjex.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform