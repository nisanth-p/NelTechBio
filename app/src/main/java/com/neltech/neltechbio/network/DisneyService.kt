package com.neltech.neltechbio.network

import com.neltech.neltechbio.ui.model.Poster
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface DisneyService {
    fun callServer()
    @GET("DisneyPosters2.json")
    suspend fun fetchDisneyPosterList(): ApiResponse<List<Poster>>
}