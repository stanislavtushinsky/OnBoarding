package com.example.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboarding.entity.OnBoardingPage
import com.example.onboarding.entity.OnBoardingScreen
import com.example.onboarding.entity.ResultPage

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OnBoardingPage.OnBoarding1.route) {
        composable(route = OnBoardingPage.OnBoarding1.route) {
            OnBoardingScreen(navController)
        }
        composable(route = OnBoardingPage.OnBoarding2.route) {
            OnBoardingScreen(navController)
        }
        composable(route = OnBoardingPage.OnBoarding3.route) {
            OnBoardingScreen(navController)
        }
        composable(route = OnBoardingPage.OnBoarding4.route) {
            OnBoardingScreen(navController)
        }
        composable(route = ResultPage.route) {
            ResultPage()
        }
    }
}

object ResultPage {
    const val route = "resultPage"
}