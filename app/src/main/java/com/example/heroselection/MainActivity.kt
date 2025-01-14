package com.example.heroselection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.heroselection.ui.MainScreen
import com.example.heroselection.ui.theme.HeroSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            HeroSelectionTheme {
                MainScreen()
            }
        }
    }
}