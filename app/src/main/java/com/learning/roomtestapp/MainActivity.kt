package com.learning.roomtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.learning.roomtestapp.db.ContactDatabase
import com.learning.roomtestapp.ui.ContactScreen
import com.learning.roomtestapp.ui.ContactViewModel
import com.learning.roomtestapp.ui.Navigation
import com.learning.roomtestapp.ui.theme.RoomTestAppTheme

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact.db"
        ).build()
    }
    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ContactViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTestAppTheme {
                val state by viewModel.state.collectAsState()
                val navController = rememberNavController()
                Navigation(navController, state = state, viewModel)
//                ContactScreen(navController, state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}
