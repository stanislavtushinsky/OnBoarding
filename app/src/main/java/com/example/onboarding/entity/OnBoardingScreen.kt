package com.example.onboarding.entity

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onboarding.R
import com.example.onboarding.navigation.ResultPage
import com.example.onboarding.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    val listOfPages = listOf(
        OnBoardingPage.OnBoarding1,
        OnBoardingPage.OnBoarding2,
        OnBoardingPage.OnBoarding3,
        OnBoardingPage.OnBoarding4,
    )

    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val initialPosition = listOfPages.indexOfFirst { it.route == currentRoute }
    val pagerState =
        rememberPagerState(pageCount = { listOfPages.size }, initialPage = initialPosition)

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) { position ->
            PagerScreen(
                listOfPages[position],
                onNextPage = {
                    if (position < listOfPages.lastIndex) {
                        navController.navigate(listOfPages[position + 1].route)
                    } else {
                        navController.navigate(ResultPage.route)
                    }
                },
                pagerState = pagerState
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 24.dp, bottom = 6.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    currentPage = pagerState.currentPage
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(ResultPage.route)
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.skip_text),
                        style = Typography.bodyLarge
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(pagerState: PagerState, currentPage: Int) {
    val rowModifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(bottom = 8.dp)
    Row(
        modifier = rowModifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (currentPage == iteration) colorResource(id = R.color.white) else colorResource(
                    id = R.color.indicator_background
                )
            val shape = if (currentPage == iteration) RoundedCornerShape(8.dp) else CircleShape
            val width = if (currentPage == iteration) 24.dp else 8.dp
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(shape)
                    .background(color)
                    .height(8.dp)
                    .width(width)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CircularDeterminateIndicator(pagerState: PagerState, currentPage: Int) {
    var currentProgress by remember { mutableStateOf(0.25f) }
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        CircularProgressIndicator(
            progress = 1f,
            modifier = Modifier.width(58.dp),
            color = colorResource(id = R.color.indicator_background),
            strokeWidth = 3.dp
        )
        repeat(pagerState.pageCount) { iteration ->
            currentProgress = 0.25f + (0.25f * currentPage)

            CircularProgressIndicator(
                progress = currentProgress,
                modifier = Modifier.width(58.dp),
                color = Color.White,
                strokeWidth = 3.dp
            )
        }
    }
}