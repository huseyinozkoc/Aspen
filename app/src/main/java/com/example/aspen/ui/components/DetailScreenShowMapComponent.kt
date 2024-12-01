package com.example.aspen.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightPrimary
import com.example.aspen.ui.theme.LightOnPrimary

@Composable
fun DetailScreenShowMapComponent() {
    var expanded by remember { mutableStateOf(false) }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Abeurdes Alpes",
                        fontSize = 12.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                        color = Color.Black,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Star,
                            tint = Color(0xFFE5C558),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(10.dp)
                        )
                        Text(
                            text = "4.5 (355 Reviews)",
                            fontSize = 6.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 3.dp)

                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.align(Alignment.End)
                    ) {


                        Text(
                            text = "Show Map",
                            color = LightPrimary,
                            fontSize = 12.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            modifier = Modifier.padding(end = 8.dp)
                        )


                    }
                }
            }


            Text(
                text = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. ",
                color = Color.Black,
                fontSize = 6.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                maxLines = if (expanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 8.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .animateContentSize()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Read More",
                    color = LightPrimary,
                    fontSize = 8.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                    modifier = Modifier.padding(start = 8.dp)
                )

                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    tint = LightPrimary,
                    contentDescription = null,
                    modifier = Modifier.size(8.dp)
                )
            }


        }


    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenShowMapComponentPreview() {
    MaterialTheme {
        DetailScreenShowMapComponent()
    }
}