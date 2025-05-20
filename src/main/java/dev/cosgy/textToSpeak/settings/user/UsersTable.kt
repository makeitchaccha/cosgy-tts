package dev.cosgy.textToSpeak.settings.user

import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IdTable

object UsersTable : IdTable<Long>("users") {
    override val id = long("id").entityId()
    val voiceModel = varchar("voice_model", 255) // common fs limitation?
    val speed = float("speed")
    val intonation = float("intonation")
    val voiceQualityA = float("voice_quality_a")
    val voiceQualityFm = float("voice_quality_fm")
}