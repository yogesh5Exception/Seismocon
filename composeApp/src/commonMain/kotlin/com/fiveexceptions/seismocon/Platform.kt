package com.fiveexceptions.seismocon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform