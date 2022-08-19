package ebrahimi16153.github.com.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ebrahimi16153.github.com.room.databinding.ActivityAddUserBinding
import ebrahimi16153.github.com.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
}