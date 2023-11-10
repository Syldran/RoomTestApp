package com.learning.roomtestapp.ui


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.getViewModel

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.ContactScreen.route) {
        composable(route = Screen.ContactScreen.route) {
            val viewModel = getViewModel<ContactViewModel>()

            ContactScreen(
                viewModel = getViewModel(),
                onEvent = viewModel::onEvent
            )
        }

//        composable(route = Screen.AddContact.route) {
//            val state by viewModel.state.collectAsState()
//            AddContact(navController, state, onEvent = viewModel::onEvent, modifier = Modifier)
//        }
    }
}