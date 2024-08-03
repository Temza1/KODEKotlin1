package main.presentation.mainScreen

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.Worker
import main.presentation.KodeHomeContent
import main.presentation.ViewModelFactory
import main.presentation.components.ProfileScreen
import main.presentation.components.WorkerList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel(),
    getProfileInfo: (Worker) -> Unit
) {

    val state by viewModel.state.collectAsState()

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        content = { padding ->
            Column(
                modifier = modifier.padding(padding)
            ) {
                WorkerList(modifier = modifier, getProfileInfo, state.workers)
//                if (showBottomSheet) {
//                    ModalBottomSheet(
//                        onDismissRequest = {
//                            showBottomSheet = false
//                        },
//                        sheetState = sheetState
//                    ) {
//                        // Sheet content
//                        Button(onClick = {
//                            if (!sheetState.isVisible) {
//                                showBottomSheet = false
//                            }
//
//                        }) {
//                            Text("Hide bottom sheet")
//                        }
//                    }
//                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
//                    showBottomSheet = true
                }
            )
        }
    )



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KodeHomePreview() {
    KODEKotlin1Theme {
        MainScreen(
            getProfileInfo = {}
        )
    }
}