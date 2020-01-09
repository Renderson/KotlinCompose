package com.renderson.kotlincompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NewsStory()
            }
        }
    }
}

@Composable
fun NewsStory() {
    val context = +ambient(ContextAmbient)
    val image = imageFromResource(context.resources, R.drawable.header)
    MaterialTheme {
        //val typography = +MaterialTheme.typography()
        Card(shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = Spacing(16.dp)
            ) {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image)
                    }
                }
                HeightSpacer(16.dp)
                titleCard("A day wandering through the sandhills" +
                        "in Shark Fin Cove, and a few of the" +
                        "sights I saw")
                HeightSpacer(8.dp)
                Text(
                    "Davenport, California",
                    style = +themeTextStyle { body2.withOpacity(0.87f) }
                )
                HeightSpacer(4.dp)
                Text(
                    "January 2020",
                    style = +themeTextStyle { body2.withOpacity(0.87f) }
                )
            }
        }
    }
}

fun titleCard(text : String) {
    Text(
        text,
        //modifier = Spacing(8.dp),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = +themeTextStyle { h6.withOpacity(0.87f) }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}