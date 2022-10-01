package com.neltech.neltechbio.ui.main

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.neltech.neltechbio.ui.model.Poster
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var main:MainRepository) : ViewModel() {
    lateinit var  posterList: Flow<List<Poster>>

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading
    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    fun selectTab(@StringRes tab: Int){
        _selectedTab.value =tab
    }


    fun getPosterDetails():Flow<List<Poster>>{
        posterList= main.loadDisneyPosters(
            {//onStart

            },
            {
                //onComplete

            },
            {
                //onError
            }
        ) as Flow<List<Poster>>
  return posterList
    }
}