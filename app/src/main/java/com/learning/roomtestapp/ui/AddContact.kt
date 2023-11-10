package com.learning.roomtestapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddContact(
    navController: NavController,
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.firstName,
            onValueChange = {
                onEvent(ContactEvent.SetFirstName(it))
            },
            placeholder = {
                Text(text = "First name")
            },

            )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.lastName,
            onValueChange = {
                onEvent(ContactEvent.SetLastName(it))
            },
            placeholder = {
                Text(text = "Last name")
            }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.phoneNumber,
            onValueChange = {
                onEvent(ContactEvent.SetPhoneNumber(it))
            },
            placeholder = {
                Text(text = "Phone number")
            }
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(onClick = {
                onEvent(ContactEvent.SaveContact)
                navController.navigate(Screen.ContactScreen.route)

            }) {
                Text(text = "Save")
            }
        }
    }
}