package com.example.onboarding.entity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.onboarding.R
import com.example.onboarding.ui.theme.Typography

@Composable
fun ResultPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.result_screen_background_color)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            stringResource(id = R.string.text_result_page),
            style = Typography.titleLarge
        )
    }
}