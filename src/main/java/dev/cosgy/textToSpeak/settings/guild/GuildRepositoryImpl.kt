package dev.cosgy.textToSpeak.settings.guild

import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.jetbrains.exposed.v1.jdbc.upsert

class GuildRepositoryImpl(
    private val db: Database,
) : GuildRepository {
    override suspend fun find(id: Long): Guild? = transaction(db) {
        GuildsTable.select(GuildsTable.id.eq(id))
            .singleOrNull()
            ?.toGuild()
    }

    override suspend fun save(guild: Guild) {
        transaction(db) {
            GuildsTable.upsert {
                it[GuildsTable.id] = guild.id
                it[GuildsTable.ttsVolume] = guild.ttsVolume
                it[GuildsTable.ttsAuthorNameMode] = GuildsTable.convertTtsAuthorNameModeToNumber(guild.ttsAuthorNameMode)
                it[GuildsTable.ttsJoinLeaveEnabled] = guild.ttsJoinLeaveEnabled
            }
        }
    }

}