package de.nailrode.kmm.nasa.ui.apods

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberAsyncImagePainter
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.ui.loading.LoadingView
import de.nailrode.kmm.nasa.util.OnBottomReached
import de.nailrode.kmm.nasa.util.generateImageLoader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ApodsScreen(component: ApodsComponent) {
    val apods by component.apods.collectAsState(emptyList())
    val isError by component.isError.collectAsState(false)
    val isLoading by component.isLoading.collectAsState(false)

    val gridState = rememberLazyStaggeredGridState().apply { OnBottomReached(buffer = 0, component::loadMore) }

    CompositionLocalProvider(
        LocalImageLoader provides generateImageLoader(),
    ) {
        Box {
            if (apods.isEmpty() && isLoading) {
                LoadingView()
            }
            if (apods.isNotEmpty() && !isError) {
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
                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
                }
            }
        }
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
