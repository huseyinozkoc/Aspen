package com.example.aspen.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightPrimary

@Composable
fun SearchEditText() {
    var value by remember { mutableStateOf("") }
    MaterialTheme {
        TextField(
            value = value,
            onValueChange = { value = it },
            label = {
                Text(
                    "Find things to do", color = Color(0xFFB8B8B8),
                    modifier = Modifier,
                    fontSize = 12.sp
                )
            },
            maxLines = 2,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color(0xFFB8B8B8)
                )
            },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors().copy(

                focusedContainerColor = LightPrimary.copy(alpha = 0.10f),
                unfocusedContainerColor = LightPrimary.copy(alpha = 0.10f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent

            ),
            modifier = Modifier.padding(20.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchEditTextPreview() {
    MaterialTheme {
        SearchEditText()
    }
}