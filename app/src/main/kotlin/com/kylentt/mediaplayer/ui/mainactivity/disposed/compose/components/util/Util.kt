package com.kylentt.mediaplayer.ui.mainactivity.disposed.compose.components.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

@Composable
fun NoRipple(
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    LocalRippleTheme provides object : RippleTheme {
      @Composable
      override fun defaultColor(): Color = Color.Transparent

      @Composable
      override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        0f, 0f, 0f, 0f
      )
    }
  ) {
    content()
  }
}

@Composable
fun StatusBarSpacer() {
  Spacer(modifier = Modifier.height(with(LocalDensity.current) {
    WindowInsets.statusBars.getTop(this).toDp()
  }))
}