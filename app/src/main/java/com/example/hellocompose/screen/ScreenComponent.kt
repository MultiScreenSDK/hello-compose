package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.IconButton
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.sp


@Composable
fun ScreenComponent(title: String, openDrawer: () -> Unit, children: @Composable() () -> Unit) {
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

@Preview
@Composable
fun PreviewScreenComponentWithText() {
    ScreenComponent(title = "PreviewScreenComponent", openDrawer = {}) {
        Surface(color = Color(0xFFffffff.toInt()), modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
                Text(
                    text = "Preview Screen Component With Text"
                )
            })
        }
    }
}