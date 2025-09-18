package arun.pkg.mvvmvsmviarchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import arun.pkg.mvvmvsmviarchitecture.MainScreen
import arun.pkg.mvvmvsmviarchitecture.mvi.MviAction
import arun.pkg.mvvmvsmviarchitecture.mvi.MviDetails
import arun.pkg.mvvmvsmviarchitecture.mvi.MviScreen
import arun.pkg.mvvmvsmviarchitecture.mvvm.MvvmDetails
import arun.pkg.mvvmvsmviarchitecture.mvvm.MvvmScreen

@Composable
fun Host(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen
    ) {
        mainScreen(navHostController)
        mvvmScreen(navHostController)
        mvvmDetails()
        mviScreen(navHostController)
        mviDetails()
    }
}

fun NavGraphBuilder.mainScreen(navController: NavController) {
    composable<MainScreen> {
        MainScreen(
            onMvvmButtonClick = {
                navController.navigate(MVVMScreen)
            },
            onMviButtonClick = {
                navController.navigate(MVIScreen)
            }
        )
    }
}

fun NavGraphBuilder.mvvmScreen(navController: NavController) {
    composable<MVVMScreen> {
        MvvmScreen {
            navController.navigate(MVVMDetails)
        }
    }
}

fun NavGraphBuilder.mvvmDetails() {
    composable<MVVMDetails> {
        MvvmDetails()
    }
}

fun NavGraphBuilder.mviScreen(
    navController: NavController
) {
    composable<MVIScreen> {
        MviScreen { action ->
            when (action) {
                MviAction.GoToDetails -> navController.navigate(MVIDetails)
            }
        }
    }
}

fun NavGraphBuilder.mviDetails() {
    composable<MVIDetails> {
        MviDetails()
    }
}