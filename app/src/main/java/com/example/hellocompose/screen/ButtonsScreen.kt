package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.OutlinedButton
import androidx.ui.material.TextButton
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun ButtonsScreen(openDrawer: () -> Unit) {
    ScreenComponent("ButtonsScreen", openDrawer) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalGravity = Alignment.CenterHorizontally
        ) {
            SimpleButtonComponent()
            SimpleButtonWithBorderComponent()
            RoundedCornerButtonComponent()
            OutlinedButtonComponent()
            TextButtonComponent()
        }
    }
}

@Composable
fun SimpleButtonComponent() {
    Button(
        modifier = Modifier.padding(16.dp),
        onClick = {}) {
        Text(text = "Simple button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SimpleButtonWithBorderComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        border = Border(size = 5.dp, brush = SolidColor(Color.Black))
    ) {
        Text(text = "Simple button with border", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RoundedCornerButtonComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = "Button with rounded corners", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Outlined Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TextButtonComponent() {
    TextButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Text Button", modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun PreviewButtonsScreen() {
    ButtonsScreen(openDrawer = {})
}
