package dev.cosgy.textToSpeak.guild

interface GuildRepository {
    suspend fun find(id: Long): Guild?
    suspend fun save(guild: Guild)
}