package com.example.unsplashmobileapp.Presentation.Common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.unsplashmobileapp.Model.UnsplashImage
import com.example.unsplashmobileapp.R

@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { unsplashImage ->
                unsplashImage.id
            }) { unsplashImage ->
            unsplashImage?.let {
                UnsplashItem(unsplashImage = it)
            }
        }
    }
}

@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {
    val painter = rememberAsyncImagePainter(

        model = ImageRequest.Builder(LocalContext.current)
            .data(unsplashImage.urls.regular)
            .crossfade(true)
            .build(),
        error = painterResource(R.drawable.placeholder_light),
        placeholder = painterResource(R.drawable.placeholder_light),
        contentScale = ContentScale.Fit
    )
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user.userLinks}?utm_source=MobiApp&utm_medium=referral1")
                )
                startActivity(context, browserIntent, null)
            }
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Content Image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium), color = Color.Black
        ) { }
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(unsplashImage.user.username)
                    }
                    append(" on Unsplash.com")
                },
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }
    }
}