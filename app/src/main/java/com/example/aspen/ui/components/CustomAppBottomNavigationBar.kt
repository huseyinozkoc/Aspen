package com.example.aspen.ui.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aspen.ui.theme.LightPrimary

@Composable
fun CustomAppBottomNavigationBar(
    currentScreen: String,
    onNavBarItemClick: (String) -> Unit
) {
    val items: List<ScreenItem> = listOf(
        ScreenItem("Home", Icons.Filled.Home, "Home"),
        ScreenItem("Profile", Icons.Filled.Person, "Profil"),
        ScreenItem("dashboardScreen", Icons.Filled.Favorite, "Call"),
        ScreenItem("loginScreen", Icons.Filled.Info , "Build"),
    )

    MaterialTheme(
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(24.dp))
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items.forEach { screenItem ->
                    val isSelected = currentScreen == screenItem.screen
                    val color by animateColorAsState(
                        if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground,
                        label = ""
                    )

                    Box(
                        modifier = Modifier
                            .height(56.dp)
                            .weight(1f) // Itemler yayılabileceği kadar yayılsın
                            .width(110.dp)
                            .padding(8.dp)
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource(),
                                onClick = { onNavBarItemClick(screenItem.screen) }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clip(CircleShape)
                                .width(96.dp)
                                .background(Color.Transparent),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                screenItem.icon,
                                modifier = Modifier
                                    .size(25.dp),
                                contentDescription = screenItem.title,
                                tint = (if (isSelected) LightPrimary else Color.White),
                            )
                            /*
                            Text(
                                screenItem.title,
                                color = color,
                                fontSize = 14.sp,
                                modifier = Modifier.wrapContentHeight()
                            )

                             */
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBottomNavigationBarPreview1() {
    val currentScreen = "None"
    MaterialTheme() {
        CustomAppBottomNavigationBar(
            currentScreen,
            {})
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBottomNavigationBarPreview2() {
    val currentScreen = "Home"
    MaterialTheme() {
        CustomAppBottomNavigationBar(
            currentScreen,
            {})
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBottomNavigationBarPreview3() {
    val currentScreen = "Profile"
    MaterialTheme() {
        CustomAppBottomNavigationBar(
            currentScreen,
            {})
    }
}

data class ScreenItem(
    val screen: String,
    val icon: ImageVector,
    val title: String
)