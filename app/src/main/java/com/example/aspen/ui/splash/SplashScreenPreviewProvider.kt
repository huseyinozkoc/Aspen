package com.example.aspen.ui.splash

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SplashScreenPreviewProvider : PreviewParameterProvider<SplashContract.UiState> {
    override val values: Sequence<SplashContract.UiState>
        get() = sequenceOf(
            SplashContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            SplashContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            SplashContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}