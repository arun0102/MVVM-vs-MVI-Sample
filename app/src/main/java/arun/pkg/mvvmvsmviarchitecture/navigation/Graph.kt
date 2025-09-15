package arun.pkg.mvvmvsmviarchitecture.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import arun.pkg.mvvmvsmviarchitecture.MainScreen
import arun.pkg.mvvmvsmviarchitecture.mvi.MviAction
import arun.pkg.mvvmvsmviarchitecture.mvi.MviDetails
import arun.pkg.mvvmvsmviarchitecture.mvi.MviScreen
import arun.pkg.mvvmvsmviarchitecture.mvvm.MvvmDetails
import arun.pkg.mvvmvsmviarchitecture.mvvm.MvvmScreen

fun NavGraphBuilder.graph(navController: NavController) {
    navigation(
        startDestination = Navigation.Path.PATH_MAIN_SCREEN,
        route = Navigation.Route.GRAPH_MAIN
    ) {
        mainScreen(navController)
        mvvmScreen(navController)
        mvvmDetails()
        mviScreen(navController)
        mviDetails()
    }
}

fun NavGraphBuilder.mainScreen(navController: NavController) {
    composable(
        route = Navigation.Path.PATH_MAIN_SCREEN,
    ) {
        MainScreen(
            onMvvmButtonClick = {
                navController.navigate(Navigation.Path.MVVM_PATH_MVVM_SCREEN)
            },
            onMviButtonClick = {
                navController.navigate(Navigation.Path.MVI_PATH_MVI_SCREEN)
            }
        )
    }
}

fun NavGraphBuilder.mvvmScreen(navController: NavController) {
    composable(
        route = Navigation.Path.MVVM_PATH_MVVM_SCREEN
    ) {
        MvvmScreen {
            navController.navigate(Navigation.Path.MVVM_PATH_MVVM_DETAILS)
        }
    }
}

fun NavGraphBuilder.mvvmDetails() {
    composable(
        route = Navigation.Path.MVVM_PATH_MVVM_DETAILS
    ) {
        MvvmDetails()
    }
}

fun NavGraphBuilder.mviScreen(
    navController: NavController
) {
    composable(
        route = Navigation.Path.MVI_PATH_MVI_SCREEN
    ) {
        MviScreen { action ->
            when (action) {
                MviAction.GoToDetails -> navController.navigate(Navigation.Path.MVI_PATH_MVI_DETAILS)
            }
        }
    }
}

fun NavGraphBuilder.mviDetails() {
    composable(
        route = Navigation.Path.MVI_PATH_MVI_DETAILS
    ) {
        MviDetails()
    }
}
