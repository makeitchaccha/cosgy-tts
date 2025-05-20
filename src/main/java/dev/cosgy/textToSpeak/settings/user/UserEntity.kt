package dev.cosgy.textToSpeak.settings.user

import dev.cosgy.textToSpeak.settings.user.UsersTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UsersTable)

    var voiceModel by UsersTable.voiceModel
    var speed by UsersTable.speed
    var intonation by UsersTable.intonation
    var voiceQualityA by UsersTable.voiceQualityA
    var voiceQualityFm by UsersTable.voiceQualityFm

    fun toUser(): User = User(id.value, voiceModel, speed, intonation, voiceQualityA, voiceQualityA)
}