package dev.cosgy.textToSpeak.settings.user

interface UserRepository {
    suspend fun findById(id: Long): User?
    suspend fun save(user: User)
}