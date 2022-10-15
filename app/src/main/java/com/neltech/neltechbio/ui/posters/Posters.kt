package com.neltech.neltechbio.ui.posters


import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.neltech.neltechbio.R
import com.neltech.neltechbio.ui.main.MainViewModel
import com.neltech.neltechbio.ui.model.Poster

@Composable
fun Posters(viewModel: MainViewModel, selectPoster: (Long) -> Unit) {
    val posters: List<Poster> by viewModel.posterList.collectAsState(initial = listOf())
    //val posters1: State<List<Poster>> = viewModel.posterList.collectAsState(initial = listOf())
    val isLoading: Boolean by viewModel.isLoading
    val selectedTab = DisneyHomeTab.getTabFromResource(viewModel.selectedTab.value)
    val allTabsList = DisneyHomeTab.values()
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

                    allTabsList.forEach { tab ->

                        Log.d("TAG", "Posters: =============="+posters)
                        BottomNavigationItem(
                            label = { Text(stringResource(tab.title), color = Color.White) },
                            selected = tab == selectedTab,
                            onClick = { viewModel.selectTab(tab.title) },
                            icon = {
                                Icon(imageVector = tab.icon, contentDescription = null)
                            },
                            enabled = true,
                            alwaysShowLabel = true,
                            /* selectedContentColor = LocalContentColor.current,
                             unselectedContentColor = LocalContentColor.current,*/
                            modifier = Modifier.navigationBarsPadding()
                        )

                    }


                }
            },
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            }

        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            Crossfade(targetState = selectedTab) { destination ->
                when (destination) {
                    DisneyHomeTab.HOME -> HomePosters(posters,selectPoster,DisneyHomeTab.HOME)
                    DisneyHomeTab.RADIO -> RadioPosters(posters,selectPoster,DisneyHomeTab.RADIO)
                    DisneyHomeTab.LIBRARY -> LibraryPosters()
                }
            }

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

enum class DisneyHomeTab(
    @StringRes
    val title: Int,
    val icon: ImageVector
) {
    HOME(R.string.menu_home, Icons.Filled.Home),
    RADIO(R.string.menu_radio, Icons.Filled.Menu),
    LIBRARY(R.string.menu_library, Icons.Filled.Add);

    companion object {
        fun getTabFromResource(
            @StringRes
            title: Int
        ): DisneyHomeTab {


            return when (title) {
                R.string.menu_home -> {
                    HOME
                }
                R.string.menu_radio -> {
                    RADIO
                }
                else -> {
                    LIBRARY
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PostersPreview() {

}