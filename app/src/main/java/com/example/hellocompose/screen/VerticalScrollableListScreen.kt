package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.hellocompose.data.Person
import com.example.hellocompose.data.colors
import com.example.hellocompose.data.getPersonList

@Composable
fun VerticalScrollableListScreen(openDrawer: () -> Unit) {
    ScreenComponent("VerticalScrollableScreen", openDrawer) {
        VerticalScrollableListComponent(getPersonList())
    }
}

@Composable
fun VerticalScrollableListComponent(personList: List<Person>) {
    AdapterList(data = personList) { person ->
        val index = personList.indexOf(person)
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                shape = RoundedCornerShape(10.dp), color = colors[index % colors.size],
                modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)
            ) {
                Text(
                    person.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewVerticalScrollableListScreen() {
    VerticalScrollableListScreen({})
}

@Preview
@Composable
fun PreviewVerticalScrollableListComponent() {
    VerticalScrollableListComponent(getPersonList())
}