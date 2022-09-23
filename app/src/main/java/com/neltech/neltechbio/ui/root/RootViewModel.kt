package com.neltech.neltechbio.ui.root

import android.os.Build
import androidx.lifecycle.ViewModel
import coil.ComponentRegistry
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor( val imageLoader: ImageLoader) :ViewModel(){
init {
    Timber.d("init RootViewModel")
}


}

