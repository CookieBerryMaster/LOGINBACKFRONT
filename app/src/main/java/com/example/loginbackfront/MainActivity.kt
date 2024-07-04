package com.example.loginbackfront

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.loginbackfront.compose.AgendaApp
import com.example.loginbackfront.compose.LoginCompose
import com.example.loginbackfront.ui.theme.LOGINBACKFRONTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LOGINBACKFRONTTheme {
                // 'ViewModel' solo se define en clases, nunca en composable
                //val loginViewModel by viewModels<LoginViewModel> ()
                //insets -> top bar and bottom bar
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginCompose( modifier = Modifier.padding(innerPadding))
                    //AgendaApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

