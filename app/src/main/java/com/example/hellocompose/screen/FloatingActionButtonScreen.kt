package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Notifications
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.hellocompose.data.colors

@Composable
fun FloatingActionButtonScreen(openDrawer: () -> Unit) {
    ScreenComponent("FloatingActionButtonScreen", openDrawer) {
        ScaffoldWithBottomBarAndCutout()
    }
}

@Composable
fun ScaffoldWithBottomBarAndCutout() {

    val scaffoldState = remember { ScaffoldState() }

    val fabShape = RoundedCornerShape(50)

    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = { TopAppBar(title = { Text("Scaffold") }) },
        bottomAppBar = { fabConfiguration ->
            BottomAppBar(fabConfiguration = fabConfiguration, cutoutShape = fabShape) {}
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = fabShape,
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                IconButton(onClick = {}) {
                    Icon(asset = Icons.Filled.Notifications)
                }
            }
        },
        floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked,
        bodyContent = { modifier ->
            VerticalScroller {
                Column(modifier) {
                    repeat(100) {
                        Card(color = colors[it % colors.size],
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Spacer(modifier = Modifier.fillMaxWidth() + Modifier.preferredHeight(200.dp))
                        }
                    }
                }
            }
        }
    )
}

@Preview("Fixed Action Button Example")
@Composable
fun ScaffoldWithBottomBarAndCutoutPreview() {
    ScaffoldWithBottomBarAndCutout()
}