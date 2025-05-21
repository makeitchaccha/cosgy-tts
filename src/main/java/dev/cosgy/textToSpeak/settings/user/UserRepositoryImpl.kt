package dev.cosgy.textToSpeak.settings.user

import dev.cosgy.textToSpeak.settings.guild.Guild
import net.dv8tion.jda.api.requests.Route
import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.jetbrains.exposed.v1.jdbc.upsert

class UserRepositoryImpl(
    private val db: Database,
) : UserRepository {

    override suspend fun findById(id: Long): User? = transaction(db) {
        UsersTable.select(UsersTable.id.eq(id))
            .singleOrNull()
            ?.toUser()
    }


    override suspend fun save(user: User) {
        transaction(db) {
            UsersTable.upsert {
                it[UsersTable.id] = user.id
                it[UsersTable.voiceModel] = user.voiceModel
                it[UsersTable.speed] = user.speed
                it[UsersTable.intonation] = user.intonation
                it[UsersTable.voiceQualityA] = user.voiceQualityA
                it[UsersTable.voiceQualityFm] = user.voiceQualityFm
            }
        }
    }
}