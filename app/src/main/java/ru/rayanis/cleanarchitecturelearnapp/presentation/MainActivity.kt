package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        Log.e("AAA" , "Activity created")

        vm = ViewModelProvider(
            this ,
            MainViewModelFactory(this)
        )[MainViewModel::class.java]

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