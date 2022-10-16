package com.neltech.neltechbio.ui.posters

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.insets.statusBarsPadding
import com.neltech.neltechbio.ui.model.Poster
import com.neltech.neltechbio.util.NetworkImage

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomePosters(
    posters: List<Poster>,
    selectPoster: (Long) -> Unit,
    home: DisneyHomeTab,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.background)
    ) {
        posters.forEach {
            HomePoster(poster = it, selectPoster = selectPoster)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePoster(modifier: Modifier = Modifier, poster: Poster, selectPoster: (Long) -> Unit) {


    Surface(
        onClick = { selectPoster(poster.id) },
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize(),

        tonalElevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Log.d("TAG", "HomePoster: ${poster.playtime}   ${poster.name}")


        ConstraintLayout() {
            val (image, title, content) = createRefs()
            NetworkImage(
                type = DisneyHomeTab.HOME,
                modifier = Modifier
                    .aspectRatio(0.8f)
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    },
                url = poster.poster,
            )
            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(image.bottom)
                    }
                    .padding(8.dp),
                text = poster.name,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
            )

            Text(
                modifier = Modifier
                    .constrainAs(content) {
                        centerHorizontallyTo(parent)
                        top.linkTo(title.bottom)
                    }
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 12.dp),
                text = poster.playtime,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
        }


    }
}



