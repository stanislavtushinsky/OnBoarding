package com.example.onboarding.entity

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.onboarding.R

sealed class OnBoardingPage(
    @StringRes
    val title: Int,
    @StringRes
    val text: Int,
    @DrawableRes
    val image: Int,
    @ColorRes
    val backgroundColor: Int,
    val route: String
) {
    data object OnBoarding1 : OnBoardingPage(
        title = R.string.title_onboarding_1,
        text = R.string.text_onboarding_1,
        image = R.drawable.img_car1,
        backgroundColor = R.color.onboarding1_background_color,
        route = "onboardingScreen_1"
    )

    data object OnBoarding2 : OnBoardingPage(
        title = R.string.title_onboarding_2,
        text = R.string.text_onboarding_2,
        image = R.drawable.img_car2,
        backgroundColor = R.color.onboarding2_background_color,
        route = "onboardingScreen_2"
    )

    data object OnBoarding3 : OnBoardingPage(
        title = R.string.title_onboarding_3,
        text = R.string.text_onboarding_3,
        image = R.drawable.img_car3,
        backgroundColor = R.color.onboarding3_background_color,
        route = "onboardingScreen_3"
    )

    data object OnBoarding4 : OnBoardingPage(
        title = R.string.title_onboarding_4,
        text = R.string.text_onboarding_4,
        image = R.drawable.img_car4,
        backgroundColor = R.color.onboarding4_background_color,
        route = "onboardingScreen_4"
    )
}