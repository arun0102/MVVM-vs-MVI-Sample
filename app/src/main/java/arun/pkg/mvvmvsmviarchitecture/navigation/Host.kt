package arun.pkg.mvvmvsmviarchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Host(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.Route.GRAPH_MAIN
    ) {
        graph(navHostController)
    }
}