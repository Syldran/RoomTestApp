package com.learning.roomtestapp.ui

sealed class Screen(val route:String) {
    object ContactScreen : Screen("main_screen")
    object AddContact : Screen("add_contact_screen")
}
