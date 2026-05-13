package com.example.soundinch7.ui.theme

import android.app.ActionBar
import androidx.compose.ui.graphics.Path.Companion.combine
import androidx.compose.ui.text.style.TextDecoration.Companion.combine
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soundinch7.ui.PlaylistRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.soundinch7.ui.models.Playlist
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn


class LibraryViewModel : ViewModel() {

    private val _selectedTab = MutableStateFlow(    0)

    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    val playlist: StateFlow<List<Playlist>> = PlaylistRepository.playlist

    val filterPlaylist: StateFlow<List<Playlist>> = combine(flow = PlaylistRepository.playlist, flow2 = _selectedTab)
    { playlist, tabIndex ->
        when (tabIndex) {
        0 -> playlist
        1 -> playlist.filter {it.isFavorite}
        else -> playlist
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


}