package com.example.soundinch7.ui.models

import android.provider.MediaStore

data class Playlist(
    val id:   Int,
    val name: String,
    val genres: String,
    val songCount: Int,
    val colorHex: String,
    val isFavorite: Boolean
)
