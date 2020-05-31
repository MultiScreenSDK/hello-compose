package com.example.hellocompose.screen

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.input.PasswordVisualTransformation
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.FilledTextField
import androidx.ui.material.Surface
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextDecoration
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import com.example.hellocompose.screen.widgets.TitleComponent


@Composable
fun TextFieldsScreen(openDrawer: () -> Unit) {
    ScreenComponent("TextFieldsScreen", openDrawer) {
        VerticalScroller {
            Column {
                TitleComponent("This is a Simple Text Input field")
                SimpleTextInputComponent()

                TitleComponent("This is a TextInput with custom text style")
                CustomStyleTextInputComponent()

                TitleComponent("This is a TextInput suitable for typing numbers")
                NumberTextInputComponent()

                TitleComponent("This is a search view created using TextInput")
                SearchImeActionInputComponent()

                TitleComponent("This is a TextInput that uses a Password Visual Transformation")
                PasswordVisualTransformationInputComponent()

                TitleComponent("This is a filled TextInput field based on Material Design")
                FilledTextInputComponent()
            }
        }
    }
}

@Composable
fun SimpleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by state { TextFieldValue("Enter your text here") }
        TextField(value = textValue,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),

            onValueChange = {
                textValue = it
            }
        )
    }
}


@Composable
fun CustomStyleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by state { TextFieldValue("Enter your text here") }
        TextField(value = textValue,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Blue,
                fontSize = TextUnit.Sp(20),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            ),
            onValueChange = {
                textValue = it
            }
        )
    }
}


@Composable
fun NumberTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by state { TextFieldValue("123") }
        TextField(value = textValue,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Number,
            onValueChange = {
                textValue = it
            }
        )
    }
}


@Composable
fun SearchImeActionInputComponent() {
    val context = ContextAmbient.current

    Surface(
        color = Color.LightGray, modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        var textValue by state { TextFieldValue("Enter your search query here") }
        TextField(value = textValue,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            imeAction = ImeAction.Search,
            onImeActionPerformed = {
                hideKeyboard(context)
            },
            onValueChange = {
                textValue = it
            }
        )
    }
}


@Composable
fun PasswordVisualTransformationInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by state { TextFieldValue("Enter your password here") }
        TextField(value = textValue,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                textValue = it
            }
        )
    }
}


@Composable
fun FilledTextInputComponent() {
    var textValue by state { TextFieldValue("") }

    FilledTextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") },
        modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth()
    )
}

private fun hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
}

@Preview
@Composable
fun SimpleTextInputComponentPreview() {
    SimpleTextInputComponent()
}

@Preview
@Composable
fun CustomStyleTextInputComponentPreview() {
    CustomStyleTextInputComponent()
}

@Preview
@Composable
fun NumberTextInputComponentPreview() {
    NumberTextInputComponent()
}

@Preview
@Composable
fun SearchImeActionInputComponentPreview() {
    SearchImeActionInputComponent()
}

@Preview
@Composable
fun PasswordVisualTransformationInputComponentPreview() {
    PasswordVisualTransformationInputComponent()
}

@Preview
@Composable
fun FilledTextInputComponentPreview() {
    FilledTextInputComponent()
}
