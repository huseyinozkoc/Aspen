package com.example.aspen.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.components.CustomAppBottomNavigationBar
import com.example.aspen.ui.components.EmptyScreen
import com.example.aspen.ui.components.HomeScreenPager
import com.example.aspen.ui.components.HomeScreenTopComponent
import com.example.aspen.ui.components.LoadingBar
import com.example.aspen.ui.components.SearchEditText
import com.example.aspen.ui.home.HomeContract.UiAction
import com.example.aspen.ui.home.HomeContract.UiEffect
import com.example.aspen.ui.home.HomeContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> HomeContent()
    }
}
@Composable
fun HomeContent() {
    val currentScreen = remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            CustomAppBottomNavigationBar(
                currentScreen = currentScreen.value,
                onNavBarItemClick = { screen -> currentScreen.value = screen }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                HomeScreenTopComponent()
            }

            item {
                SearchEditText()
            }

            item {
                HomeScreenPager()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}