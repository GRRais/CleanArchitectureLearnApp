package ru.rayanis.cleanarchitecturelearnapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.sendButton.setOnClickListener {

        }

        b.receiveButton.setOnClickListener {

        }
    }
}