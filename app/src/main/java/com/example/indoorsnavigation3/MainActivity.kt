package com.example.indoorsnavigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.indoorsnavigation3.transportschedulescreen.TransportScheduleScreen
import com.example.indoorsnavigation3.ui.theme.IndoorsNavigation3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndoorsNavigation3Theme {
                TransportScheduleScreen()
            }
        }
    }
}

