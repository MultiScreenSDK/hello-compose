package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.ripple
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

import com.example.hellocompose.R
import com.example.hellocompose.screen.widgets.TitleComponent

@Composable
fun MaterialScreen(openDrawer: () -> Unit) {
    ScreenComponent("MaterialScreen", openDrawer) {
        VerticalScroller {
            Column {
                TitleComponent("This is a simple Material card")
                MaterialCardComponent()

                TitleComponent("This is a loading progress indicator ")
                MaterialLinearProgressIndicatorComponent()

                TitleComponent("This is a determinate progress indicator")
                MaterialDeterminateLinearProgressIndicatorComponent()

                TitleComponent("This is a loading circular progress indicator")
                MaterialCircularProgressIndicatorComponent()

                TitleComponent("This is a determinate circular progress indicator")
                MaterialDeterminateCircularProgressIndicatorComponent()

                TitleComponent("This is a material Snackbar")
                MaterialSnackbarComponent()

                TitleComponent("This is a non-discrete slider")
                MaterialContinousSliderComponent()

                TitleComponent("This is a discrete slider")
                MaterialDiscreteSliderComponent()

                TitleComponent("This is a checkbox that represents two states")
                MaterialCheckboxComponent()

                TitleComponent("This is a checkbox that represents three states")
                MaterialTriStateCheckboxComponent()

                TitleComponent("This is a radio button group")
                MaterialRadioButtonGroupComponent()

                TitleComponent("This is a switch component")
                MaterialSwitchComponent()

                TitleComponent("This is how you add a ripple effect to a view")
                MaterialRippleComponent()
            }
        }
    }
}

@Composable
fun MaterialCardComponent() {
    val resources = ContextAmbient.current.resources

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        ListItem(text = {
            Text(text = "Title")
        }, secondaryText = {
            Text(text = "Subtitle")
        }, icon = {
            Box(modifier = Modifier.preferredWidth(48.dp) + Modifier.preferredHeight(48.dp)) {
                Image(asset = imageFromResource(resources, R.drawable.lenna))
            }
        })
    }
}

@Composable
fun MaterialCheckboxComponent() {
    var checked by state { false }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Checkbox(checked = checked,
                onCheckedChange = {
                    checked = !checked
                })
            Text(text = "Use Jetpack Compose", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun MaterialTriStateCheckboxComponent() {
    val toggleableStateArray =
        listOf(ToggleableState.Off, ToggleableState.On, ToggleableState.Indeterminate)
    var counter by state { 0 }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            TriStateCheckbox(
                state = toggleableStateArray[counter % 3],
                onClick = {
                    counter++
                })
            Text(text = "Use Jetpack Compose", modifier = Modifier.padding(start = 8.dp))
        }

    }
}

@Composable
fun MaterialRadioButtonGroupComponent() {
    var selected by state { "Android" }

    val radioGroupOptions = listOf<String>("Android", "iOS", "Windows")

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        RadioGroup(options = radioGroupOptions, selectedOption = selected, onSelectedChange = {
            selected = it
        })
    }
}

@Composable
fun MaterialLinearProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator()
        }
    }
}

@Composable
fun MaterialDeterminateLinearProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator(progress = 0.3f)
        }
    }
}

@Composable
fun MaterialCircularProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Composable
fun MaterialDeterminateCircularProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        CircularProgressIndicator(
            progress = 0.5f,
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun MaterialSnackbarComponent() {

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Snackbar(text = {
            Text(text = "I'm a very nice Snackbar")
        }, action = {
            Text(text = "OK", style = TextStyle(color = MaterialTheme.colors.secondary))
        })
    }

}

@Composable
fun MaterialContinousSliderComponent() {
    var sliderValue by state { 0f }


    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Slider(value = sliderValue, onValueChange = { newValue ->
            sliderValue = newValue
        })
    }
}

@Composable
fun MaterialDiscreteSliderComponent() {
    var sliderValue by state { 0f }


    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Slider(
            value = sliderValue,
            valueRange = 0f..10f,
            steps = 5,
            onValueChange = { sliderValue = it })
    }
}

@Composable
fun MaterialSwitchComponent() {
    var checked by state { false }


    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth(),
        color = Color(249, 249, 249)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Switch(checked = checked, onCheckedChange = {
                checked = !checked
            })
            Text(text = "Enable Dark Mode", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun MaterialRippleComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp) + Modifier.fillMaxWidth()
    ) {
        Clickable(onClick = {}, modifier = Modifier.ripple(bounded = true)) {
            Box(backgroundColor = Color.LightGray, shape = RoundedCornerShape(4.dp)) {
                Text(
                    text = "Click Me", modifier = Modifier.padding(16.dp), style = TextStyle(
                        fontSize = TextUnit.Sp(12), fontFamily = FontFamily.Serif
                    )
                )
            }

        }
    }
}

@Preview("MaterialCardComponent")
@Composable
fun MaterialCardComponentPreview() {
    MaterialCardComponent()
}

@Preview("MaterialCheckboxComponent")
@Composable
fun MaterialCheckboxComponentPreview() {
    MaterialCheckboxComponent()
}

@Preview("MaterialTriStateCheckboxComponent")
@Composable
fun MaterialTriStateCheckboxComponentPreview() {
    MaterialTriStateCheckboxComponent()
}

@Preview("MaterialRadioButtonGroupComponent")
@Composable
fun MaterialRadioButtonGroupComponentPreview() {
    MaterialRadioButtonGroupComponent()
}

@Preview("MaterialLinearProgressIndicatorComponent")
@Composable
fun MaterialLinearProgressIndicatorComponentPreview() {
    MaterialLinearProgressIndicatorComponent()
}

@Preview("MaterialDeterminateLinearProgressIndicatorComponent")
@Composable
fun MaterialDeterminateLinearProgressIndicatorComponentPreview() {
    MaterialDeterminateLinearProgressIndicatorComponent()
}

@Preview("MaterialCircularProgressIndicatorComponent")
@Composable
fun MaterialCircularProgressIndicatorComponentPreview() {
    MaterialCircularProgressIndicatorComponent()
}

@Preview("MaterialDeterminateCircularProgressIndicatorComponent")
@Composable
fun MaterialDeterminateCircularProgressIndicatorComponentPreview() {
    MaterialDeterminateCircularProgressIndicatorComponent()
}


@Preview("MaterialSnackbarComponent")
@Composable
fun MaterialSnackbarComponentPreview() {
    MaterialSnackbarComponent()
}

@Preview("MaterialContinousSliderComponent")
@Composable
fun MaterialContinousSliderComponentPreview() {
    MaterialContinousSliderComponent()
}

@Preview("MaterialDiscreteSliderComponent")
@Composable
fun MaterialDiscreteSliderComponentPreview() {
    MaterialDiscreteSliderComponent()
}

@Preview("MaterialSwitchComponent")
@Composable
fun MaterialSwitchComponentPreview() {
    MaterialSwitchComponent()
}

@Preview("MaterialRippleComponent")
@Composable
fun MaterialRippleComponentPreview() {
    MaterialRippleComponent()
}
