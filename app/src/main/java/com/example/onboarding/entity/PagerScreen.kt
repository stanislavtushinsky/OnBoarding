package com.example.onboarding.entity

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.onboarding.R
import com.example.onboarding.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreen(
    page: OnBoardingPage,
    onNextPage: () -> Unit,
    pagerState: PagerState
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = page.backgroundColor)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextColumn(
                title = page.title,
                text = page.text
            )
            Image(
                painter = painterResource(id = page.image),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 31.dp, bottom = 14.dp)
                ) {
                    SmallFloatingActionButton(
                        onClick = onNextPage,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(42.dp)
                            .clip(CircleShape),
                        containerColor = Color.White,
                        contentColor = colorResource(id = page.backgroundColor)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.nav_button),
                            contentDescription = "Next"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 23.dp, bottom = 23.dp)
                ) {
                    CircularDeterminateIndicator(
                        pagerState = pagerState,
                        currentPage = pagerState.currentPage
                    )
                }
            }
        }
    }
}


@Composable
fun TextColumn(@StringRes title: Int, @StringRes text: Int) {
    val columnModifier = Modifier.padding(
        start = 24.dp,
        end = 24.dp,
        top = 35.dp,
        bottom = 38.dp
    )

    val textModifier = Modifier.padding(bottom = 12.dp)

    Column(
        modifier = columnModifier
    ) {
        Text(
            text = stringResource(id = title),
            style = Typography.titleLarge,
            modifier = textModifier
        )
        Text(text = stringResource(id = text), style = Typography.bodyLarge)
    }
}