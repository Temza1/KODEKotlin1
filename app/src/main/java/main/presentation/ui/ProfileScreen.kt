package main.presentation.ui

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
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
import main.domain.WorkerState
import main.presentation.KodeHomeContent
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    workerState: WorkerState
                  ) {

    Column {

        Box(
            modifier = modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .size(0.dp, 250.dp)
        ) {

            Box(
                modifier = modifier.padding(10.dp,20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                IconButton(onClick = { /*TODO*/ },modifier) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack ,
                        contentDescription = "content description"
                    )
                }
            }
            
            Box {
                ProfileScreenContent(modifier,workerState)
            }


        }

        Box(
            modifier = modifier
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            infoAboutWorker(modifier,workerState)
        }
    }


//    Scaffold(
//        modifier = modifier,
//        topBar = { topBar(modifier) },
//        content = { paddingValues ->
//            ProfileScreenContent(modifier = Modifier.padding(paddingValues),workerState) }
//    )

}

@Composable
fun infoAboutWorker(
    modifier: Modifier,
    workerState: WorkerState
) {

    Column {
        Row(
            modifier = modifier.padding(20.dp,20.dp)
        ) {

            Box(
                modifier = modifier.padding(end = 10.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "content description"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    workerState.birthday,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    workerState.birthday,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }

        }

        Row(
            modifier = modifier.padding(20.dp,0.dp)
        ) {
            Box(
                modifier = modifier.padding(end = 10.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "content description"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    workerState.phone,
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
    workerState: WorkerState
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
                workerState.avatarUrl,
                modifier = modifier
                    .padding(10.dp)
                    .size(120.dp)

            )

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${workerState.firstName} ${workerState.lastName}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
                Text(
                    text = " ${workerState.userTag.lowercase()}",
                    fontSize = 22.sp, color = Color.Gray
                )
            }

            Text(text = workerState.department.replaceFirstChar { it.uppercase() },
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
            workerState = WorkerState(
            "456",
            "https://avatars.mds.yandex.net/get-entity_search/2487574/434829330/S600xU_2x",
            "Артём",
            "Затеев",
            "dp",
            "developer",
            "dp",
            "12 ноября 2000",
            "74755787"
        ))
    }
}