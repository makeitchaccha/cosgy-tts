package dev.cosgy.textToSpeak.user

import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.core.Table

object UsersTable : Table("users") {
    val id = long("id")
    val voiceModel = varchar("voice_model", 255) // common fs limitation?
    val speed = float("speed")
    val intonation = float("intonation")
    val voiceQualityA = float("voice_quality_a")
    val voiceQualityFm = float("voice_quality_fm")

    override val primaryKey = PrimaryKey(id)
}

fun ResultRow.toUser(): User = User(
    this[UsersTable.id],
    this[UsersTable.voiceModel],
    this[UsersTable.speed],
    this[UsersTable.intonation],
    this[UsersTable.voiceQualityA],
    this[UsersTable.voiceQualityFm],
)