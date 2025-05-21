package dev.cosgy.textToSpeak.settings.guild

import dev.cosgy.textToSpeak.settings.user.User

interface GuildRepository {
    suspend fun find(id: Long): Guild?
    suspend fun save(guild: Guild)
}