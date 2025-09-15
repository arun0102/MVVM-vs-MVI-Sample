package arun.pkg.mvvmvsmviarchitecture.mvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun MvvmScreen(
    viewModel: MvvmViewModel = hiltViewModel(),
    onDetailsButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isLoading by viewModel.isLoading.collectAsState()
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Text(
                text = "MVVM Screen"
            )
            Button(onClick = { onDetailsButtonClick() }) {
                Text(
                    text = "Go to Details"
                )
            }
        }
    }
}