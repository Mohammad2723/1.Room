package ebrahimi16153.github.com.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import ebrahimi16153.github.com.room.adapter.UserAdapter
import ebrahimi16153.github.com.room.databinding.ActivityAddUserBinding
import ebrahimi16153.github.com.room.databinding.ActivityMainBinding
import ebrahimi16153.github.com.room.db.UserDatabase
import ebrahimi16153.github.com.room.util.USER_DATABASE

class MainActivity : AppCompatActivity() {

    private val db :UserDatabase by lazy { Room.databaseBuilder(this,UserDatabase::class.java,
        USER_DATABASE)
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    }
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            fabAdd.setOnClickListener {
                startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
            }
        }
    }


    override fun onResume() {
        super.onResume()
        isListEmpty()
    }


    private fun isListEmpty() {
        if (db.dao().getAllUser().isNotEmpty()) {
            binding.apply {
                userList.visibility = View.VISIBLE
                emptyTxt.visibility = View.GONE
                val  adapter = UserAdapter()
                adapter.diff.submitList(db.dao().getAllUser())
                userList.adapter = adapter
                userList.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        } else {
            binding.apply {
                userList.visibility = View.VISIBLE
                emptyTxt.visibility = View.GONE
            }

        }
    }

}