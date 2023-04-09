package com.dogpa.kp12bottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.dogpa.kp12bottombar.ui.theme.KP12BottomBarTheme
import com.dogpa.kp12bottombar.ui.theme.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KP12BottomBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainView()
                }
            }
        }
    }
}
