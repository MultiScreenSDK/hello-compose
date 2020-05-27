package com.example.hellocompose.screen

import androidx.compose.Composable
import androidx.compose.frames.open
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shadow
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.Divider
import androidx.ui.material.Surface
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.text.style.TextIndent
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.px
import androidx.ui.unit.sp

@Composable
fun StyledTextScreen(openDrawer: () -> Unit) {
    ScreenComponent("StyledTextScreen", openDrawer) {
        Surface(color = Color(0xFFffffff.toInt()), modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center) {
                VerticalScroller {
                    Column {
                        CustomStyledText(
                            "This is the default text style"
                        )

                        CustomStyledText(
                            "This text is blue in color",
                            style = TextStyle(
                                color = Color.Blue
                            )
                        )

                        CustomStyledText(
                            "This text has a bigger font size",
                            style = TextStyle(
                                fontSize = 30.sp
                            )
                        )

                        CustomStyledText(
                            "This text is bold",
                            style = TextStyle(
                                fontWeight = FontWeight.W700
                            )
                        )

                        CustomStyledText(
                            "This text is italic",
                            style = TextStyle(
                                fontStyle = FontStyle.Italic
                            )
                        )

                        CustomStyledText(
                            "This text is using a custom font family",
                            style = TextStyle(
                                fontFamily = FontFamily.Cursive
                            )
                        )

                        CustomStyledText(
                            "This text has an underline",
                            style = TextStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        )

                        CustomStyledText(
                            "This text has a strikethrough line",
                            style = TextStyle(
                                textDecoration = TextDecoration.LineThrough
                            )
                        )

                        CustomStyledText(
                            "This text will add an ellipsis to the end " +
                                    "of the text if the text is longer that 1 line long.",
                            maxLines = 1
                        )

                        CustomStyledText(
                            "This text has a shadow",
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black, blurRadius = 10.px,
                                    offset = Offset(2f, 2f)
                                )
                            )
                        )

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "This text is center aligned",
                                style = TextStyle(
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                        Divider(color = Color.Gray)

                        CustomStyledText(
                            "This text will demonstrate how to justify " +
                                    "your paragraph to ensure that the text that ends with a soft " +
                                    "line break spreads and takes the entire width of the container",
                            style = TextStyle(
                                textAlign = TextAlign.Justify
                            )
                        )

                        CustomStyledText(
                            "This text will demonstrate how to add " +
                                    "indentation to your text. In this example, indentation was only " +
                                    "added to the first line. You also have the option to add " +
                                    "indentation to the rest of the lines if you'd like",
                            style = TextStyle(
                                textAlign = TextAlign.Justify,
                                textIndent = TextIndent(firstLine = 30.sp)
                            )
                        )

                        CustomStyledText(
                            "The line height of this text has been " +
                                    "increased hence you will be able to see more space between each " +
                                    "line in this paragraph.",
                            style = TextStyle(
                                textAlign = TextAlign.Justify,
                                lineHeight = 20.sp
                            )
                        )

                        val annotatedString = AnnotatedString {
                            append("This string has style spans")
                            addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
                            addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
                            addStyle(style = SpanStyle(color = Color.Blue), start = 22, end = 27)
                        }
                        Text(annotatedString, modifier = Modifier.padding(16.dp))
                        Divider(color = Color.Gray)

                        Surface(color = Color.Yellow) {
                            Text(
                                text = "This text has a background color",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )

    Divider(color = Color.Gray)
}


@Preview
@Composable
fun PreviewStyledTextScreen() {
    StyledTextScreen(openDrawer = {})
}