package main.presentation.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.WorkerState





@Composable
fun Worker(
    modifier: Modifier = Modifier,
    workerState: WorkerState) {

    Row(modifier = modifier.padding(12.dp) ) {
        Image(
            workerState.avatarUrl,
            modifier = modifier
                .padding(2.dp)

        )
        Column (
            modifier = modifier.align(Alignment.CenterVertically)
        ) {
            Row {
                Text(text = "${workerState.firstName} ${workerState.lastName}",fontWeight = FontWeight.SemiBold)
                Text(text = " ${workerState.userTag.lowercase()}", fontSize = 14.sp, color = Color.Gray)
            }
            Text(text = workerState.department.replaceFirstChar { it.uppercase() }, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkerPreview() {
    KODEKotlin1Theme {
        Worker(
            workerState = WorkerState(
                "456",
                "https://sopranoclub.ru/images/70-fonov-sinego-tsveta/file44945.jpg",
                "Артём",
                "Затеев",
                "dp",
                "developer",
                "dp",
                "октябрь",
                "74755787"
            )
        )
    }
}





