package com.example.hellocompose.screen

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.livedata.observeAsState
import androidx.ui.material.Card
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.ListItem
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.hellocompose.data.Person
import com.example.hellocompose.data.getSuperheroList

@Composable
fun LiveDataScreen(openDrawer: () -> Unit) {
    ScreenComponent("LiveDataScreen", openDrawer) {
        val viewModel = ViewModelProvider(ContextAmbient.current as ViewModelStoreOwner).get(
            LiveDataScreenViewModel::class.java
        )
        LiveDataComponent(viewModel.getSuperheroes())
    }
}

@Composable
fun LiveDataComponent(personListLiveData: LiveData<List<Person>>) {
    val personList by personListLiveData.observeAsState(initial = emptyList())
    if (personList.isEmpty()) {
        LiveDataLoadingComponent()
    } else {
        LiveDataComponentList(personList)
    }
}

@Composable
fun LiveDataComponentList(personList: List<Person>) {
    AdapterList(data = personList) { person ->

        Card(
            shape = RoundedCornerShape(4.dp), color = Color.White,
            modifier = Modifier.fillMaxWidth() + Modifier.padding(8.dp)
        ) {
            ListItem(text = {
                Text(
                    text = person.name,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif, fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }, secondaryText = {
                Text(
                    text = "Age: ${person.age}",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif, fontSize = 15.sp,
                        fontWeight = FontWeight.Light, color = Color.DarkGray
                    )
                )
            }, icon = {
                person.profilePictureUrl?.let { imageUrl ->
                    NetworkImageComponent(
                        url = imageUrl,
                        modifier = Modifier.preferredWidth(60.dp) + Modifier.preferredHeight
                            (60.dp)
                    )
                }
            })
        }
    }
}

@Composable
fun LiveDataLoadingComponent() {
    Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Preview
@Composable
fun LiveDataComponentListPreview() {
    LiveDataComponentList(getSuperheroList())
}

@Preview
@Composable
fun LiveDataLoadingComponentPreview() {
    LiveDataLoadingComponent()
}
