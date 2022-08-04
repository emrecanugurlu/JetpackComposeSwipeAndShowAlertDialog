package com.emrecnugurlu.swipeandshowalertdialog.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MyViewModel : ViewModel() {

    var countDownTimer = flow<Int> {
        val fromCount = 10
        var count = fromCount
        emit(fromCount)
        while (count > 0){
            delay(1000)
            count--
            emit(count)
        }
    }
}