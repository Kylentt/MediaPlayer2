package com.flammky.musicplayer.ui.main.compose.screens.library.old

import androidx.media3.common.MediaItem
import com.flammky.android.medialib.temp.api.player.MediaController
import com.flammky.musicplayer.domain.musiclib.core.MusicLibrary
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

	@Provides
	@Singleton
	fun provideInteractor(): LibraryViewModelOld.SessionInteractor = SessionInteractor()

	private class SessionInteractor : LibraryViewModelOld.SessionInteractor {
		private val player: MediaController
			get() = MusicLibrary.api.localAgent.session.player

		override fun getAllMediaItems(): List<MediaItem> {
			return player.getAllMediaItems()
		}

		override fun removeMediaItem(item: MediaItem) {
			player.removeMediaItem(item)
		}

		override fun removeMediaItems(items: List<MediaItem>) {
			player.removeMediaItems(items)
		}

		override fun pause() {
			player.pause()
		}

		override suspend fun play(model: LibraryViewModelOld.LocalSongModel) {
			player.joinSuspending {
				if (!player.connected) player.connectService().await()
				player.play(model.mediaItem)
			}
		}
	}
}
