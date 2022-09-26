package com.neltech.neltechbio.ui.main

import com.neltech.neltechbio.network.DisneyService
import javax.inject.Inject

class MainRepo @Inject constructor(private val disneyService: DisneyService,){
init {
    disneyService.callServer()
}
}