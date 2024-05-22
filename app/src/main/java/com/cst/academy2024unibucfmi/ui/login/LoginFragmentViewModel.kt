package com.cst.academy2024unibucfmi.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.cst.academy2024unibucfmi.models.api.LoginAPIRequestModel
import com.cst.academy2024unibucfmi.utils.extensions.isUsernameValid

class LoginFragmentViewModel: ViewModel() {

    val logoImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Google_Images_2015_logo.svg/1200px-Google_Images_2015_logo.svg.png"

    val username = MutableLiveData<String>()
    val isUsernameError = username.map {  username ->
        !username.isUsernameValid()
    }

    val password = ObservableField<String>()

    val loginModel = MutableLiveData<LoginAPIRequestModel>()

    fun generateLoginModel() {
        val username = username.value ?: return
        val password = password.get() ?: return

        if(!isFormValid()) return

        loginModel.value = LoginAPIRequestModel(
            username = username,
            password = password
        )
    }

    private fun isFormValid(): Boolean {
        if(isUsernameError.value == true){
            return false
        }

        return true
    }
}