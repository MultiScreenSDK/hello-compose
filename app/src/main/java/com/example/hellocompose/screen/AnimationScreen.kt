package com.example.hellocompose.screen

import androidx.animation.LinearEasing
import androidx.animation.transitionDefinition
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.animation.ColorPropKey
import androidx.ui.animation.Transition
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxSize
import androidx.ui.tooling.preview.Preview

@Composable
fun AnimationScreen(openDrawer: () -> Unit) {
    ScreenComponent("AnimationScreen", openDrawer) {
        AnimateColorComponent()
    }
}

private val color = ColorPropKey()
private val colorDefinition = transitionDefinition {
    state(0) {
        this[color] = Color.Red
    }

    state(1) {
        this[color] = Color.Green
    }

    state(2) {
        this[color] = Color.Blue
    }

    transition(0 to 1, 1 to 2, 2 to 0) {
        color using tween {
            duration = 2000
            easing = LinearEasing
        }
    }
}

@Composable
fun AnimateColorComponent() {
    var initialState by state { 0 }
    var toState by state { 1 }
    Transition(definition = colorDefinition, initState = initialState, toState = toState,
        onStateChangeFinished =
        { state ->
            when (state) {
                0 -> {
                    initialState = 0
                    toState = 1
                }
                1 -> {
                    initialState = 1
                    toState = 2
                }
                2 -> {
                    initialState = 2
                    toState = 0
                }
            }
        }) { state ->
        Box(modifier = Modifier.fillMaxSize(), backgroundColor = state[color])
    }
}

@Preview
@Composable
fun AnimateColorComponentPreview() {
    AnimateColorComponent()
}
