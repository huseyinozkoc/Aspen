package com.example.aspen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightPrimary

@Composable
fun HomeScreenTopComponent() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {


                Column(modifier = Modifier.fillMaxWidth(0.3f)) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        text = "Explore",
                        fontSize = 24.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                        color = Color.Black,
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Aspen",
                        fontSize = 36.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Black,
                    )
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

                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.LocationOn,
                            tint = LightPrimary,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )

                        Text(
                            text = "Aspen,USA",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Thin
                        )

                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            tint = LightPrimary,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }


        }

    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenTopComponentPreview() {
    MaterialTheme {
        HomeScreenTopComponent()
    }
}