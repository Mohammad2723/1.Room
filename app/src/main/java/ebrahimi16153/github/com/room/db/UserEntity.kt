package ebrahimi16153.github.com.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import ebrahimi16153.github.com.room.util.*

// @Entity crate a table with blew data class(Model)
@Entity(tableName = TABLE_USER)
data class UserEntity(
    @PrimaryKey(autoGenerate = true )
    val userID: Int,
    val userName: String,
    val userAge: Int
)