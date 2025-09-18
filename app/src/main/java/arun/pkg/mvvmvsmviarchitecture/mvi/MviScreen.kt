package arun.pkg.mvvmvsmviarchitecture.mvi

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
fun MviScreen(
    viewModel: MviViewModel = hiltViewModel(),
    onAction: (MviAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state by viewModel.state.collectAsState()
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(
                text = "MVI Screen"
            )
            Button(onClick = { onAction(MviAction.GoToDetails) }) {
                Text(
                    text = "Go to Details"
                )
            }
        }
    }
}