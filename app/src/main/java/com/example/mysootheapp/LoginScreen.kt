package com.example.cpbyte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysootheapp.CPBYTELogo
import com.example.mysootheapp.LoginButton
import com.example.mysootheapp.LoginHeader
import com.example.mysootheapp.LoginInputField

@Composable
fun LoginScreen() {
    var libraryId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        CPBYTELogo(
            modifier = Modifier
                .width(120.dp)
                .padding(bottom = 100.dp)
        )

        LoginHeader(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .align(Alignment.Start)
        )

        LoginInputField(
            value = libraryId,
            onValueChange = { libraryId = it },
            label = "Library ID",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        LoginInputField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        LoginButton(
            onClick = { /* TODO: Implement login logic */ },
            text = "Continue",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
        LoginScreen()
}