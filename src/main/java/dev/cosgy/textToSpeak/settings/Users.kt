package dev.cosgy.textToSpeak.settings

import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.Table

object Users : Table() {
    val id: Column<Long> = long("id")
    val voiceModel: Column<String> = varchar("voice_model", 255) // common fs limitation?
    val speed: Column<Float> = float("speed")
    val intonation: Column<Float> = float("intonation")
    val voiceQualityA: Column<Float> = float("voice_quality_a")
    val voiceQualityFm: Column<Float> = float("voice_quality_fm")
    override val primaryKey = PrimaryKey(id)
}