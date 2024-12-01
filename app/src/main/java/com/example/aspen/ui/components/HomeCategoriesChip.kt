package com.example.aspen.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun HomeCategoriesChip(
    itemText: String = "Location",
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    val backgroundColor =
        if (isSelected) LightPrimary.copy(alpha = 0.10f) else LightPrimary.copy(alpha = 0f)
    val textColor = if (isSelected) LightPrimary else Color.LightGray
    val fontWeight =
        if (isSelected) androidx.compose.ui.text.font.FontWeight.Bold else androidx.compose.ui.text.font.FontWeight.Normal

    MaterialTheme {
        Box(
            modifier = modifier
                .padding(16.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(24.dp)
                )
                .height(50.dp)
                .width(90.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                fontSize = 14.sp,
                text = itemText,
                color = textColor,
                fontWeight = fontWeight
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCategoriesChipPreview() {
    MaterialTheme {

        Column {
            HomeCategoriesChip(itemText = "Location", isSelected = true)
            HomeCategoriesChip(itemText = "Hotels", isSelected = false)
            HomeCategoriesChip(itemText = "Food", isSelected = false)
            HomeCategoriesChip(itemText = "Adventure", isSelected = false)
        }
    }
}