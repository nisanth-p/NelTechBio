package com.neltech.neltechbio.ui.posters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsPadding
import com.neltech.neltechbio.R
import com.neltech.neltechbio.ui.model.Poster
import com.neltech.neltechbio.util.NetworkImage

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomePosters(posters: List<Poster>, selectPoster: (Long) -> Unit, home: DisneyHomeTab) {
    Scaffold(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(R.color.yellowgreen)),
        topBar = { topBar1() },
        bottomBar = {},
        contentColor = Color.Red,
        snackbarHost = {},
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colors.background)
                    .padding(innerPadding)
            ) {
                Text(text = posters[0].name + "")
                 NetworkImage(posters,home)
            }
        }
    )

}


@Composable
fun topBar1(

) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = colorResource(id = R.color.red),
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.menu_home),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

