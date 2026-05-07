package com.fineteklabs.spacetutorial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform