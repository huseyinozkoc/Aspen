package com.example.aspen.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.components.EmptyScreen
import com.example.aspen.ui.components.ExploreButton
import com.example.aspen.ui.components.LoadingBar
import com.example.aspen.ui.splash.SplashContract.UiAction
import com.example.aspen.ui.splash.SplashContract.UiEffect
import com.example.aspen.ui.splash.SplashContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SplashScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> SplashContent()
    }
}

@Composable
fun SplashContent() {

        Column(modifier = Modifier.fillMaxSize()) {
            Box() {
                Image(
                    painter = painterResource(id = com.example.aspen.R.drawable.aspen_splash_background),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize()
                )

                Image(
                    painter = painterResource(id = com.example.aspen.R.drawable.aspen_icon),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth().padding(top = 64.dp, start = 24.dp, end = 24.dp),
                )


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Plan your\n")
                            withStyle(style = SpanStyle(fontSize = 40.sp, fontWeight = FontWeight.Normal)) {
                                append("Luxurious\n")
                            }
                            withStyle(style = SpanStyle(fontSize = 32.sp, fontWeight = FontWeight.Normal)) {
                                append("Vacation")
                            }
                        },
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Thin ,
                        modifier = Modifier.padding(16.dp)
                    )

                    Box(modifier = Modifier.padding(16.dp)) {
                        ExploreButton()
                    }
                }

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(
    @PreviewParameter(SplashScreenPreviewProvider::class) uiState: UiState,
) {
    SplashScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}