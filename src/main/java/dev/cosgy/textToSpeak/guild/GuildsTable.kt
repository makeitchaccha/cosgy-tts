package dev.cosgy.textToSpeak.guild

import dev.cosgy.textToSpeak.guild.GuildsTable.convertTtsAuthorNameModeToEnum
import dev.cosgy.textToSpeak.guild.GuildsTable.ttsAuthorNameMode
import dev.cosgy.textToSpeak.user.UsersTable
import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.core.Table

object GuildsTable : Table("guilds") {
    val id = long("id")
    val ttsVolume = float("tts_volume")
    val ttsAuthorNameMode = integer("tts_author_name_mode")
    val ttsJoinLeaveEnabled = bool("tts_join_leave_enabled")

    override val primaryKey = PrimaryKey(UsersTable.id)

    fun convertTtsAuthorNameModeToEnum(ttsAuthorNameMode: Int): TTSAuthorNameMode = when(ttsAuthorNameMode) {
        0 -> TTSAuthorNameMode.NONE
        1 -> TTSAuthorNameMode.GUILD_NAME
        2 -> TTSAuthorNameMode.GLOBAL_NAME
        else -> throw NotImplementedError("Unknown tts_author_name_mode")
    }

    fun convertTtsAuthorNameModeToNumber(ttsAuthorNameMode: TTSAuthorNameMode): Int = when(ttsAuthorNameMode) {
        TTSAuthorNameMode.NONE -> 0
        TTSAuthorNameMode.GUILD_NAME -> 1
        TTSAuthorNameMode.GLOBAL_NAME -> 2
    }
}

fun ResultRow.toGuild(): Guild {
    return Guild(
        this[GuildsTable.id],
        this[GuildsTable.ttsVolume],
        convertTtsAuthorNameModeToEnum(this[ttsAuthorNameMode]),
        this[GuildsTable.ttsJoinLeaveEnabled],
    )
}
