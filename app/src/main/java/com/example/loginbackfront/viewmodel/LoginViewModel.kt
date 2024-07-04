package com.example.loginbackfront.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginbackfront.repository.RepositorioUsuario
import kotlinx.coroutines.launch

//bean donde todos sus valores esten inicializados
class LoginViewModel : ViewModel() {

    private val repository = RepositorioUsuario()

    //esto solo se actualiza desde aca no en otro lugar
    var state by mutableStateOf(State())
        private set

    //copia el passwod y lo actualiza a state
    fun onEmail(email: String){
        state = state.copy(email = email)
    }

    fun onPassword(password: String){
        state = state.copy(password = password)
    }

    fun onLogin() {
        viewModelScope.launch{
            val result = repository.login(state.email,state.password)
            state = if (result.isSuccess) {
                if (result.getOrNull() == 1) {
                    state.copy(
                        error = false, mensaje = "Usuario correcto")
                }
                else {
                    state.copy(
                        error = true,mensaje="Usuario Incorrecto")
                }
            }
            else {
                state.copy(
                    error = true,mensaje="Problemas con la red")
            }
        }
    }

    fun restartState(){
        state = state.copy(error = false, mensaje = null)
    }

    data class State(
        val email : String = " ",
        val password : String = "",
        val mensaje : String? = null,
        val error : Boolean = false
    )
}