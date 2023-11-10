package com.learning.roomtestapp.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@Composable
fun Navigation(navController: NavHostController, state: ContactState, viewModel: ContactViewModel) {


    NavHost(navController = navController, startDestination = Screen.ContactScreen.route){
        composable(route = Screen.ContactScreen.route){
            ContactScreen(navController, state = state, onEvent = viewModel::onEvent)
        }
        composable(route = Screen.AddContact.route){
            AddContact(navController, state, onEvent = viewModel::onEvent, modifier = Modifier)
        }
    }
}