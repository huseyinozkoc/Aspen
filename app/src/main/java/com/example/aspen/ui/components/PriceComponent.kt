package com.example.aspen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightOnPrimary
import com.example.aspen.ui.theme.LightPrimary

@Composable
fun PriceComponent() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {


                Column(modifier = Modifier.fillMaxWidth(0.3f)) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Price",
                        fontSize = 8.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                        color = Color.Black,
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "$199",
                        fontSize = 16.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color(0xFF2DD7A4),
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .background(color = LightPrimary, shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 16.dp)
                            .height(50.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(text = "Book Now", color = LightOnPrimary)

                            androidx.compose.material3.Icon(
                                imageVector = Icons.Default.ArrowForward,
                                tint = LightOnPrimary,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
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
fun PriceComponentPreview() {
    MaterialTheme {
        PriceComponent()
    }
}