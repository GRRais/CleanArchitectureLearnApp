package ru.rayanis.cleanarchitecturelearnapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.rayanis.cleanarchitecturelearnapp.domain.models.SaveUserNameParam
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.GetUserNameUseCase
import ru.rayanis.cleanarchitecturelearnapp.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _stateLive = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = _stateLive

    init {
        Log.e("AAA", "VM created")
        _stateLive.value = MainState(
            saveResult = false,
            firstName = "",
            lastname = ""
        )
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(event.text)
            }
            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        _stateLive.value = MainState(
            saveResult = resultData,
            firstName = _stateLive.value!!.firstName,
            lastname = _stateLive.value!!.lastname
        )
    }

    private fun load() {
        val userName = getUserNameUseCase.execute()
        _stateLive.value = MainState(
            saveResult = _stateLive.value!!.saveResult,
            firstName = userName.firstName,
            lastname = userName.lastName
        )
    }
}