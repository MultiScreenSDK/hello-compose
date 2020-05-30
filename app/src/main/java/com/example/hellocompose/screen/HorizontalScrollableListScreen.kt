package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.hellocompose.data.Person
import com.example.hellocompose.data.getPersonList
import com.example.hellocompose.screen.widgets.TitleComponent

@Composable
fun HorizontalScrollableListScreen(openDrawer: () -> Unit) {
    ScreenComponent("HorizontalScrollableListScreen", openDrawer) {
        Column {
            TitleComponent("Horizontal Scrollable Carousel")
            HorizontalScrollableListComponent(getPersonList())
            TitleComponent("Horizontal Scrolling Carousel where each item occupies the width of the screen")
            HorizontalScrollableListComponentWithScreenWidth(getPersonList())
        }

    }
}

@Composable
fun HorizontalScrollableListComponent(personList: List<Person>) {
    HorizontalScroller(modifier = Modifier.fillMaxWidth()) {
        Row {
            personList.forEach {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black
                ) {
                    Text(
                        text = it.name,
                        style = TextStyle(fontSize = 20.sp, color = Color.White),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun HorizontalScrollableListComponentWithScreenWidth(personList: List<Person>) {
    HorizontalScroller(modifier = Modifier.fillMaxWidth()) {
        val displayMetrics = ContextAmbient.current.resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels / displayMetrics.density
        val spacing = 16.dp

        Row {
            personList.forEach {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black
                ) {
                    Box(
                        gravity = ContentGravity.Center,
                        modifier = Modifier.preferredWidth(screenWidth.dp - (spacing * 2))
                    ) {
                        Text(
                            text = it.name,
                            style = TextStyle(fontSize = 20.sp, color = Color.White),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHorizontalScrollableListScreen() {
    HorizontalScrollableListScreen({})
}