package main.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kodekotlin1.R
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.presentation.KodeHomeContent

@Composable
fun Image(
    avatarUrl : String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = avatarUrl,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        modifier = modifier
            .size(84.dp)
            .padding(6.dp)
            .clip(CircleShape)

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KodeHomePreview() {
    KODEKotlin1Theme {
        val mockImage = "https://sopranoclub.ru/images/70-fonov-sinego-tsveta/file44945.jpg"
        Image(mockImage)
    }
}


