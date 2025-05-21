package dev.cosgy.textToSpeak.user

class User(
    val id: Long,
    var voiceModel: String,
    var speed: Float,
    var intonation: Float,
    var voiceQualityA: Float,
    var voiceQualityFm: Float
) {
}