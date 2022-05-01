package com.kylentt.mediaplayer.app.settings

import kotlinx.serialization.Serializable

/**
 * Class to store the Preference Settings for App Wallpaper,
 * e.g: Scrolling Wallpaper from MediaItem embedded Picture controlled by Navigation Index,
 * similar to some phone Home Screen
 * @author Kylentt
 * @since 2022/04/30
 * @constructor [mode] the [Mode] of the Wallpaper
 * @constructor [source] the [Source] of the Wallpaper
 * @constructor [sourceALT] the [Source] of the Wallpaper if [source] doesn't Exist
 * @property [Companion.DEFAULT] static Default Implementation Instance
 */

@Serializable
data class WallpaperSettings(
  val mode: Mode,
  val source: Source,
  val sourceALT: Source
) {

  enum class Mode {
    NORMAL,
    NAVIGATION,
  }

  enum class Source {
    DEVICE_WALLPAPER,
    MEDIA_ITEM,
    SYSTEM_MODE
  }

  companion object {

    @JvmStatic val DEFAULT by lazy {
      val mode = Mode.NAVIGATION
      val source = Source.MEDIA_ITEM
      val sourceAlt = Source.DEVICE_WALLPAPER
      WallpaperSettings(mode = mode, source = source, sourceALT = sourceAlt)
    }

  }
}
