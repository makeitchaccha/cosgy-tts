package dev.cosgy.textToSpeak.settings.user

interface UserRepository {
    suspend fun find(id: Long): User
    suspend fun save(user: User)
}