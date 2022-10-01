package com.neltech.neltechbio.ui.main

import androidx.annotation.WorkerThread
import com.neltech.neltechbio.network.DisneyService
import com.neltech.neltechbio.ui.model.Poster
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class MainRepository @Inject constructor(private val disneyService: DisneyService,){
init {
    disneyService.callServer()
}

    @WorkerThread
    fun loadDisneyPosters(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ): Flow<List<Any>>

    {
       return flow<List<Poster>> {

       }



    }

}