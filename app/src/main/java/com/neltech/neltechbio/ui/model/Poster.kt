package com.neltech.neltechbio.ui.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Immutable
data class Poster(
    @PrimaryKey val id: Long,
    val name: String,
    val release: String,
    val playtime: String,
    val description: String,
    val plot: String,
    val poster: String,
    val gif: String
) {
    companion object {
        fun mock() = Poster(
            id = 0,
            name = "Tom and Jerry part-2",
            release = "2022",
            playtime = "2hrs 20 min",
            description = "Comedy Drama",
            plot = "Nice Movie every one must watch with your family and friends",
            poster = "https://cdn.pixabay.com/photo/2016/02/28/12/55/boy-1226964_960_720.jpg",
            gif = "https://giphy.com/embed/EPPkEcNbKVWBvtJnpf/video"

        )
    }
}

data class Failed(val code:Int,val message:String)