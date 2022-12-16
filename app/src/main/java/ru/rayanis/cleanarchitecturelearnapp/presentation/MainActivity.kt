package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.rayanis.cleanarchitecturelearnapp.data.repository.UserRepositoryImpl
import ru.rayanis.cleanarchitecturelearnapp.data.storage.sharedprefs.SharedPrefUserStorage
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

//        vm = ViewModelProvider(this, MainViewModelFactory(this))
//            .get(MainViewModel::class.java)

        vm.resultLive.observe(this) {
            b.dataTextView.text = it
        }

        b.sendButton.setOnClickListener {
            val text = b.dataEditView.text.toString()
            val params =
                ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            b.dataTextView.text = "Save result = $result"
        }

        b.receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            b.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}