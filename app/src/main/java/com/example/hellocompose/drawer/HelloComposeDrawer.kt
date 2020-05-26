package com.example.hellocompose.drawer

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.mutableStateOf
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.hellocompose.screen.SimpleTextScreen
import com.example.hellocompose.screen.StyledTextScreen

enum class HelloComposeScreen {
    SimpleTextScreen,
    StyledTextScreen
}

@Composable
fun DrawerContentComponent(
    currentScreen: MutableState<HelloComposeScreen>,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        HelloComposeScreen.values().forEach {
            DrawerContentItemComponent(
                currentScreen,
                it,
                closeDrawer
            )
        }
    }
}

@Composable
fun DrawerContentItemComponent(
    currentScreen: MutableState<HelloComposeScreen>,
    screen: HelloComposeScreen,
    closeDrawer: () -> Unit
) {
    val onDrawerContentItemClick = {
        currentScreen.value = screen
        closeDrawer()
    }

    Clickable(onClick = onDrawerContentItemClick) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = colorSelectedOr(
                currentScreen,
                screen
            )
        ) {
            Text(text = screen.name, modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun colorSelectedOr(
    currentScreen: MutableState<HelloComposeScreen>,
    screen: HelloComposeScreen
) =
    if (currentScreen.value == screen) MaterialTheme.colors.secondary else MaterialTheme.colors.surface

@Composable
fun BodyContentComponent(
    currentScreen: HelloComposeScreen,
    openDrawer: () -> Unit
) {
    when (currentScreen) {
        HelloComposeScreen.SimpleTextScreen -> SimpleTextScreen(
            openDrawer
        )
        HelloComposeScreen.StyledTextScreen -> StyledTextScreen(
            openDrawer
        )
        else -> throw IllegalArgumentException("Wrong Screen")
    }
}


@Preview
@Composable
fun PreviewDrawerContentComponent() {
    val emptyCloseDrawer = {}
    DrawerContentComponent(
        mutableStateOf(
            HelloComposeScreen.SimpleTextScreen
        ), emptyCloseDrawer
    )
}