@file:OptIn(ExperimentalFoundationApi::class)

package main.presentation.mainScreen

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.minimumInteractiveComponentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.Worker
import main.domain.getTabItems
import main.presentation.KodeHomeContent
import main.presentation.ViewModelFactory
import main.presentation.components.ProfileScreen
import main.presentation.components.WorkerList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel(factory = ViewModelFactory(application = Application())),
    getProfileInfo: (Worker) -> Unit
) {
    val state by viewModel.state.collectAsState()

    val tabItems = getTabItems()
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { tabItems.size }


    Scaffold(
        modifier = modifier,
        topBar = {
            Column {
                SearchBar(
                    modifier = modifier
                        .padding(16.dp, 12.dp, 0.dp, 24.dp)
                        .height(52.dp),
                    query = state.searchText,
                    onQueryChange = { MainScreenContract.Event.GetSortWorkers(it) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "content description",
                            modifier = modifier,
                            Color.Gray
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "content description",
                                modifier = modifier,
                                Color.Gray
                            )
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Введи имя, тег, почту...",
                            color = Color.Gray
                        )
                    },
                    onSearch = {},
                    active = false,
                    onActiveChange = {}) {

                }

                ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 16.dp) {
                    tabItems.forEachIndexed { index, item ->
                        Tab(
                            modifier = modifier.height(44.dp),
                            selected = index == selectedTabIndex,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    text = item.title,
                                    fontSize = 18.sp,
                                    color = Color.Gray
                                )
                            },
                            selectedContentColor = Color.Gray
                        )
                    }
                }
            }
        },
        content = { padding ->
            Column(
                modifier = modifier.padding(padding)
            ) {
                LaunchedEffect(selectedTabIndex) {
                    pagerState.animateScrollToPage(selectedTabIndex)
                }
                LaunchedEffect(pagerState.currentPage) {
                    selectedTabIndex = pagerState.currentPage
                }

                HorizontalPager(
                    state = pagerState,
                    modifier = modifier.fillMaxSize()
                ) { index ->
                    Box(modifier = modifier.fillMaxSize()) {
                        WorkerList(
                            modifier = modifier,
                            getProfileInfo,
                            state.workers,
                            tabItems[index].titleForSort
                        )
                    }
                }
            }
        }
    )
}


private fun getMockWorkers(): ArrayList<Worker> {

    val listWorkers = ArrayList<Worker>()
    for (i in 0..20) {
        val worker = Worker(
            "456$i",
            "https://cerenas.club/uploads/posts/2022-12/1671182249_cerenas-club-p-kot-v-chernikh-ochkakh-instagram-48.jpg",
            "Артём$i",
            "Затеев$i",
            "dp$i",
            "developer$i",
            "dp$i",
            "октябрь$i",
            "$i"
        )

        listWorkers.add(worker)
    }
    return listWorkers
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