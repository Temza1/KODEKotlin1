package main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.Worker

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onClickReturnButton: () -> Unit,
    worker: Worker
) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .size(0.dp, 250.dp)
        ) {

            IconButton(onClick = { onClickReturnButton() }, modifier.padding(10.dp,22.dp)) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "content description"
                )
            }

            ProfileScreenContent(modifier, worker)


        }
        Box(
            modifier = modifier
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            infoAboutWorker(modifier, worker)
        }
    }
}

@Composable
fun infoAboutWorker(
    modifier: Modifier,
    worker: Worker
) {
    Column {
        Row(
            modifier = modifier.padding(20.dp, 20.dp)
        ) {


            Icon(
                Icons.Filled.Star,
                modifier = Modifier.padding(
                    0.dp,0.dp,10.dp,0.dp,
                ),
                contentDescription = "content description"
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    worker.birthday,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    worker.birthday,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }

        }

        Row(
            modifier = modifier.padding(20.dp, 0.dp)
        ) {

            Icon(
                Icons.Filled.Call,
                modifier = Modifier.padding(
                    0.dp,0.dp,10.dp,0.dp,
                ),
                contentDescription = "content description"
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    worker.phone,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ProfileScreenContent(
    modifier: Modifier,
    worker: Worker
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 40.dp, 0.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                worker.avatarUrl,
                modifier = modifier
                    .padding(10.dp)
                    .size(120.dp)

            )

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${worker.firstName} ${worker.lastName}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
                Text(
                    text = " ${worker.userTag.lowercase()}",
                    fontSize = 22.sp, color = Color.Gray
                )
            }

            Text(
                text = worker.department.replaceFirstChar { it.uppercase() },
                fontSize = 18.sp, color = Color.DarkGray, textAlign = TextAlign.Center
            )

        }
    }
}


//colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    KODEKotlin1Theme {
        ProfileScreen(
            onClickReturnButton = {},
            worker = Worker(
                "456",
                "https://avatars.mds.yandex.net/get-entity_search/2487574/434829330/S600xU_2x",
                "Артём",
                "Затеев",
                "dp",
                "developer",
                "dp",
                "12 ноября 2000",
                "74755787"
            )
        )
    }
}