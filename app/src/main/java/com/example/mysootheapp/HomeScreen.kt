package com.example.mysootheapp

import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, backgroundColor = 0xFFF4F0EE)
@Composable
fun sootheApp() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(start = 20.dp)
                .verticalScroll(rememberScrollState())) {
                Spacer(modifier = Modifier.size(16.dp))
                val search = remember { mutableStateOf("") }
                TextField(
                    value = search.value,
                    onValueChange = { search.value = it },
                    label = { Text(text = "Search") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 17.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                AlignYourBody()
                Spacer(modifier = Modifier.size(20.dp))
                favorateAppCollectionPreview()

            }
        }
    }
}
@Preview()
@Composable
fun fullScreen() {
    Scaffold(
        bottomBar = { BottomBarPreview() },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add,
                    contentDescription = null)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            sootheApp()
        }
    }
}