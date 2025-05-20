package dev.cosgy.textToSpeak.settings.persistence

import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IdTable

object UsersTable : IdTable<Long>("users") {
    override val id: Column<EntityID<Long>> = long("id").entityId()
    val voiceModel: Column<String> = varchar("voice_model", 255) // common fs limitation?

    val speed: Column<Float> = float("speed")
    val intonation: Column<Float> = float("intonation")
    val voiceQualityA: Column<Float> = float("voice_quality_a")
    val voiceQualityFm: Column<Float> = float("voice_quality_fm")
}