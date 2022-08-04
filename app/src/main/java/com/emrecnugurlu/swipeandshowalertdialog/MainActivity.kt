package com.emrecnugurlu.swipeandshowalertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.emrecnugurlu.swipeandshowalertdialog.ui.theme.SwipeAndShowAlertDialogTheme
import com.emrecnugurlu.swipeandshowalertdialog.view.MyAlertCardDesign
import com.emrecnugurlu.swipeandshowalertdialog.viewmodel.MyViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeAndShowAlertDialogTheme {
                AlertDialogFun()
            }
        }
    }
}

@Composable
fun AlertDialogFun() {
    val openDialog = remember {
        mutableStateOf(false)
    }

    var showMyAlertCard by remember { mutableStateOf(false) }
    val density = LocalDensity.current


    Box {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = showMyAlertCard),
            onRefresh = {
                showMyAlertCard = true
            }) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick =
                            {
                                showMyAlertCard = !showMyAlertCard
                            }
                            ) {
                                Text(text = "Show Alert Dialog")
                            }
                        }
                    }
                }
            )
        }
        AnimatedVisibility(
            visible = showMyAlertCard,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
            MyAlertCardDesign(){
                showMyAlertCard = false
            }
        }
    }

}


@Preview
@Composable
fun PreviewFun() {
    AlertDialogFun()
}
