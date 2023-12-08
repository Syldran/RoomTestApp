package com.learning.roomtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.learning.roomtestapp.ui.Navigation
import com.learning.roomtestapp.ui.theme.RoomTestAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTestAppTheme {
                Navigation(
                    navController = rememberNavController()
                )
            }
        }
    }
}