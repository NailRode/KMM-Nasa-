package de.nailrode.kmm.nasa.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.ImageRequestState
import com.seiko.imageloader.rememberAsyncImagePainter
import de.nailrode.kmm.nasa.apod.repository.Apod

@Composable
fun ApodScreen(apod: Apod) {
    val painter = rememberAsyncImagePainter(apod.url)
    var onImageClicked by remember { mutableStateOf(false) }

    if (!onImageClicked) {
        when (painter.requestState) {
            is ImageRequestState.Loading -> {
                CircularProgressIndicator()
            }

            is ImageRequestState.Failure -> {
            }

            ImageRequestState.Success -> {
                Card {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .wrapContentSize()
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 56.dp)
                            .background(Color(0xFF18122B)),
                    ) {
                        Text(
                            "Picture of the Day",
                            color = Color.White,
                            fontSize = 32.sp,
                            modifier = Modifier.padding(vertical = 16.dp),
                        )
                        Text(
                            text = apod.title,
                            color = Color.White,
                            fontSize = 22.sp,
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Card(shape = CutCornerShape(10.dp)) {
                            Image(
                                painter,
                                null,
                                modifier = Modifier.clickable {
                                    onImageClicked = true
                                },
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = apod.explanation,
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp),
                        )
                    }
                }
            }
        }
    }
}
