package com.example.aspen.ui.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen.ui.theme.LightPrimary
import com.example.aspen.ui.theme.LightOnPrimary
import com.example.aspen.R
import kotlinx.coroutines.launch
import kotlin.text.category
import kotlin.text.get

@Composable
fun HomeScreenPager() {

    val exampleData = listOf(
        HomeScreenPagerItem(
            category = "Locations",
            popularPlaces = listOf(
                PopularPlaces("Mountain View", R.drawable.win, "4.5", true),
                PopularPlaces("Lake Side", R.drawable.win, "4.7", false)
            ),
            recommendedPlaces = listOf(
                RecommendedPlaces("Forest Retreat", R.drawable.win, "2N/1D"),
                RecommendedPlaces("Beach Resort", R.drawable.win, "3N/2D")
            )
        ),
        HomeScreenPagerItem(
            category = "Hotels",
            popularPlaces = listOf(
                PopularPlaces("City Park", R.drawable.win, "4.3", true),
                PopularPlaces("Museum", R.drawable.win, "4.6", false)
            ),
            recommendedPlaces = listOf(
                RecommendedPlaces("Downtown Hotel", R.drawable.win, "1N/1D"),
                RecommendedPlaces("Skyline View", R.drawable.win, "2N/1D")
            )
        ),
        HomeScreenPagerItem(
            category = "Food",
            popularPlaces = listOf(
                PopularPlaces("Hiking Trail", R.drawable.win, "4.8", true),
                PopularPlaces("Rock Climbing", R.drawable.win, "4.9", false)
            ),
            recommendedPlaces = listOf(
                RecommendedPlaces(
                    "Mountain Cabin",
                    R.drawable.aspen_splash_background,
                    "3N/1D"
                ),
                RecommendedPlaces("Desert Camp", R.drawable.win, "2N/1D")
            )
        ),
        HomeScreenPagerItem(
            category = "Adventure",
            popularPlaces = listOf(
                PopularPlaces("Spa Resort", R.drawable.win, "4.4", true),
                PopularPlaces("Hot Springs", R.drawable.win, "4.6", false)
            ),
            recommendedPlaces = listOf(
                RecommendedPlaces("Luxury Hotel", R.drawable.win, "2N/3D"),
                RecommendedPlaces(
                    "Countryside Inn",
                    R.drawable.aspen_splash_background,
                    "3N/1D"
                )
            )
        )
    )

    MaterialTheme {
        // Display exampleData items
        val pagerState = rememberPagerState(pageCount = {
            exampleData.size
        })

        val selectedCategoryIndex = remember { mutableStateOf(0) }

        val coroutineScope = rememberCoroutineScope()

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) { page ->


            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    LazyRow {
                        items(exampleData) { item ->
                            val index = exampleData.indexOf(item)
                            HomeCategoriesChip(
                                itemText = item.category,
                                isSelected = selectedCategoryIndex.value == index,
                                modifier = Modifier.clickable {
                                    selectedCategoryIndex.value = index
                                    coroutineScope.launch {
                                        pagerState.scrollToPage(index)
                                    }
                                }
                            )
                        }
                    }
                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Popular",
                        fontSize = 24.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "See All",
                        fontSize = 16.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = LightPrimary,
                        modifier = Modifier.padding(end = 16.dp)
                    )

                }


                Row(modifier = Modifier.fillMaxWidth()) {
                    LazyRow {
                        items(exampleData[page].popularPlaces) { popularPlace ->
                            PopularPlaceItem(popularPlace)
                        }
                    }
                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Recommended",
                        fontSize = 24.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 16.dp)
                    )


                }



                Row(modifier = Modifier.fillMaxWidth()) {
                    LazyRow {
                        items(exampleData[page].recommendedPlaces) { recommendedPlace ->
                            RecommendedPlaceItem(recommendedPlace)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))


            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPagerPreview() {
    MaterialTheme {
        HomeScreenPager()
    }
}

data class HomeScreenPagerItem(
    val category: String,
    val popularPlaces: List<PopularPlaces>,
    val recommendedPlaces: List<RecommendedPlaces>
)


data class PopularPlaces(
    val placeName: String,
    val placeImage: Int,
    val placeRating: String,
    val isFav: Boolean
)

data class RecommendedPlaces(
    val placeName: String,
    val placeImage: Int,
    val stayingDayAndNight: String,
)