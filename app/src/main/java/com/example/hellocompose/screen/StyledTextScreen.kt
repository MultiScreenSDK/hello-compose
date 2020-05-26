package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.Surface

@Composable
fun StyledTextScreen(openDrawer: () -> Unit) {
    ScreenComponent("StyledTextScreen", openDrawer) {
        Surface(color = Color(0xFFffd7d7.toInt()), modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
                Text(text = "Let me show some styled texts!!")
            })
        }
    }
}
