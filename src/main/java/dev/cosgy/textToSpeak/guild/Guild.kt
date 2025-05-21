package dev.cosgy.textToSpeak.guild

class Guild(
    val id: Long,
    val ttsVolume: Float,
    val ttsAuthorNameMode: TTSAuthorNameMode,
    val ttsJoinLeaveEnabled: Boolean,
) {
}