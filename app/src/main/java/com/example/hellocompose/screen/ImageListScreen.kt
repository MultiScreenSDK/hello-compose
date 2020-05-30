package com.example.hellocompose.screen

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.*
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.res.loadImageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.hellocompose.R
import com.example.hellocompose.screen.widgets.TitleComponent

@Composable
fun ImageListScreen(openDrawer: () -> Unit) {
    ScreenComponent("ImageListScreen", openDrawer) {
        VerticalScroller {
            Column(horizontalGravity = Alignment.CenterHorizontally) {
                TitleComponent("Load image from the resource folder")
                LocalImageComponent(resId = R.drawable.lenna)

                TitleComponent("Image with rounded corners")
                LocalImageWithRoundedCornersComponent(resId = R.drawable.lenna, size = 10.dp)

                TitleComponent("Load image from url using Glide")
                NetworkImageComponent()
            }
        }
    }
}

@Composable
fun LocalImageComponent(@DrawableRes resId: Int) {
    val image = loadImageResource(resId)
    image.resource.resource?.let {
        Image(
            asset = it,
            modifier = Modifier.preferredWidth(200.dp) + Modifier.preferredHeight(200.dp)
        )
    }
}

@Composable
fun LocalImageWithRoundedCornersComponent(@DrawableRes resId: Int, size: Dp) {
    Box(
        modifier = Modifier.clip(shape = RoundedCornerShape(size))
    ) {
        LocalImageComponent(resId)
    }
}

@Composable
fun NetworkImageComponent() {
    val url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png"

    var image by state<ImageAsset?> { null }
    val context = ContextAmbient.current

    onCommit(url) {
        val glide = Glide.with(context)
        val target = object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) {
                image = null
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                image = resource.asImageAsset()
            }
        }

        glide
            .asBitmap()
            .load(url)
            .into(target)

        onDispose {
            image = null
            glide.clear(target)
        }
    }

    val theImage = image
    if (theImage != null) {
        Image(
            asset = theImage,
            modifier = Modifier.preferredWidth(200.dp) + Modifier.preferredHeight(200.dp)
        )
    }
}

@Preview
@Composable
fun PreviewLocalImageComponent() {
    LocalImageComponent(R.drawable.lenna)
}

@Preview
@Composable
fun PreviewImageWithRoundedCorners() {
    LocalImageWithRoundedCornersComponent(R.drawable.lenna, 10.dp)
}

@Preview
@Composable
fun PreviewNetworkImageWithGlide() {
    NetworkImageComponent()
}