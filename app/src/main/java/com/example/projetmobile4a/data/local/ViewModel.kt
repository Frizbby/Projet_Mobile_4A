package com.example.projetmobile4a.data.local

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetmobile4a.presentation.main.LoginStatus

class ViewModel(

): ViewModel() {

    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

/*
     fun onClickedLogin(email: String, password: String) {
         viewModelScope.launch(Dispatchers.IO) {
             // je peux ajouter comme foncitonnalité -> quand pas de Login ou mdp entré message d'erreur ou bouton login grisé
             val user = getUserUseCase.invoke(email,password)
             val loginStatus = if (user != null) {
                 LoginSuccess(user)
             } else {
                 LoginError
             }

             withContext(Dispatchers.Main) {
                 loginLiveData.value = loginStatus
             }
         }
     }*/

}