package dev.cosgy.textToSpeak.user

interface UserRepository {
    suspend fun findById(id: Long): User?
    suspend fun save(user: User)
}