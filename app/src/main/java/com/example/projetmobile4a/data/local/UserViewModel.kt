package com.example.projetmobile4a.data.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projetmobile4a.data.repository.UserRepository
import com.example.projetmobile4a.domain.entity.User
import com.example.projetmobile4a.presentation.main.LoginError
import com.example.projetmobile4a.presentation.main.LoginStatus
import com.example.projetmobile4a.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

public class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()



    init {
        val userDao = AppDatabase.getDatabase(application).dataBaseDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData

    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun findUserWithName(email: String,password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.findUserWithName(email,password)
        }

    }
    fun onClickedLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val user = repository.findUserWithName(email,password)
            val loginStatus = if (user != null) {
                LoginSuccess(email,password)
            } else {
                LoginError
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }

}