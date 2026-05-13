package com.example.soundinch7.ui.models

import android.icu.text.CaseMap

data class Song(
    val id: Int,
    val title: String,
    val artist: String,
    val durationSeconds: Int,
    val playlist: Int
)
