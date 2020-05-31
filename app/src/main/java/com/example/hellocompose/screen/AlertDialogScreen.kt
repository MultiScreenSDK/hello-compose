package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview

@Composable
fun AlertDialogScreen(openDrawer: () -> Unit) {
    ScreenComponent(title = "AlertDialogScreen", openDrawer = openDrawer) {

        Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {
            val showPopup = state { false }

            Button(onClick = { showPopup.value = true }) {
                Text(text = "Click to see a dialog")
            }

            val onPopupDismissed = { showPopup.value = false }

            if (showPopup.value) {
                AlertDialog(
                    onCloseRequest = onPopupDismissed,
                    text = { Text("This is the AlertDialog.") },
                    confirmButton = {
                        Button(onClick = onPopupDismissed) {
                            Text(text = "Ok")
                        }
                    })
            }
        })
    }
}

@Preview
@Composable
fun PreviewAlertDialogScreen() {
    AlertDialogScreen({})
}