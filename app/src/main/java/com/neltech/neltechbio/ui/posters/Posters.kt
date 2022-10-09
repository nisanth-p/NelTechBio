package com.neltech.neltechbio.ui.posters


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.insets.navigationBarsHeight
import com.neltech.neltechbio.R
import com.neltech.neltechbio.ui.main.MainViewModel
import com.neltech.neltechbio.ui.model.Poster

@Composable
fun Posters(viewModel: MainViewModel, selectPoster: (Long) -> Unit) {
    val posters: List<Poster> by viewModel.posterList.collectAsState(initial = listOf())
    //val posters1: State<List<Poster>> = viewModel.posterList.collectAsState(initial = listOf())

    ConstraintLayout {
        val (body, progress) = createRefs()
        Scaffold(
            backgroundColor = MaterialTheme.colorScheme.primary,
            topBar = {
                topBar()
            },
            bottomBar = {
                BottomNavigation(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    modifier = Modifier
                        .navigationBarsHeight(56.dp)
                ) {

                }
            },
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            }

        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
           /* Crossfade(targetState =) {

            }*/

        }
    }

}

@Composable
fun topBar(

) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = colorResource(id = R.color.purple_200),
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostersPreview() {

}