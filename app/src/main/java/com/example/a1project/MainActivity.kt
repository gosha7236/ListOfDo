package com.example.a1project

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.a1project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        val listView = findViewById<ListView>(R.id.ListView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)
        val buttonDelete: Button = findViewById(R.id.buttonDelete)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, todos)
        listView.adapter = adapter
        button.setOnClickListener {
            val text = userData.text.toString()
            if (text != "")
                adapter.insert(text, 0)

            buttonDelete.setOnClickListener {
                adapter.remove(text)
            }

            setupActionBarWithNavController(navController, appBarConfiguration)
        }
    }
}