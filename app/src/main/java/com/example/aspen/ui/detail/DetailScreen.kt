package com.example.aspen.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.components.DetailScreenImageComponent
import com.example.aspen.ui.components.DetailScreenShowMapComponent
import com.example.aspen.ui.components.EmptyScreen
import com.example.aspen.ui.components.FacilitiesComponent
import com.example.aspen.ui.components.Facility
import com.example.aspen.ui.components.LoadingBar
import com.example.aspen.ui.components.PriceComponent
import com.example.aspen.ui.detail.DetailContract.UiAction
import com.example.aspen.ui.detail.DetailContract.UiEffect
import com.example.aspen.ui.detail.DetailContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun DetailScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> DetailContent()
    }
}

@Composable
fun DetailContent() {
    val sampleFacilities = listOf(
        Facility("1 Heater", Icons.Default.CheckCircle),
        Facility("Dinner", Icons.Default.Favorite),
        Facility("1 Tub", Icons.Default.Star),
        Facility("Pool", Icons.Default.Build)
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item() {
            DetailScreenImageComponent()
            DetailScreenShowMapComponent()
            FacilitiesComponent(sampleFacilities)
            Spacer(modifier = Modifier.height(16.dp))
            PriceComponent()
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(
    @PreviewParameter(DetailScreenPreviewProvider::class) uiState: UiState,
) {
    DetailScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}