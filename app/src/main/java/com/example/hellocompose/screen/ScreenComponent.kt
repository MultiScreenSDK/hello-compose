package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.IconButton
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu


@Composable
fun ScreenComponent(title: String, openDrawer: () -> Unit, children: @Composable() () -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(title) },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(asset = Icons.Filled.Menu)
                }
            }
        )
        children()
    }
}