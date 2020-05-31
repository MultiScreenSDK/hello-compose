package com.example.hellocompose.screen

import androidx.compose.*
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.hellocompose.screen.widgets.TitleComponent

@Composable
fun StateManagementScreen(openDrawer: () -> Unit) {
    ScreenComponent("StateManagementScreen", openDrawer) {
        var counter by state { 0 }
        CounterWithTwoButtonsComponent(
            increment = { counter++ },
            reset = { counter = 0 },
            getValue = { counter })

        Divider(color = MaterialTheme.colors.secondary)

        val counterState = CounterState()
        CounterWithTwoButtonsComponent(
            increment = { counterState.counter++ },
            reset = { counterState.counter = 0 },
            getValue = { counterState.counter })
    }
}

@Composable
fun CounterWithTwoButtonsComponent(increment: () -> Unit, reset: () -> Unit, getValue: () -> Int) {
    TitleComponent(title = "Example with model class.")

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { increment() }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Increment")
        }

        Button(onClick = { reset() }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Reset")
        }
    }

    Text(text = "Counter value is ${getValue()}", modifier = Modifier.padding(16.dp))
}

@Model
class CounterState(var counter: Int = 0)

@Preview
@Composable
fun PreviewStateManagementScreen() {
    StateManagementScreen({})
}
