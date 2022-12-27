package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        Log.e("AAA" , "Activity created")

        vm.stateLive.observe(this) { state ->
            b.dataTextView.text = "${state.firstName} ${state.lastname} ${state.saveResult}"
        }

        b.sendButton.setOnClickListener {
            val text = b.dataEditView.text.toString()
            vm.send(SaveEvent(text = text))
        }

        b.receiveButton.setOnClickListener {
            vm.send(LoadEvent())
        }
    }
}