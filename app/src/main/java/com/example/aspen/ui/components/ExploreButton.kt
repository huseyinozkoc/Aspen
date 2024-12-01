package com.example.aspen.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aspen.ui.theme.LightPrimary
import com.example.aspen.ui.theme.LightOnPrimary

@Composable
fun ExploreButton() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .background(color = LightPrimary, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp)
                .height(50.dp)
                .fillMaxWidth()

            ,
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Explore", color = LightOnPrimary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreButtonPreview() {
    MaterialTheme {
        ExploreButton()
    }
}