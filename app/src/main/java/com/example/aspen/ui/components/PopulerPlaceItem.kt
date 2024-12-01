package com.example.aspen.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
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
fun PopularPlaceItem() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .width(200.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.win),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Box(
                        modifier = Modifier
                            .width(95.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color(0xFF4D5652)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Alley Place",
                            color = LightOnPrimary,
                            fontSize = 12.sp
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 8.dp, end = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        AssistChip(
                            onClick = { },
                            label = {
                                Text(
                                    "4.1", color = Color.White,
                                    fontSize = 9.sp
                                )
                            },
                            leadingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Default.Star,
                                    tint = Color.Yellow,
                                    contentDescription = null,
                                    modifier = Modifier.size(12.dp)
                                )
                            },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Color(0xFF4D5652)
                            ),
                            border = BorderStroke(1.dp, Color(0xFF4D5652)),
                            modifier = Modifier
                                .height(25.dp)
                                .wrapContentWidth()

                        )

                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            androidx.compose.material3.Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color.Red,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }


                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PopularPlaceItemPreview() {
    MaterialTheme {
       Column {
           PopularPlaceItem()
           PopularPlaceItem()
       }

    }
}