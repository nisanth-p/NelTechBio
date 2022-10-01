package com.neltech.neltechbio.ui.posters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.neltech.neltechbio.ui.main.MainViewModel
import com.neltech.neltechbio.ui.main.NavScreen
import com.neltech.neltechbio.ui.model.Poster

@Composable
fun Posters(viewModel: MainViewModel, selectPoster: (Long) -> Unit) {
    val posters: List<Poster> by viewModel.posterList.collectAsState(initial = listOf())
    //val posters1: State<List<Poster>> = viewModel.posterList.collectAsState(initial = listOf())
}

@Preview(showBackground = true)
@Composable
fun PostersPreview(){

}