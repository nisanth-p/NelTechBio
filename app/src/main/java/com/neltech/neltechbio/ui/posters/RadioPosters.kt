package com.neltech.neltechbio.ui.posters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.statusBarsPadding
import com.neltech.neltechbio.R
import com.neltech.neltechbio.ui.model.Poster
import com.neltech.neltechbio.util.NetworkImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RadioPosters(posters: List<Poster>, selectPoster: (Long) -> Unit, radio: DisneyHomeTab){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
        bottomBar = {},
        contentColor = Color(R.color.red),
        snackbarHost = {},
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colors.background)
                    .padding(innerPadding)
            ) {
                Text(text = posters[1].name + "")
                NetworkImage(posters,radio)
            }
        }
    )
}