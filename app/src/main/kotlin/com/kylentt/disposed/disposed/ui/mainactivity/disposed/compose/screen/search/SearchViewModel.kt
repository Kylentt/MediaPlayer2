package com.kylentt.disposed.disposed.ui.mainactivity.disposed.compose.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kylentt.mediaplayer.data.source.local.MediaStoreSource
import com.kylentt.mediaplayer.data.SongEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
  val mediaStore: MediaStoreSource
) : ViewModel() {

  private val _songList = MutableStateFlow(listOf<SongEntity>())
  val songList get() = _songList.asStateFlow()

  init {
    viewModelScope.launch {
      mediaStore.getMediaStoreSong().collect {
          _songList.value = it
      }
    }
  }
}
