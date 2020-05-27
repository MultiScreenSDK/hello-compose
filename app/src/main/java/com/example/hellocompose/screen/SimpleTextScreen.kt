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
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.sp

@Composable
fun SimpleTextScreen(openDrawer: () -> Unit) {
    ScreenComponent("SimpleTextScreen", openDrawer) {
        Surface(color = Color(0xFFffffff.toInt()), modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center) {
                Text(text = "Hello Jetpack Compose!!")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSimpleTextScreen() {
    SimpleTextScreen(openDrawer = {})
}