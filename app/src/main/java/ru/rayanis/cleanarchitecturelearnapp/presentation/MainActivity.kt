package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.rayanis.cleanarchitecturelearnapp.app.App
import ru.rayanis.cleanarchitecturelearnapp.data.repository.UserRepositoryImpl
import ru.rayanis.cleanarchitecturelearnapp.data.storage.sharedprefs.SharedPrefUserStorage
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        (application as App).appComponent.inject(this)

        Log.e("AAA" , "Activity created")

        vm = ViewModelProvider(this, vmFactory)
            .get(MainViewModel::class.java)

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