package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.rayanis.cleanarchitecturelearnapp.databinding.ActivityMainBinding
import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.sendButton.setOnClickListener {
            val text = b.dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            b.dataTextView.text = "Save result = $result"
        }

        b.receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            b.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}