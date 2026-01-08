package com.example.firebase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.firebase.ui.theme.FirebaseTheme
import com.example.firebase.view.controllNavigasi.DataSiswaApp
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        enableEdgeToEdge()
        setContent {
            FirebaseTheme {
                DataSiswaApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
