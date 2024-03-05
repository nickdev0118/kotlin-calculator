package com.example.test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform