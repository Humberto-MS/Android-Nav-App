package com.example.navapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navapp.views.CalculatorView
import com.example.navapp.views.DiscountView
import com.example.navapp.views.LotteryView

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost ( navController = navController, startDestination = "Discount" ) {
        composable ( route = "Discount" ) {
            DiscountView ( navController )
        }
        composable ( route = "Calculator" ) {
            CalculatorView ( navController )
        }
        composable ( route = "Lottery" ) {
            LotteryView ( navController )
        }
    }
}