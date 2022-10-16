package com.neltech.neltechbio.util

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.neltech.neltechbio.ui.posters.DisneyHomeTab
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun NetworkImage(
    type: DisneyHomeTab,
    @PreviewParameter(NetworkUrlPreviewProvider::class) url: String,
    modifier: Modifier,
    bitmapPalette: BitmapPalette? = null,
    contentScale: ContentScale = ContentScale.Crop,

    ) {
    var con = LocalContext.current


    when (type) {
        DisneyHomeTab.HOME -> {

        }
        DisneyHomeTab.LIBRARY -> {

        }
        DisneyHomeTab.RADIO -> {

        }
    }

    CoilImage(
        imageRequest = ImageRequest.Builder(con)
            .data(url)
            .build(), shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color(0xA3C2C2C2),
            dropOff = 0.65f
        ),
        modifier = modifier
           , failure = {

        }
    )


}