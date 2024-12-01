package com.example.aspen.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.R
import com.example.aspen.ui.theme.LightOnPrimary

@Composable
fun RecommendedPlaceItem(recommendedPlace: RecommendedPlaces) {
    MaterialTheme {
        Column {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = recommendedPlace.placeImage),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(75.dp)
                        .height(24.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            color = Color(0xFF4D5652)
                        )
                        .border(
                            BorderStroke(2.dp, Color.White),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = recommendedPlace.stayingDayAndNight,
                        color = LightOnPrimary,
                        fontSize = 12.sp
                    )
                }


            }
//-----------------------------------
            Text(
                text = recommendedPlace.placeName,
                modifier = Modifier.padding(16.dp)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RecommendedPlaceItemPreview() {
    MaterialTheme {
        RecommendedPlaceItem(
            recommendedPlace = TODO()
        )
    }
}