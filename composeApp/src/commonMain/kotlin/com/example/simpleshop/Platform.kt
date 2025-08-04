package com.example.simpleshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform