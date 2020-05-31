package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.text.FirstBaseline
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import com.example.hellocompose.screen.widgets.TitleComponent

@Composable
fun ViewLayoutScreen(openDrawer: () -> Unit) {
    ScreenComponent("ViewLayoutScreen", openDrawer) {
        VerticalScroller {
            Column {
                TitleComponent("Child views with equal weights")
                RowEqualWeightComponent()

                TitleComponent("Child views with unequal weights")
                RowUnequalWeightComponent()

                TitleComponent("Child view with auto space in between")
                RowAddSpaceBetweenViewsComponent()

                TitleComponent("Child views spaced evenly")
                RowSpaceViewsEvenlyComponent()

                TitleComponent("Space added around child views")
                RowSpaceAroundViewsComponent()

                TitleComponent("Child views centered")
                RowViewsCenteredComponent()

                TitleComponent("Child views arranged in end")
                RowViewsArrangedInEndComponent()

                TitleComponent("Baseline of child views aligned")
                RowBaselineAlignComponent()

                TitleComponent("Baseline of child views not aligned")
                RowBaselineUnalignedComponent()
            }
        }
    }
}

@Composable
fun RowEqualWeightComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier.weight(1f) + Modifier.padding(4.dp), onClick = {}) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(modifier = Modifier.weight(1f) + Modifier.padding(4.dp), onClick = {}) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowUnequalWeightComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier.weight(0.66f) + Modifier.padding(4.dp), onClick = {}) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(modifier = Modifier.weight(0.34f) + Modifier.padding(4.dp), onClick = {}) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowAddSpaceBetweenViewsComponent() {
    Row(modifier = Modifier.fillMaxWidth() + Modifier.padding(4.dp), horizontalArrangement = Arrangement
        .SpaceBetween) {
        Button(onClick = {}) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(onClick = {}) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowSpaceViewsEvenlyComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = {}) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(onClick = {}) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowSpaceAroundViewsComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {}) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(onClick = {}) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowViewsCenteredComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowViewsArrangedInEndComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(text = "Button 1",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }

        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(text = "Button 2",
                style = TextStyle(fontSize = TextUnit.Sp(20))
            )
        }
    }
}

@Composable
fun RowBaselineAlignComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Text 1",
            style = TextStyle(fontSize = TextUnit.Sp(20), fontStyle = FontStyle.Italic),
            modifier = Modifier.alignWithSiblings(alignmentLine = FirstBaseline)
        )
        Text(text = "Text 2",
            style = TextStyle(fontSize = TextUnit.Sp(40), fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold),
            modifier = Modifier.alignWithSiblings(alignmentLine = FirstBaseline)
        )
    }
}

@Composable
fun RowBaselineUnalignedComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Text 1",
            style = TextStyle(fontSize = TextUnit.Sp(20), fontStyle = FontStyle.Italic)
        )
        Text(text = "Text 2",
            style = TextStyle(fontSize = TextUnit.Sp(40), fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold)
        )
    }
}

@Preview("Child views with equal weights")
@Composable
fun RowEqualWeightComponentPreview() {
    RowEqualWeightComponent()
}

@Preview("Child views with unequal weights")
@Composable
fun RowUnequalWeightComponentPreview() {
    RowUnequalWeightComponent()
}

@Preview("Child view with auto space in between arrangement")
@Composable
fun RowAddSpaceBetweenViewsComponentPreview() {
    RowAddSpaceBetweenViewsComponent()
}

@Preview("Child views spaced evenly arrangement")
@Composable
fun RowSpaceViewsEvenlyComponentPreview() {
    RowSpaceViewsEvenlyComponent()
}

@Preview("Space added around child views arrangement")
@Composable
fun RowSpaceAroundViewsComponentPreview() {
    RowSpaceAroundViewsComponent()
}

@Preview("Child views centered arrangement")
@Composable
fun RowViewsCenteredComponentPreview() {
    RowViewsCenteredComponent()
}

@Preview("Child views arranged in end")
@Composable
fun RowViewsArrangedInEndComponentPreview() {
    RowViewsArrangedInEndComponent()
}

@Preview("Baseline of child views aligned")
@Composable
fun RowBaselineAlignComponentPreview() {
    RowBaselineAlignComponent()
}

@Preview("Baseline of child views not aligned")
@Composable
fun RowBaselineUnalignedComponentPreview() {
    RowBaselineUnalignedComponent()
}
