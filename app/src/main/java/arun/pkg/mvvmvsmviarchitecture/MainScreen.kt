package arun.pkg.mvvmvsmviarchitecture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    onMviButtonClick: () -> Unit,
    onMvvmButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onMvvmButtonClick() }) {
            Text(text = "MVVM Screen")
        }

        Button(onClick = { onMviButtonClick() }) {
            Text(text = "MVI Screen")
        }
    }
}