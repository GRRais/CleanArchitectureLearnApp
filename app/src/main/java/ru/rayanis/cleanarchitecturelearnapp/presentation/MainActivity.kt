package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding

@EntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        Log.e("AAA" , "Activity created")

        vm.resultLive.observe(this) {
            b.dataTextView.text = it
        }

        b.sendButton.setOnClickListener {
            val text = b.dataEditView.text.toString()
            vm.save(text)
        }

        b.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}