package dev.cosgy.textToSpeak.settings.guild

class Guild(
    val id: Long,
    val ttsVolume: Float,
    val ttsAuthorNameMode: TTSAuthorNameMode,
    val ttsJoinLeaveEnabled: Boolean,
) {
}