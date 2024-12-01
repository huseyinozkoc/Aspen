package com.example.aspen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightPrimary
import kotlin.times

@Composable
fun FacilitiesComponent(facilities: List<Facility>) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    MaterialTheme {
        Column {
            Text(
                text = "Facilities",
                modifier = Modifier.padding(8.dp),
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Color.Black
            )
            LazyRow(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(facilities) { facility ->
                    Box(
                        modifier = Modifier
                            .height(75.dp)
                            .width(screenWidth * 0.22f)
                            .background(
                                color = LightPrimary.copy(alpha = 0.1f), shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            androidx.compose.material3.Icon(
                                imageVector = facility.icon,
                                tint = Color.LightGray.copy(alpha = 0.5f),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = facility.name,
                                fontSize = 12.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                                color = Color.LightGray.copy(alpha = 0.90f),
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
fun FacilitiesComponentPreview() {
    val sampleFacilities = listOf(
        Facility("1 Heater", Icons.Default.CheckCircle),
        Facility("Dinner", Icons.Default.Favorite),
        Facility("1 Tub", Icons.Default.Star),
        Facility("Pool", Icons.Default.Build)
    )
    MaterialTheme {
        FacilitiesComponent(facilities = sampleFacilities)
    }
}


data class Facility(
    val name: String,
    val icon: ImageVector
)