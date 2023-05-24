package de.nailrode.kmm.nasa.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberAsyncImagePainter
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.util.OnBottomReached
import de.nailrode.kmm.nasa.util.generateImageLoader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ApodsScreen(viewModel: ApodViewModel) {
    val apods by viewModel.apods.collectAsState()
    val gridState = rememberLazyStaggeredGridState().apply { OnBottomReached(buffer = 3, viewModel::loadMore) }

    CompositionLocalProvider(
        LocalImageLoader provides generateImageLoader(),
    ) {
        LazyVerticalStaggeredGrid(
            state = gridState,
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalItemSpacing = 4.dp,
            content = {
                items(apods.size) { index ->
                    ApodImage(apods[index])
                }
            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun ApodImage(apod: Apod) {
    val painter = rememberAsyncImagePainter(apod.url)

    Image(
        painter,
        contentDescription = null,
    )
}
