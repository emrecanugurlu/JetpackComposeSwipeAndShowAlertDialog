package com.emrecnugurlu.swipeandshowalertdialog.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.emrecnugurlu.swipeandshowalertdialog.viewmodel.MyViewModel

@Composable
fun MyAlertCardDesign(onClick: () -> Unit) {
    val myViewModel: MyViewModel = viewModel()
    val timerNumber = myViewModel.countDownTimer.collectAsState(initial = 10)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Alert Dialog Title",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
                IconButton(
                    modifier = Modifier.then(Modifier.size(24.dp)),
                    onClick = onClick
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Exit Button",
                        tint = Color.Gray
                    )
                }
            }
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = "İşleminiz gerçekleştirilemiyor lütfen ${timerNumber.value} saniye sonra tekrar deneyiniz..."
            )
        }

    }
}

@Preview
@Composable
fun MyAlertCardDesignPreview() {
    MyAlertCardDesign() {}
}