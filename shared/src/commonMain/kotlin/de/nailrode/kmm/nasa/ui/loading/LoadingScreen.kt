package de.nailrode.kmm.nasa.ui.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .wrapContentSize(Alignment.Center),
    ) {
        CircularProgressIndicator()
    }
}
