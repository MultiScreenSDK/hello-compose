package com.example.hellocompose

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.material.DrawerState
import androidx.ui.material.ModalDrawerLayout
import com.example.hellocompose.drawer.BodyContentComponent
import com.example.hellocompose.drawer.DrawerContentComponent
import com.example.hellocompose.drawer.HelloComposeScreen

@Composable
fun HelloComposeApp() {

    val (drawerState, onDrawerStateChange) = state { DrawerState.Closed }
    val currentScreen = state { HelloComposeScreen.SimpleTextScreen }

    ModalDrawerLayout(
        drawerState = drawerState,
        onStateChange = onDrawerStateChange,
        gesturesEnabled = drawerState == DrawerState.Opened,
        drawerContent = {
            DrawerContentComponent(
                currentScreen = currentScreen,
                closeDrawer = { onDrawerStateChange(DrawerState.Closed) }
            )
        },
        bodyContent = {
            BodyContentComponent(
                currentScreen = currentScreen.value,
                openDrawer = {
                    onDrawerStateChange(DrawerState.Opened)
                }
            )
        }
    )
}

