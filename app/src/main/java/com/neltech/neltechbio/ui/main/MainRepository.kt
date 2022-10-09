package com.neltech.neltechbio.ui.main

import android.util.Log
import androidx.annotation.WorkerThread
import com.neltech.neltechbio.network.DisneyService
import com.neltech.neltechbio.ui.model.Poster
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

import javax.inject.Inject

class MainRepository @Inject constructor(private val disneyService: DisneyService,){

    private  val TAG = "MainRepository"
    @WorkerThread
    fun loadDisneyPosters(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ): Flow<List<Any>>

    {
       return flow<List<Poster>> {
           disneyService.fetchDisneyPosterList()
               .suspendOnSuccess { Log.d(TAG, "loadDisneyPosters: Success "+data)
                   emit(data)

               }
               .onError { Log.d(TAG, "loadDisneyPosters: Error ")
                   onError(message())
               }
               .onException { Log.d(TAG, "loadDisneyPosters: Exception") }

       }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)



    }

}