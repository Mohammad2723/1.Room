package ebrahimi16153.github.com.room.db

import androidx.room.*
import ebrahimi16153.github.com.room.util.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)


    @Update
    fun update(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM $TABLE_USER")
    fun getAllUser(): MutableList<UserEntity>


    @Query("SELECT * FROM $TABLE_USER WHERE userID LIKE :id ")
    fun getUser(id: Int): UserEntity


    @Query("DELETE FROM $TABLE_USER")
    fun deleteAllUser()


}