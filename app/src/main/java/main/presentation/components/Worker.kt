package main.presentation.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.Worker
@Composable
fun Worker(
    getProfileInfo: (Worker) -> Unit,
    modifier: Modifier = Modifier,
    worker: Worker) {

    var workerState by remember { mutableStateOf(worker) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(onClick = { getProfileInfo(workerState) })
    ) {
        Image(
            workerState.avatarUrl,
            modifier = modifier
                .padding(2.dp)

        )
        Column (
            modifier = modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
        ) {
            Row {
                Text(text = "${workerState.firstName} ${workerState.lastName}",color = Color.Black,fontWeight = FontWeight.SemiBold)
                Text(text = " ${workerState.userTag.lowercase()}", color = Color.Gray, fontSize = 14.sp)
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
            getProfileInfo = { TODO() },
            worker = Worker(
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





