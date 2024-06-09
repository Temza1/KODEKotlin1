package main.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Image(
    avatarUrl : String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = avatarUrl,
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .padding(6.dp)
            .size(24.dp)
    )
}


