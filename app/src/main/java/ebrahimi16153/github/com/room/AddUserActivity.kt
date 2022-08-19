package ebrahimi16153.github.com.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import ebrahimi16153.github.com.room.databinding.ActivityAddUserBinding
import ebrahimi16153.github.com.room.db.UserDatabase
import ebrahimi16153.github.com.room.db.UserEntity
import ebrahimi16153.github.com.room.util.USER_DATABASE

class AddUserActivity : AppCompatActivity() {

    // binding
    private lateinit var binding: ActivityAddUserBinding

    //DataBase
    private val userDB: UserDatabase by lazy {
        Room.databaseBuilder(
            this, UserDatabase::class.java,
            USER_DATABASE
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private lateinit var user: UserEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSaveUser.setOnClickListener {
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString()
                if (name.isNotEmpty() || age.isNotEmpty()) {
                    user = UserEntity(0, name, age.toInt())
                    userDB.dao().insertUser(user)
                    finish()
                } else {
                    Snackbar.make(it, "Name and Age can't be empty", Snackbar.LENGTH_LONG).show()
                }
            }
        }


    }
}