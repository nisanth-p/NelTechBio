package com.neltech.neltechbio.util

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.neltech.neltechbio.ui.model.Poster
import com.neltech.neltechbio.ui.posters.DisneyHomeTab
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun NetworkImage(posters: List<Poster>, type: DisneyHomeTab) {
    var con = LocalContext.current
    Log.d("TAG", "NetworkImage: " + posters[1].poster)
    var modifier: Modifier
    var url: String
    if (type == DisneyHomeTab.HOME) {

        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
        url= posters[0].poster
    }else{
        modifier = Modifier.fillMaxSize()
        url=    posters[1].poster
    }
    CoilImage(
        imageRequest = ImageRequest.Builder(con)
            .data(url)
            .build(), shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color(0xA3C2C2C2),
            dropOff = 0.65f
        ),
        modifier =modifier
    )


}